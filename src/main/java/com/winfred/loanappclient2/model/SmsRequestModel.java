package com.winfred.loanappclient2.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SmsRequestModel {

    String message;
    String phoneNumber;

}
