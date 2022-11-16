package com.johnny.webservice.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RequestSoapHeaderEnvelope {
    @JsonProperty("ns3:RequestSOAPHeader")
    private RequestSoapHeader requestSoapHeader;
}
