package com.sema4genomics.os.datastore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HealthController {

	private static final String OK = "OS DATASTORE IS UP!";

	@RequestMapping(value = "/health")
	public String healthCheck() {
		return OK;
	}

}
