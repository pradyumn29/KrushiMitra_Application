package com.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
@ComponentScan(basePackages = {"com.app.Controller"})
class KrushiMitraApplicationTests {

	@Test
	void contextLoads() {
	}

}
