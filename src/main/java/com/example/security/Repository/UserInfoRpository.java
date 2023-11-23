package com.example.security.Repository;


import com.example.security.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRpository extends JpaRepository<UserInfo,Integer> {
Optional<UserInfo> findByName(String name);
}
