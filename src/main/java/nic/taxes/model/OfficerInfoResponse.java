package nic.taxes.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nic.taxes.entity.Role;
import nic.taxes.entity.TaxCircle;

@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OfficerInfoResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer officerId;
	private String loginName;
	private Role role;
	private TaxCircle circle;

}
