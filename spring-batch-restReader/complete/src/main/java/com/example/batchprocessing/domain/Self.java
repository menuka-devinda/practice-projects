
package com.example.batchprocessing.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "href",
    "templated"
})
public class Self {

    @JsonProperty("href")
    private String href;
    @JsonProperty("templated")
    private boolean templated;

    @JsonProperty("href")
    public String getHref() {
        return href;
    }

    @JsonProperty("href")
    public void setHref(String href) {
        this.href = href;
    }

    @JsonProperty("templated")
    public boolean isTemplated() {
        return templated;
    }

    @JsonProperty("templated")
    public void setTemplated(boolean templated) {
        this.templated = templated;
    }

}
