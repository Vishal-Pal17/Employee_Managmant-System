package com.example.demo.security;


import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Map<String, String> users = new HashMap<>();
    static {
        users.put("admin", "{noop}admin123");  // username: admin, password: admin123
        users.put("user", "{noop}user123");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(users.containsKey(username)) {
            return User.builder()
                    .username(username)
                    .password(users.get(username))
                    .roles("USER")
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found: " + username);
        }
    }
}

