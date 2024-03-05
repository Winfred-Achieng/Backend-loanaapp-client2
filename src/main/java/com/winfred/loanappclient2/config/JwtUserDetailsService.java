package com.winfred.loanappclient2.config;


import com.winfred.loanappclient2.model.RegistrationRequest;
import com.winfred.loanappclient2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class JwtUserDetailsService  implements  UserDetailsService {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(" username "+ username);
        RegistrationRequest user = userRepository.findByEmail(username);
        System.out.println(" User test " );
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("USER_ROLE"));
        return new User(username, user.getPassword(), authorityList);
    }

}
