package com.udemy.parimparjob.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ImprimeParImparWriter {
	
	@Bean
	public ItemWriter<String> imprimeWriter() {
		return itens -> itens.forEach(System.out::println); 
	}

}
