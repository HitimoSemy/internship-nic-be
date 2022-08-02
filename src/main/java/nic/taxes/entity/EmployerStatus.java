package nic.taxes.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Getter
@Entity
@Table(name = "employer_status")
public class EmployerStatus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "status_cd")
	private Integer statusId;

	@Column(name = "status_name")
	private String statusName;

	@Column(name = "status_descr")
	private String statusDescr;
}
