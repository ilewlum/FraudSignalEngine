package com.MulweliCoding.FraudSignalEngine.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MulweliCoding.FraudSignalEngine.Model.Transaction;
import com.MulweliCoding.FraudSignalEngine.Controller.TransactionDTO;
import com.MulweliCoding.FraudSignalEngine.Services.FraudEngineService;

@RestController
@RequestMapping("/api/v1/fraud-engine")
public class FraudEngineController {
    private FraudEngineService fraudEngineService;

    public FraudEngineController(FraudEngineService fraudEngineService) {
        this.fraudEngineService = fraudEngineService;
    }

    @PostMapping("/evaluate")
    public String evaluateTransaction(@RequestBody TransactionDTO transaction) {
        System.out.println("Received transaction for evaluation: " + transaction.getUserId() + ", " + transaction.getAmount() + ", " + transaction.getLocation() + ", " + transaction.getTimestamp());
        fraudEngineService.evaluateTransaction(new Transaction(
            transaction.getUserId(),
            transaction.getAmount(),
            transaction.getTimestamp(),
            transaction.getLocation()
        ));
        System.out.println("Transaction evaluated.");
        return "Transaction evaluated for fraud.";
    }
}
