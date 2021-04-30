package com.boyan.service;

import com.boyan.vo.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=findUserByUserName(s);
        if(user !=null){
            return user;
        }
        throw new UsernameNotFoundException(s+" not found");
    }

    private User findUserByUserName(String s) {
        return new User("admin",new BCryptPasswordEncoder().encode("admin"), Arrays.asList(new SimpleGrantedAuthority("ROLE_VIP")));
    }
}
