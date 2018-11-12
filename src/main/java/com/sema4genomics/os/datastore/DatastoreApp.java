package com.sema4genomics.os.datastore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sema4genomics.corelibs.logger.Sema4LogManager;

@SpringBootApplication
public class DatastoreApp {
	public static void main(String[] args) {
		Sema4LogManager.initialize("log4j2.xml");
		SpringApplication.run(DatastoreApp.class, args);
	}
}
