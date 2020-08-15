package com.example.batchprocessing;


import com.example.batchprocessing.domain.Exchange;
import com.example.batchprocessing.domain.Exchanges;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;


public class SMSymbolReader implements ItemReader<Exchange> {

  private final String apiUrl;
  private final RestTemplate restTemplate;

  private List<Exchange> exchangesList;
  private int count = 0;

  public SMSymbolReader(String apiUrl, RestTemplate restTemplate) {
    this.apiUrl = apiUrl;
    this.restTemplate = restTemplate;

  }

  @Override
  public Exchange read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

    Exchange exchange = null;
    if (inialize()) {
      exchangesList = fetchStudentDataFromAPI();
    }
    if(count< exchangesList.size()) {
      exchange = exchangesList.get(count);
      count++;
    }

    return exchange;
  }

  private boolean inialize() {
    return (this.exchangesList == null);
  }

  private List<Exchange> fetchStudentDataFromAPI() {
    ResponseEntity<Exchanges> response = restTemplate.getForEntity(
            apiUrl,
            Exchanges.class
    );
    return response.getBody().getEmbedded().getExchanges();
  }

}
