package nic.taxes.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import nic.taxes.entity.Role;

@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Getter
@Setter
@AllArgsConstructor
public class CitizenInfoResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer citizenId;
	private String loginName;
	private Role role;

}
