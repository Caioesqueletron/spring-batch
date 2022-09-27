package com.springbatch.arquivolargurafixa.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.arquivolargurafixa.dominio.Cliente;

@Configuration
public class LeituraArquivoLarguraFixaStepConfig {
	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step leituraArquivoLarguraFixaStep(ItemReader<Cliente> leituraArquivoLarguraFixaReader,
			ItemWriter leituraArquivoLarguraFixaWriter) {
		return stepBuilderFactory
				.get("leituraArquivoLarguraFixaStep")
				.chunk(1)
				//.<Cliente, Cliente>chunk(1)
				.reader(leituraArquivoLarguraFixaReader)
				.writer(leituraArquivoLarguraFixaWriter)
				.build();
	}
}
