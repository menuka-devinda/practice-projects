
package com.example.batchprocessing.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "_links",
        "excode",
        "longName",
        "shortName"
})
public class Exchange {

  @JsonProperty("_links")
  private Links_ links;
  @JsonProperty("excode")
  private String excode;
  @JsonProperty("longName")
  private String longName;
  @JsonProperty("shortName")
  private String shortName;

  public Exchange(){

  }

  public Exchange(String shortName, String longName) {
    this.shortName = shortName;
    this.longName = longName;
  }


  @JsonProperty("_links")
  public Links_ getLinks() {
    return links;
  }

  @JsonProperty("_links")
  public void setLinks(Links_ links) {
    this.links = links;
  }

  @JsonProperty("excode")
  public String getExcode() {
    return excode;
  }

  @JsonProperty("excode")
  public void setExcode(String excode) {
    this.excode = excode;
  }

  @JsonProperty("longName")
  public String getLongName() {
    return longName;
  }

  @JsonProperty("longName")
  public void setLongName(String longName) {
    this.longName = longName;
  }

  @JsonProperty("shortName")
  public String getShortName() {
    return shortName;
  }

  @JsonProperty("shortName")
  public void setShortName(String shortName) {
    this.shortName = shortName;
  }

}
