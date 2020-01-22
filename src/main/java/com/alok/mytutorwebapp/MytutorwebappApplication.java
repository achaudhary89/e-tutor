package com.alok.mytutorwebapp;

import com.alok.mytutorwebapp.examplebeans.FakeDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MytutorwebappApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MytutorwebappApplication.class, args);
		FakeDataSource fakeDataSource	=	(FakeDataSource) ctx.getBean(FakeDataSource.class);
		System.out.println(fakeDataSource.getPassword());
	}

}
