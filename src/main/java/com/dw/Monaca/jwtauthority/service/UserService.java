package com.dw.Monaca.jwtauthority.service;

import java.util.Collections;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dw.Monaca.exception.InvalidRequestException;
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
		if (userRepository.findOneWithAuthoritiesByName(userDto.getName()).orElse(null) != null) {
			throw new InvalidRequestException("Duplicated member", "이미 가입되어 있는 유저입니다."); // 가입이 되어있을 시
		}

		Authority authority = new Authority();
		authority.setAuthorityName("ROLE_USER"); // 유저 권한

		User user = new User();
		user.setName(userDto.getName());
		user.setPassword(passwordEncoder.encode(userDto.getPassword())); // 암호화
		user.setNickname(userDto.getNickname());
		user.setAuthorities(Collections.singleton(authority)); // 권한
		user.setActivated(true);
		System.out.println(user.getName());
		return UserDto.from(userRepository.save(user));
	}

	// 유저 정보 받아오기
	@Transactional(readOnly = true)
	public UserDto getUserWithAuthorities(String name) {
		return UserDto.from(userRepository.findOneWithAuthoritiesByName(name)
				.orElseThrow(() -> new InvalidRequestException(name, "member not found")));
	}

	@Transactional(readOnly = true) // 유저와 어드민 상관없이 열람 가능
	public UserDto getCurrentUserWithAuthorities() {
		return UserDto.from(SecurityUtil.getCurrentName().flatMap(userRepository::findOneWithAuthoritiesByName)
				.orElseThrow(() -> new InvalidRequestException("No current user", "Current member not found")));
	}

}
