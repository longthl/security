package com.example.security.Service.Impl;

import com.example.security.Repository.UserInfoRpository;
import com.example.security.model.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserInforDetaiService implements UserDetailsService {

private UserInfoRpository userInfoRpository;
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo=userInfoRpository.findByName(name);
        return userInfo.map(UserInfoUserDetails::new).orElseThrow(() ->new UsernameNotFoundException("user not found: "+name));
    }
}
