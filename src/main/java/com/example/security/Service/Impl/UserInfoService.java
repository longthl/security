package com.example.security.Service.Impl;

import com.example.security.Repository.UserInfoRpository;
import com.example.security.model.UserInfo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoService implements UserDetailsService{
    private final UserInfoRpository reppsitory;

    public UserInfoService(UserInfoRpository userInfoRpository) {
        this.reppsitory = userInfoRpository;
    }

    @Transactional
    public Optional<UserInfo> findByName(String name) {
        return reppsitory.findByName(name);
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = reppsitory.findByName(name);
        return userInfo.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + name));
    }
}
