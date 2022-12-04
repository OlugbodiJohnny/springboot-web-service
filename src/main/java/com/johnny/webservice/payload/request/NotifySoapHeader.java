package com.johnny.webservice.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class NotifySoapHeader {
    @JsonProperty("xmlns:ns1")
    private String xmlnsNs1;
    @JsonProperty("ns1:spRevId")
    private String spRevID;
    @JsonProperty("ns1:spRevpassword")
    private String spRevPassword;
    @JsonProperty("ns1:spId")
    private String spID;
    @JsonProperty("ns1:serviceId")
    private String serviceID;
    @JsonProperty("ns1:traceUniqueID")
    private String traceUniqueID;
    @JsonProperty("ns1:timeStamp")
    private String timeStamp;
    @JsonProperty("ns1:OperatorID")
    private String operatorID;
    @JsonProperty("ns1:linkid")
    private String linkId;

}
