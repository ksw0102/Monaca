package com.dw.Monaca.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dw.Monaca.dto.ResponseDto;
import com.dw.Monaca.enumStatus.ResultCode;
import com.dw.Monaca.exception.InvalidRequestException;
import com.dw.Monaca.model.Lecture;
import com.dw.Monaca.repository.LectureRepository;
import com.dw.Monaca.service.LectureService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LectureServiceImpl implements LectureService {
	private final LectureRepository lectureRepository;

	@Autowired
	public LectureServiceImpl(LectureRepository lectureRepository) {
		this.lectureRepository = lectureRepository;
	}

	public ResponseDto<List<Lecture>> getAllLecture() {
		List<Lecture> lectures = lectureRepository.findAll();
		if (lectures.isEmpty()) {
			throw new InvalidRequestException("Lecture Empty", "강의가 존재하지 않습니다.");
		}
		return new ResponseDto<>(ResultCode.SUCCESS.name(), lectures, ResultCode.SUCCESS.getMsg());
	}
}
