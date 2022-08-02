package nic.taxes.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Getter
@Entity
@Table(name = "employee_type")
public class EmployeeTypes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "type_id")
	private Integer typeId;

	@Column(name = "type_name")
	private String typeName;

}
