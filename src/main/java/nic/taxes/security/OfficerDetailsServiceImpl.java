package nic.taxes.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import nic.taxes.entity.Officer;
import nic.taxes.repository.OfficerRepository;

@Service
public class OfficerDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private OfficerRepository officerRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
		Officer officer = officerRepository.findByLoginName(loginName)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found With Email: " + loginName));
		return OfficerDetailsImpl.build(officer);
	}

}
