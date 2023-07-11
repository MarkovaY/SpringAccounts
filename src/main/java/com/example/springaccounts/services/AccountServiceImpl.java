package com.example.springaccounts.services;

import com.example.springaccounts.models.Account;
import com.example.springaccounts.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal money, Long id) {

        Optional<Account> accountOpt = accountRepository.findById(id);

        if(accountOpt.isEmpty()){
            throw new IllegalArgumentException("Account is missing");
        }

        Account account = accountOpt.get();
        BigDecimal newBalance = account.getBalance().subtract(money);

        if (newBalance.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Not enough money");
        }

        account.setBalance(newBalance);

        accountRepository.save(account);
    }

    @Override
    public void transferMoney(BigDecimal money, Long id) {

        Optional<Account> accountOpt = accountRepository.findById(id);

        if(accountOpt.isEmpty()){
            throw new IllegalArgumentException("Account is missing");
        }

        if(money.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Negative amount");
        }
        Account account = accountOpt.get();
        BigDecimal newBalance = account.getBalance().add(money);
        account.setBalance(newBalance);

        accountRepository.save(account);
    }
}
