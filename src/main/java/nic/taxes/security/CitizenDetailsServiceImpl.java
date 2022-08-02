package nic.taxes.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import nic.taxes.entity.Citizen;
import nic.taxes.repository.CitizenRepository;

@Service
public class CitizenDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private CitizenRepository citizenRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
		Citizen citizen = citizenRepository.findByLoginName(loginName)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found With Email: " + loginName));
		return CitizenDetailsImpl.build(citizen);
	}

}
