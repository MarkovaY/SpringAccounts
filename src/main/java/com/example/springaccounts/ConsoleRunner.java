package com.example.springaccounts;

import com.example.springaccounts.services.AccountService;
import com.example.springaccounts.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private AccountService accountService;

    private UserService userService;

    public ConsoleRunner(AccountService accountService, UserService userService) {
        this.accountService = accountService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

//        Testing registerUser.
//        User user = new User("Peter Petrov", 35);
//
//        userService.registerUser(user);

//        Testing transferMoney.
//        accountService.transferMoney(BigDecimal.valueOf(25.50), 1l);

//        Testing withdrawMoney with a bigger sum.
//        accountService.withdrawMoney(BigDecimal.valueOf(190), 1l);

//        Testing withdrawMoney with a valid sum.
        accountService.withdrawMoney(BigDecimal.valueOf(50), 1l);
    }
}
