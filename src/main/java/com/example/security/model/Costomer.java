package com.example.security.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Costomer {
    private String id;
    private String name;
    private String phoneNumber;
    private String email;
}
