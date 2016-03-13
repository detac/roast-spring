package rs.fishies.roast.test.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import rs.fishies.roast.model.Authentication;
import rs.fishies.roast.model.UserDetails;
import rs.fishies.roast.repository.AuthenticationRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:jpaContextTest.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
public class AuthenticationRepositoryTest {

	@Autowired
	private AuthenticationRepository authenticationRepository;

	@Test
	public void save() {
		Authentication authentication = new Authentication();
		authentication.setLoginName("malieskimi");
		authentication.setPassword("b4NANANA");

		UserDetails userDetails = new UserDetails();
		userDetails.setNickname("visual556");
		userDetails.setEmail("visual556@yahoo.com");

		authentication.setUserDetails(userDetails);

		Authentication result = authenticationRepository.save(authentication);
		Assert.assertNotNull(result.getId());
	}

	@Test
	@DatabaseSetup(value = "classpath:/dbunit/insertAuthentication.xml")
	public void findByLoginName() {
		Authentication authentication = authenticationRepository.findByLoginName("CleanCode");
		Assert.assertNotNull(authentication);
	}

	@Test
	public void findAllByLoginNames() {
		List<String> loginNames = new ArrayList<>();
		loginNames.add("CleanCode");
		loginNames.add("DeleteMe");

		List<Authentication> result = authenticationRepository.findAllByLoginNames(loginNames);
		Assert.assertEquals(2, result.size());
	}
}
