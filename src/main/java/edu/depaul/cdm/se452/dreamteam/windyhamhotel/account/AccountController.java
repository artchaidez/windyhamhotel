package edu.depaul.cdm.se452.dreamteam.windyhamhotel.account;

import edu.depaul.cdm.se452.dreamteam.windyhamhotel.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/account")
@CrossOrigin(origins = "http://localhost:8081")
public class AccountController 
{
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping
    public List<Account> getAllAccounts()
    {
        return this.accountRepository.findAll();
    }

    //NOTE: may not be needed?
    @GetMapping("/{id}")
    public Account getContactByID(@PathVariable(value = "id") long accountNumber)
    {
        return this.accountRepository.findById(accountNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with number: " + accountNumber));
    }
    
    
}
