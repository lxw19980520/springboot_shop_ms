package com.qa.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig {
	@Bean // 将组件注册在容器
	public WebMvcConfigurer webMvcConfigurerAdapter() {

		WebMvcConfigurer configurer = new WebMvcConfigurer() {
			// 配置资源映射路径
			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				/**
				 * 资源映射路径 addResourceHandler：访问映射路径 addResourceLocations：资源绝对路径
				 */
				registry.addResourceHandler("/img/**").addResourceLocations("file:D:/uploads/");
			}
		};

		return configurer;
	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.addAllowedOrigin("*"); // 允许任何域名使用
		corsConfiguration.addAllowedHeader("*"); // 允许任何头
		corsConfiguration.addAllowedMethod("*"); // 允许任何方法（post、get等）
		corsConfiguration.setAllowCredentials(true);// 允许凭证
		source.registerCorsConfiguration("/**", corsConfiguration); // 对接口配置跨域设置
		return new CorsFilter(source);
	}

}
