package com.hyderyang.takeaway.config;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MybatisPlus配置类
 * @author Hyder
 * @version 1.0
 * @date 2020/2/7 下午8:56
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.hyderyang.takeaway.mapper")
public class MybatisConfiguration {

	@Bean
	public GlobalConfig globalConfig() {
		GlobalConfig globalConfig = new GlobalConfig();
		globalConfig.setMetaObjectHandler(new BaseMetaHandler());
		return globalConfig;
	}

}
