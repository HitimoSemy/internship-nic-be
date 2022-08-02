package nic.taxes.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import nic.taxes.entity.Officer;
import nic.taxes.entity.Role;
import nic.taxes.entity.TaxCircle;

public class OfficerDetailsImpl implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer officerId;

	private String loginName;

	@JsonIgnore
	private String password;

	private Role role;

	private TaxCircle circle;

	public Integer getId() {
		return officerId;
	}

	public Role getRole() {
		return role;
	}

	public TaxCircle getCircle() {
		return circle;
	}

	public OfficerDetailsImpl(Integer officerId, String loginName, String password, Role role, TaxCircle circle) {
		this.officerId = officerId;
		this.loginName = loginName;
		this.password = password;
		this.role = role;
		this.circle = circle;
	}

	public static OfficerDetailsImpl build(Officer officer) {
		return new OfficerDetailsImpl(officer.getOfficerId(), officer.getLoginName(), officer.getPassword(),
				officer.getRole(), officer.getCircle());

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
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
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
