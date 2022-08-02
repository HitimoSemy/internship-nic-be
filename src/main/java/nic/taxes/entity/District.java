package nic.taxes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Entity
@Table(name = "district")
public class District {

	@Id
	@Column(name = "district_cd")
	private Integer distId;

	@Column(name = "district_name")
	private String distName;

	public Integer getDistId() {
		return distId;
	}

	public String getDistName() {
		return distName;
	}

}
