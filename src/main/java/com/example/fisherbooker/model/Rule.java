package com.example.fisherbooker.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Rule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 350)
	private String description;

//	@ManyToOne(cascade=CascadeType.PERSIST)
//	//@JoinColumn(name="adventure")
//	Adventure adventure;

	public Rule() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public static Rule toModel(Rule newRule) {
		Rule rule = new Rule();
		rule.setDescription(newRule.getDescription());
		return rule;
	}

	@Override
	public String toString() {
		return "Rule [id=" + id + ", description=" + description + "]";
	}

}