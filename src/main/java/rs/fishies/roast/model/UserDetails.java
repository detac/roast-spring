package rs.fishies.roast.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "USR_DETAILS")
public class UserDetails {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@NotNull
	@Size(min = 5, max = 16)
	@Column(name = "NICKNAME", unique = true, length = 16)
	private String nickname;

	@NotNull
	@Email
	@Column(name = "EMAIL", unique = true, length = 256)
	private String email;

	public UserDetails() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
