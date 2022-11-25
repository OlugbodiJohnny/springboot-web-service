package com.johnny.webservice.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class NotifySoapHeaderEnvelope {
    @JsonProperty("ns1:NotifySOAPHeader")
    private NotifySoapHeader notifySoapHeader;
}
