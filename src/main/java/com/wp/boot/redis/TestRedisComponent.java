package com.wp.boot.redis;

import javax.annotation.Resource;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
/*
 * redis 增删改
 */
@Component
public class TestRedisComponent {
	@Resource
	private StringRedisTemplate stringRedisTemplate;

	public void set(String key, String val) {
		ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();
		if (!this.stringRedisTemplate.hasKey(key)) {
			ops.set(key, val);
			System.out.println("======set key success");
		} else {
			System.out.println("======this key value is " + ops.get(key));
		}
	}

	public String get(String key) {
		return this.stringRedisTemplate.opsForValue().get(key);
	}

	public void del(String key) {
		this.stringRedisTemplate.delete(key);
	}

}
