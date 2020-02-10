package com.hyderyang.takeaway.config;

/**
 * jackson 配置
 * @author Hyder
 * @version 1.0
 * @date 2020/2/10 下午12:37
 */

import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonConfig {
	@Bean
	public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
		Jackson2ObjectMapperBuilderCustomizer cunstomizer = new Jackson2ObjectMapperBuilderCustomizer() {
			@Override
			public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
				jacksonObjectMapperBuilder.serializerByType(Long.class, ToStringSerializer.instance);
				jacksonObjectMapperBuilder.serializerByType(Long.TYPE, ToStringSerializer.instance);
			}
		};
		return cunstomizer;
	}
}
