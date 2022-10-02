package com.johnny.webservice.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Payload {
    public String msisdn;
    public String msgId;
    public String senderId;
    public String account;
    public String result;
}
