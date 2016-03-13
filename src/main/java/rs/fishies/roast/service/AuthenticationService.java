package rs.fishies.roast.service;

import rs.fishies.roast.model.Authentication;

public interface AuthenticationService {
	
	Authentication save(Authentication authentication);
	
	Authentication find(String loginName);
	
}
