package rs.fishies.roast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.fishies.roast.model.Authentication;
import rs.fishies.roast.repository.AuthenticationRepository;

@Service("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private AuthenticationRepository authenticationRepository;

	@Transactional
	public Authentication save(Authentication authentication) {
		return authenticationRepository.save(authentication);
	}

	public Authentication find(String loginName) {
		return authenticationRepository.findByLoginName(loginName);
	}
}
