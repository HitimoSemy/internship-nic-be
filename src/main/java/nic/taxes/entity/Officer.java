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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "login_officer")
public class Officer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "officer_id")
	private Integer officerId;

	@Column(name = "login_name", unique = true, nullable = false)
	private String loginName;

	@Column(name = "mobile_number", unique = true, nullable = false)
	private String mobileNumber;

	@Column(name = "officer_password", nullable = false)
	private String password;

	@Column(name = "create_date", nullable = false)
	private LocalDate createDate;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "login_role", referencedColumnName = "role_id", nullable = false)
	private Role role;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "circle", referencedColumnName = "circle_cd", nullable = false)
	private TaxCircle circle;

	public Officer(String loginName, String mobileNumber, String password, LocalDate createDate, TaxCircle circle) {
		this.loginName = loginName;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.createDate = createDate;
		this.circle = circle;
	}

}
