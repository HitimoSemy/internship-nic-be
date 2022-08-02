package nic.taxes.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Getter
@Entity
@Table(name = "tax_circle")
public class TaxCircle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "circle_cd")
	private Integer circleId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "district_cd", referencedColumnName = "district_cd")
	private District district;

	@Column(name = "circle_name")
	private String circleName;
}
