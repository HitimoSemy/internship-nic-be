package nic.taxes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Getter
@Entity
@Table(name = "act_title")
public class Acts {

	@Id
	@Column(name = "act_cd")
	private Integer actCode;

	@Column(name = "act_name")
	private String actName;

	@Column(name = "act_descr")
	private String actDescr;
}
