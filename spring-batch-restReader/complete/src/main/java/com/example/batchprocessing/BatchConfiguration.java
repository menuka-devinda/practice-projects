package com.example.batchprocessing;


import com.example.batchprocessing.domain.Exchange;
import com.example.batchprocessing.dto.ExchangeDto;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.util.function.Function;

// tag::setup[]
@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

  @Autowired
  public JobBuilderFactory jobBuilderFactory;

  @Autowired
  public StepBuilderFactory stepBuilderFactory;
  // end::setup[]

  // tag::readerwriterprocessor[]
/*  @Bean
  public FlatFileItemReader<Person> reader() {
    return new FlatFileItemReaderBuilder<Person>()
            .name("personItemReader")
            .resource(new ClassPathResource("sample-data.csv"))
            .delimited()
            .names(new String[]{"firstName", "lastName"})
            .fieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {{
              setTargetType(Person.class);
            }})
            .build();
  }*/

  @Bean
  ItemReader<? extends Exchange> getReader(RestTemplate restTemplate) {

    return new SMSymbolReader("http://shaco:9977/exchanges", restTemplate);
  }

  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }


  @Bean
  public ItemProcessor<? super Exchange, ? extends ExchangeDto> processor() {
    return new ExchangeItemProcessor();
  }

  @Bean
  public JdbcBatchItemWriter<ExchangeDto> writer(DataSource dataSource) {
    return new JdbcBatchItemWriterBuilder<ExchangeDto>()
            .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
            .sql("INSERT INTO exchange (excode,short_name, long_name) VALUES (:excode, :shortName, :longName)")
            .dataSource(dataSource)
            .build();
  }
  // end::readerwriterprocessor[]

  // tag::jobstep[]
  @Bean
  public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
    return jobBuilderFactory.get("importUserJob")
            .incrementer(new RunIdIncrementer())
            .listener(listener)
            .flow(step1)
            .end()
            .build();
  }

  @Bean
  public Step step1(JdbcBatchItemWriter<ExchangeDto> writer) {
    return stepBuilderFactory.get("step1")
            .<Exchange, ExchangeDto>chunk(10)
            .reader(getReader(restTemplate()))
            .processor(processor())
            .writer(writer)
            .build();
  }
  // end::jobstep[]
}
