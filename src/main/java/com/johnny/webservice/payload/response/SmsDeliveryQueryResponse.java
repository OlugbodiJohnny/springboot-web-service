package com.johnny.webservice.payload.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SmsDeliveryQueryResponse {
    public String resultCode;
    public String resultDesc;
    public Payload payload;
}
