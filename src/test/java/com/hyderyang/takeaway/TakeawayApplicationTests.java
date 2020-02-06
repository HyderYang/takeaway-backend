package com.hyderyang.takeaway;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
@Data
class TakeawayApplicationTests {


	@Test
	void contextLoads() {
		String name = "imooc";
		String password = "123";
		log.error("error");
		log.warn("warning");
		log.info("name: {}, password: {}", name, password);
	}

}
