package nic.taxes.security;

import java.util.Collection;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import nic.taxes.entity.Citizen;
import nic.taxes.entity.Role;

public class CitizenDetailsImpl implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer citizenId;

	private String loginName;

	@JsonIgnore
	private String password;

	private Role role;

	public CitizenDetailsImpl(Integer citizenId, String loginName, String password, Role role) {
		this.citizenId = citizenId;
		this.loginName = loginName;
		this.password = password;
		this.role = role;
	}

	public static CitizenDetailsImpl build(Citizen citizen) {
		return new CitizenDetailsImpl(citizen.getCitizenId(), citizen.getLoginName(), citizen.getPassword(),
				citizen.getRole());
	}

	public Role getRole() {
		return role;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return null;
	}

	public Integer getId() {
		return citizenId;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return loginName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(citizenId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CitizenDetailsImpl other = (CitizenDetailsImpl) obj;
		return Objects.equals(citizenId, other.citizenId);
	}

}
