package rs.fishies.roast.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import rs.fishies.roast.model.Authentication;

@Repository("authenticationRepository")
public interface AuthenticationRepository extends JpaRepository<Authentication, Long> {

	Authentication findByLoginName(String loginName);
	
	@Query("Select auth from Authentication auth where auth.loginName in ?1")
	List<Authentication> findAllByLoginNames(List<String> loginNames);
}
