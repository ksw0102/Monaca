package com.dw.Monaca.jwtauthority.service;

import java.util.Collections;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dw.Monaca.dto.ResponseDto;
import com.dw.Monaca.enumStatus.ResultCode;
import com.dw.Monaca.exception.InvalidRequestException;
import com.dw.Monaca.jwtauthority.dto.LoginDto;
import com.dw.Monaca.jwtauthority.dto.UserDto;
import com.dw.Monaca.jwtauthority.model.Authority;
import com.dw.Monaca.jwtauthority.model.User;
import com.dw.Monaca.jwtauthority.repository.UserRepository;
import com.dw.Monaca.jwtauthority.util.SecurityUtil;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Transactional
	// 가입하기
	public UserDto signup(UserDto userDto) {
		if (userRepository.findOneWithAuthoritiesByLoginId(userDto.getLoginId()).orElse(null) != null) {
			throw new InvalidRequestException("Duplicated member", "이미 가입되어 있는 유저입니다."); // 가입이 되어있을 시
		}

		Authority authority = new Authority();
		authority.setAuthorityName("ROLE_USER"); // 유저 권한

		User user = new User();
		user.setLoginId(userDto.getLoginId());
		user.setPassword(passwordEncoder.encode(userDto.getPassword())); // 암호화
		user.setName(userDto.getName());
		user.setNickname(userDto.getNickname());
		user.setBirthDate(userDto.getBirthDate());
		user.setGender(userDto.getGender());
		user.setEmail(userDto.getEmail());
		user.setPhoneNum(userDto.getPhoneNum());
		user.setAuthorities(Collections.singleton(authority)); // 권한
		user.setActivated(true);
		System.out.println(user.getLoginId());
		return UserDto.from(userRepository.save(user));
	}

	// 유저 정보 받아오기
	@Transactional(readOnly = true)
	public UserDto getUserWithAuthorities(String loginId) {
		return UserDto.from(userRepository.findOneWithAuthoritiesByLoginId(loginId)
				.orElseThrow(() -> new InvalidRequestException(loginId, "member not found")));
	}

	@Transactional(readOnly = true) // 유저와 어드민 상관없이 열람 가능
	public UserDto getCurrentUserWithAuthorities() {
		return UserDto.from(SecurityUtil.getCurrentLoginId().flatMap(userRepository::findOneWithAuthoritiesByLoginId)
				.orElseThrow(() -> new InvalidRequestException("No current user", "Current member not found")));
	}

	public ResponseDto<Void> login(LoginDto LoginDto) {
		User user = userRepository.findByLoginId(LoginDto.getLoginId());
		if (user != null && user.getPassword().matches(LoginDto.getPassword())) { // memberLoginDto에 있는 loginId,
																					// password와 입력한 값이 일치하는가
			return new ResponseDto<Void>(ResultCode.SUCCESS.name(),
					// "SUCCESS",
					null, "로그인이 성공했습니다.");
		} else {
//		return new BaseResponse<Void>("Fail", null, "ID 또는 PASSWORD가 올바르지 않습니다.");
			throw new InvalidRequestException("Invalid ID / Password", "ID 또는 Password가 올바르지 않습니다.");
		}
	}

}
