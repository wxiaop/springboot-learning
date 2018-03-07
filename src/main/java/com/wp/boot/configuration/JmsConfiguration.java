package com.wp.boot.configuration;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * jms队列配置
 */
@Configuration
public class JmsConfiguration {

	@Bean
	public Queue queue() {
		return new ActiveMQQueue("jms.queue");
	}

}
