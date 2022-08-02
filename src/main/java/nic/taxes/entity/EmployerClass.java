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
@Table(name = "employer_class")
public class EmployerClass {

	@Id
	@Column(name = "class_cd")
	private Integer classId;

	@Column(name = "class_name")
	private String className;

	@Column(name = "class_descr")
	private String classDescr;
}
