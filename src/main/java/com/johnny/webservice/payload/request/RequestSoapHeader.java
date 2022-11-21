package com.johnny.webservice.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RequestSoapHeader {
    @JsonProperty("xmlns:ns3")
    private String xmlnsNs1;
    @JsonProperty("ns3:spRevId")
    private String spRevID;
    @JsonProperty("ns3:spPassword")
    private String spPassword;
    @JsonProperty("ns3:spRevpassword")
    private String spRevPassword;
    @JsonProperty("ns3:spId")
    private String spID;
    @JsonProperty("ns3:serviceId")
    private String serviceID;
    @JsonProperty("ns3:traceUniqueID")
    private String traceUniqueID;
    @JsonProperty("ns3:timeStamp")
    private String timeStamp;
    @JsonProperty("ns3:OperatorID")
    private String operatorID;
    @JsonProperty("ns3:linkid")
    private String linkId;
}
