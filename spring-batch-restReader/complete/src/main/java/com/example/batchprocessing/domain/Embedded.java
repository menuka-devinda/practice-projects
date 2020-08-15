
package com.example.batchprocessing.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "exchanges"
})
public class Embedded {

    @JsonProperty("exchanges")
    private List<Exchange> exchanges = null;

    @JsonProperty("exchanges")
    public List<Exchange> getExchanges() {
        return exchanges;
    }

    @JsonProperty("exchanges")
    public void setExchanges(List<Exchange> exchanges) {
        this.exchanges = exchanges;
    }


}
