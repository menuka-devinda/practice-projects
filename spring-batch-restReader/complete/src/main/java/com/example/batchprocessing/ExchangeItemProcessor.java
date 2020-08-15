package com.example.batchprocessing;


import com.example.batchprocessing.domain.Exchange;
import com.example.batchprocessing.dto.ExchangeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class ExchangeItemProcessor implements ItemProcessor<Exchange, ExchangeDto> {

	private static final Logger log = LoggerFactory.getLogger(ExchangeItemProcessor.class);



/*
	@Override
	public Exchange process(final Exchange exchange) throws Exception {

*/
/*		List<Exchange> exchangeList = exchanges.getEmbedded().getExchanges();
		Exchange exchange=null;
		//log.info("Converting (" + exchanges + ") into (" ")");
		if (counter < exchangeList.size()) {
			exchange = exchangeList.get(counter);
			counter++;
		}*//*


		return exchange;
	}
*/



	@Override
	public ExchangeDto process(Exchange exchange) throws Exception {
		ExchangeDto exchangeDto=new ExchangeDto(exchange.getExcode(),exchange.getLongName(),exchange.getShortName());
		return exchangeDto;
	}
}
