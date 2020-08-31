package com.ceramicthree.ToDoList.Services;

import com.ceramicthree.ToDoList.Models.MyUserDetails;
import com.ceramicthree.ToDoList.Models.User;
import com.ceramicthree.ToDoList.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByUsername(s);

        user.orElseThrow(() -> new UsernameNotFoundException("User with name:" + s + ",does not exist."));

        return user.map(MyUserDetails::new).get();
    }
}
