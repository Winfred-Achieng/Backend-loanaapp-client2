package com.winfred.loanappclient2.service;

import com.winfred.loanappclient2.model.RegistrationRequest;
import com.winfred.loanappclient2.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@Transactional
@AllArgsConstructor
public class RegisterUserService {

    private final UserRepository userRepository;


    public List<RegistrationRequest> getAllRegisteredUsers(){
        return userRepository.findAll();
    }


}
