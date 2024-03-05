package com.winfred.loanappclient2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {
    private long id;
    private String Name;
    private String phone;
    private String email;

}
