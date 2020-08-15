package com.example.batchprocessing.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExchangeDto {

  private String excode;

  private String longName;

  private String shortName;

  public ExchangeDto(String excode, String longName, String shortName) {
    this.excode = excode;
    this.longName = longName;
    this.shortName = shortName;
  }

  public String getExcode() {
    return excode;
  }

  public void setExcode(String excode) {
    this.excode = excode;
  }

  public String getLongName() {
    return longName;
  }

  public void setLongName(String longName) {
    this.longName = longName;
  }

  public String getShortName() {
    return shortName;
  }

  public void setShortName(String shortName) {
    this.shortName = shortName;
  }
}
