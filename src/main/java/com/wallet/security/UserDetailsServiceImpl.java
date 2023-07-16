package com.wallet.security;

import com.wallet.model.User;
import com.wallet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

import static com.wallet.common.Constants.NOT_FOUND_USERNAME;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user=  userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException(MessageFormat.format(NOT_FOUND_USERNAME, username)));
       return UserDetailsImpl.build(user);


    }
}
