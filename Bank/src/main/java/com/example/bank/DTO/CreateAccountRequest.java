package com.example.bank.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateAccountRequest {
    private String email;
    private String accountType;


}
