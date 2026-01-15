package com.MulweliCoding.FraudSignalEngine.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MulweliCoding.FraudSignalEngine.Model.Transaction;
import com.MulweliCoding.FraudSignalEngine.Services.FraudEngineService;

@RestController
@RequestMapping("/api/v1/fraud-engine")
public class FraudEngineController {
    private TransactionController transactionController;
    private FraudEngineService fraudEngineService;

    public FraudEngineController(FraudEngineService fraudEngineService, TransactionController transactionController) {
        this.fraudEngineService = fraudEngineService;
        this.transactionController = transactionController;
    }

    @PostMapping("/evaluate")
    public String evaluateTransaction(@RequestBody TransactionDTO transaction) {
        System.out.println("Endpoint /evaluateTransaction called.");
        Transaction newTransaction = new Transaction(
            transaction.getUserId(),
            transaction.getAmount(),
            transaction.getTimestamp(),
            transaction.getLocation()
        );
        System.out.println("Transaction created: " + newTransaction);
        System.out.println();

        fraudEngineService.filterTransactionsByUser(transactionController.getAllTransactions(), newTransaction.getUserId());
        System.out.println("Past transactions filtered for user ID: " + newTransaction.getUserId());
        System.out.println();

        int riskScore = fraudEngineService.evaluateTransaction(newTransaction);
        System.out.println("Transaction evaluated with Risk Score: " + riskScore);
        System.out.println();

        transactionController.addTransaction(newTransaction);
        System.out.println("Transaction added to the transaction list.");
        System.out.println();
        System.out.println();
        return "Transaction evaluated with Risk Score: " + riskScore;
    }
}
