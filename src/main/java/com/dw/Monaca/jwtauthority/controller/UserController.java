package com.dw.Monaca.jwtauthority.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dw.Monaca.dto.ResponseDto;
import com.dw.Monaca.enumStatus.ResultCode;
import com.dw.Monaca.jwtauthority.dto.UserDto;
import com.dw.Monaca.jwtauthority.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000", methods = { RequestMethod.GET })
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/user")
	@PreAuthorize("hasAnyRole('USER','ADMIN','PROFESSOR')")
	public ResponseEntity<ResponseDto<UserDto>> getCurrentUserInfo(HttpServletRequest request) {
		return ResponseEntity.ok(new ResponseDto<>(ResultCode.SUCCESS.name(),
				userService.getCurrentUserWithAuthorities(), ResultCode.SUCCESS.getMsg()));
	}

	@GetMapping("/user/{name}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<ResponseDto<UserDto>> getUserInfo(@PathVariable String name) {
		return ResponseEntity.ok(new ResponseDto<>(ResultCode.SUCCESS.name(), userService.getUserWithAuthorities(name),
				ResultCode.SUCCESS.getMsg()));
	}

//@PostMapping("/signup")
//public ResponseEntity<ResponseDto<UserDto>> signUp(@RequestBody @Valid UserDto userDto) {
//	return ResponseEntity.ok(new ResponseDto<>(
//			
//			))
}
