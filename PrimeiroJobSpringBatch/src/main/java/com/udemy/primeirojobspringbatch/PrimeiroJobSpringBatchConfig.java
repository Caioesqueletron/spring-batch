package com.udemy.primeirojobspringbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class PrimeiroJobSpringBatchConfig {
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	public Step imprimeOlaStep() {
		return stepBuilderFactory.get("imprimeOlaStep").tasklet(new Tasklet() {
			@Override
			public RepeatStatus execute(
					StepContribution contribution, 
					ChunkContext chunkContext
			) throws Exception {
				System.out.println(String.format("Olá, mundo!"));
				return RepeatStatus.FINISHED;
			}
		}).build();
	}

	@Bean
	public Job imprimeOlaJob() {
		return jobBuilderFactory.get("imprimeOlaJob").start(imprimeOlaStep()).incrementer(new RunIdIncrementer()).build();
	}
}
