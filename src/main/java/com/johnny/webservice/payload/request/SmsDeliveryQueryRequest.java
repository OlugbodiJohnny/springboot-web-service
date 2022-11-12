package com.johnny.webservice.payload.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SmsDeliveryQueryRequest {
    public String account;
    public String password;
    public String timeStamp;
    public String msisdn;
    public String senderId;
    public String startTime;
    public String endTime;
}
