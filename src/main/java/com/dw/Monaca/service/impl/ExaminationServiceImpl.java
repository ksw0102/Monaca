package com.dw.Monaca.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dw.Monaca.dto.ResponseDto;
import com.dw.Monaca.enumStatus.ResultCode;
import com.dw.Monaca.exception.InvalidRequestException;
import com.dw.Monaca.jwtauthority.model.User;
import com.dw.Monaca.jwtauthority.repository.UserRepository;
import com.dw.Monaca.model.Examination;
import com.dw.Monaca.repository.ExaminationRepository;
import com.dw.Monaca.service.ExaminationService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ExaminationServiceImpl implements ExaminationService {
	private final ExaminationRepository examinationRepository;
	private final UserRepository userRepository;

	@Autowired
	public ExaminationServiceImpl(ExaminationRepository examinationRepository, UserRepository userRepository) {
		this.examinationRepository = examinationRepository;
		this.userRepository = userRepository;
	}

	@Override
	public ResponseDto<Void> createExamination(Examination examination, String loginId) {
		User user = userRepository.findByLoginId(loginId);
		if (user != null && user.getAuthorities().equals("ROLE_USER")) {
			examinationRepository.save(examination);
			return new ResponseDto<>(ResultCode.SUCCESS.name(), null, ResultCode.SUCCESS.getMsg());
		} else {
			return new ResponseDto<>(ResultCode.UNAUTHORIZED.name(), null, "권한이 없습니다");
		}

	}

	public ResponseDto<List<Examination>> getAllExamination() {
		List<Examination> examinations = examinationRepository.findAll();
		if (examinations.isEmpty()) {
			throw new InvalidRequestException("Examination Empty", "examination이 존재하지 않습니다.");
		}
		return new ResponseDto<>(ResultCode.SUCCESS.name(), examinations, ResultCode.SUCCESS.getMsg());
	}
}