package com.udemy.parimparjob.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImprimeParImparConfig {
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step imprimeParImparStep(IteratorItemReader<Integer> contaAteDezReader,
			FunctionItemProcessor<Integer, String> parOuImparProcessor,
			ItemWriter<String> ImprimeParImparWriter
			) {
		return stepBuilderFactory
				.get("imprimeParImparStep")
				.<Integer, String>chunk(1)
				.reader(contaAteDezReader)
				.processor(parOuImparProcessor)
				.writer(ImprimeParImparWriter)
				.build();
	}

}
