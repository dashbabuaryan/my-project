package com.example.bank.Repository;

import com.example.bank.Entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
//import java.util.Optional;

public interface AccountsRepo extends JpaRepository<Accounts, Integer> {
    public Accounts findByAccountNumber(String accountNumber);

    //public Accounts addAccount(Accounts account);

    @Query(value = "SELECT * FROM users WHERE balance > :balance", nativeQuery = true)
    List<Accounts> findBalancegreaterThanNative(@Param("balance") Double balance);


}
