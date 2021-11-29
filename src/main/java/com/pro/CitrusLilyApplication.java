package com.pro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@ImportResource(locations={"classpath:applicationContext.xml"})
public class CitrusLilyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitrusLilyApplication.class, args);
	}

	@Bean
	public MultipartConfigElement multipartConfigElement(){
		MultipartConfigFactory factory=new MultipartConfigFactory();
		//设置上传的文件最大值
		factory.setMaxFileSize(DataSize.parse("50MB"));
		//设置总上传数据总大小
		factory.setMaxRequestSize(DataSize.parse("50MB"));
		return factory.createMultipartConfig();
	}
}
