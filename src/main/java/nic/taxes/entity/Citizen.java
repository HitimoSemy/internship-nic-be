package nic.taxes.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "login_citizen")
public class Citizen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "citizen_id")
	private Integer citizenId;

	@Column(name = "login_name", unique = true, nullable = false)
	private String loginName;

	@Column(name = "mobile_number", unique = true, nullable = false)
	private String mobileNumber;

	@Column(name = "citizen_password", nullable = false)
	private String password;

	@Column(name = "create_date", nullable = false)
	private LocalDate createDate;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "login_role", referencedColumnName = "role_id", nullable = false)
	private Role role;

	public Citizen(String loginName, String mobileNumber, String password, LocalDate createDate) {
		this.loginName = loginName;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.createDate = createDate;
	}

}
