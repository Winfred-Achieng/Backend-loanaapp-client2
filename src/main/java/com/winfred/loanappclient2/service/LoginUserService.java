package com.winfred.loanappclient2.service;

import com.winfred.loanappclient2.exception.UserNotFoundException;
import com.winfred.loanappclient2.model.RegistrationRequest;
import com.winfred.loanappclient2.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginUserService {

    private final UserRepository userRepository;


    private boolean isEmail(String input) {
        return input!=null && input.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$");
    }

    public String getUsernameByEmail(String email) {
        RegistrationRequest user = userRepository.findByEmail(email);
        return user.getName();
    }

    public String getUserNameByEmailOrPhone(String username) {
        RegistrationRequest user;

        if (isEmail(username)) {
            user = userRepository.findByEmail(username);
        } else {
            user = userRepository.findByPhone(username);
        }
        if (user != null) {
            return user.getName();
        } else {
            throw new UserNotFoundException("User not found for the given credentials");

        }
    }
}

