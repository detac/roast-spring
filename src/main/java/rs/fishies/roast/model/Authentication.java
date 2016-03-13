package rs.fishies.roast.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "AUTHN")
public class Authentication {

	@Id
	@GeneratedValue
	@Column(name = "AUTHN_ID")
	private Long id;

	@Size.List({ @Size(min = 8, message = "The login name field must be at least {min} characters"),
			@Size(max = 16, message = "The login name field must be less than {max} characters") })
	@NotNull
	@Column(name = "LOGIN_NAME", unique = true, length = 16)
	private String loginName;

	@Size.List({ @Size(min = 8, message = "The password field must be at least {min} characters"),
			@Size(max = 16, message = "The password field must be less than {max} characters") })
	@NotNull
	@Column(name = "PWD", length = 16)
	private String password;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="USR_DETAILS_ID", unique=true, nullable=false)
	private UserDetails userDetails;

	public Authentication() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
}
