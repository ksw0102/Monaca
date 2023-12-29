package com.dw.Monaca.jwtauthority.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDto {

	@NotNull
	@NotBlank
	@Size(min = 6, max = 15)
	private String user_id; //

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@NotNull
	@NotBlank
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@#$%^&*!])[A-Za-z\\d@#$%^&*!]{8,20}$", message = "영문 숫자 특수문자를 포함한 8~20자리로 입력해주세요")
	private String password; // 비밀번호

	@NotNull
	@NotBlank
	@Size(min = 3, max = 6)
	private String name; // 회원 실명

	@NotNull
	@NotBlank
	@Size(min = 3, max = 50)
	private String nickname; // 사용할 별명

	@NotBlank
	@Pattern(regexp = "^([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))$", message = "날짜형식(YYYY-MM-DD)을 확인해주세요")
	private String birthDate; // 생일!

	@Pattern(regexp = "^(남성|여성)$", message = "남성이나 여성 중 하나를 선택해주세요")
	private String gender;

	@Null
	@Pattern(regexp = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "아이디@사이트이름.com와 같은 형식으로 입력해주세요. / 없다면 공란허용")
	private String email;

	@NotNull
	@NotBlank
	@Size(min = 10, max = 30)
	@Pattern(regexp = "^[\\d]{11}+$", message = "'-' 기호 없이 전화번호를 입력해주세요.")
	private int phone_num;

	public UserDto() {
		super();
	}

	public UserDto(@NotNull @NotBlank @Size(min = 6, max = 15) String user_id,
			@NotNull @NotBlank @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@#$%^&*!])[A-Za-z\\d@#$%^&*!]{8,20}$", message = "영문 숫자 특수문자를 포함한 8~20자리로 입력해주세요") String password,
			@NotNull @NotBlank @Size(min = 3, max = 6) String name,
			@NotNull @NotBlank @Size(min = 3, max = 50) String nickname,
			@NotBlank @Pattern(regexp = "^([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))$", message = "날짜형식(YYYY-MM-DD)을 확인해주세요") String birthDate,
			@Pattern(regexp = "^(남성|여성)$", message = "남성이나 여성 중 하나를 선택해주세요") String gender,
			@Null @Pattern(regexp = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "아이디@사이트이름.com와 같은 형식으로 입력해주세요. / 없다면 공란허용") String email,
			@NotNull @NotBlank @Size(min = 10, max = 30) @Pattern(regexp = "^[\\d]{11}+$", message = "'-' 기호 없이 전화번호를 입력해주세요.") int phone_num,
			Set<AuthorityDto> authorityDtoSet) {
		super();
		this.user_id = user_id;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.birthDate = birthDate;
		this.gender = gender;
		this.email = email;
		this.phone_num = phone_num;
		this.authorityDtoSet = authorityDtoSet;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone_num() {
		return phone_num;
	}

	public void setPhone_num(int phone_num) {
		this.phone_num = phone_num;
	}

	public Set<AuthorityDto> getAuthorityDtoSet() {
		return authorityDtoSet;
	}

	public void setAuthorityDtoSet(Set<AuthorityDto> authorityDtoSet) {
		this.authorityDtoSet = authorityDtoSet;
	}

	private Set<AuthorityDto> authorityDtoSet;

}
