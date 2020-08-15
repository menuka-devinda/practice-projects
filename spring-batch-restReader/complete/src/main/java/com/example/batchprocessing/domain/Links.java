
package com.example.batchprocessing.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "self",
    "find"
})
public class Links {

    @JsonProperty("self")
    private Self self;
    @JsonProperty("find")
    private Find find;

    @JsonProperty("self")
    public Self getSelf() {
        return self;
    }

    @JsonProperty("self")
    public void setSelf(Self self) {
        this.self = self;
    }

    @JsonProperty("find")
    public Find getFind() {
        return find;
    }

    @JsonProperty("find")
    public void setFind(Find find) {
        this.find = find;
    }


}
