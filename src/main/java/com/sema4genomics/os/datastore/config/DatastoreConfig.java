package com.sema4genomics.os.datastore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;

@Configuration
public class DatastoreConfig {

	@Bean
	public Datastore datastore() {
		return DatastoreOptions.getDefaultInstance().getService();
	}


}
