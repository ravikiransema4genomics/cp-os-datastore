package com.sema4genomics.os.datastore.dto;

public class RuleConfigDto {

	private Long id;
	private String ruleText;

	public RuleConfigDto(String ruleText) {
		super();
		this.ruleText = ruleText;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRuleText() {
		return ruleText;
	}

	public void setRuleText(String ruleText) {
		this.ruleText = ruleText;
	}

}
