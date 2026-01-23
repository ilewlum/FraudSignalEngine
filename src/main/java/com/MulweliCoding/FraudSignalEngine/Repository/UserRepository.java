package com.MulweliCoding.FraudSignalEngine.Repository;

import com.MulweliCoding.FraudSignalEngine.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
 
}
