package com.sema4genomics.os.datastore.dto;

public class DispatcherConfigDto {

	private Long id;
	
	private String name;

	private String config;

	private Long eventId;

	private String payloadSchema;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getPayloadSchema() {
		return payloadSchema;
	}

	public void setPayloadSchema(String payloadSchema) {
		this.payloadSchema = payloadSchema;
	}

}
