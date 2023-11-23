package com.example.security.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="nguoidung")
@Builder
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;
    @Column(name="Name")
    private String name;
    @Column(name="Password")
    private String password;
    @Column(name="Email")
    private String email;
    @Column(name="Roles")
    private String roles;
}
