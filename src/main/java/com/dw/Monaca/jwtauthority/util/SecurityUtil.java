package com.dw.Monaca.jwtauthority.util;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUtil {

	private static final Logger logger = LoggerFactory.getLogger(SecurityUtil.class);

	private SecurityUtil() {
	}

	public static Optional<String> getCurrentName() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication == null) {
			logger.debug("Security Context에 인증 정보가 없습니다.");
			return Optional.empty();
		}

		String name = null;
		if (authentication.getPrincipal() instanceof UserDetails) {
			UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
			name = springSecurityUser.getUsername();
		} else if (authentication.getPrincipal() instanceof String) {
			name = (String) authentication.getPrincipal();
		}
		return Optional.ofNullable(name);
	}
}
