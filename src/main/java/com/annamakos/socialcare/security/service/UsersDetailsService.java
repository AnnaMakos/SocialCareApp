package com.annamakos.socialcare.security.service;

import com.annamakos.socialcare.api.model.User;
import com.annamakos.socialcare.api.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UsersDetailsService implements UserDetailsService {

    private UserRepository userRepository;
    public UsersDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found." + username));
        return UserPrinciple.build(user);
    }
}
