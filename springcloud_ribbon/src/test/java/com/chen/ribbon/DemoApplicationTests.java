package com.chen.ribbon;


import com.chen.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
    User user;

	@Test
	void contextLoads() {
		Map<String, Integer> map = new HashMap<>();
		map.put("a", 1);
		String s = "aaa";
		System.out.println(map.containsKey(s.charAt(0)));
	}

	@Test
	public void test(){

		System.out.println(user.getId());
		//Assert.assertEquals();
	}

}
