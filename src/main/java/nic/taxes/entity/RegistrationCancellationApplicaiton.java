package nic.taxes.entity;

import java.io.Serializable;
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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "registration_cancellation_application")
public class RegistrationCancellationApplicaiton implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cancel_application_id")
	private Integer regtCancelId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "citizen_id", referencedColumnName = "citizen_id", nullable = false)
	private Citizen citizen;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "regt_id", referencedColumnName = "regt_id")
	private Registration registration;

	@Column(name = "remarks")
	private String Remarks;

	@Column(name = "status")
	private Boolean Status;

	@Column(name = "request_date")
	private LocalDate requestDate;
}
