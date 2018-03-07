package com.wp.boot;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.wp.boot.component.JmsComponent;
import com.wp.boot.redis.TestRedisComponent;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWebApplicationTests {
	@Resource
	private TestRedisComponent redisComponent;
	@Resource
	private JmsComponent JmsComponent;

	@Test
	public void redisTest() {
		redisComponent.set("Hello", "Value");
		redisComponent.get("Hello");
		redisComponent.del("Hello");
	}
	
	@Test
	public void send() {
		JmsComponent.send("hello world");
	}

}
