package com.dw.Monaca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dw.Monaca.dto.ResponseDto;
import com.dw.Monaca.model.Lecture;
import com.dw.Monaca.service.impl.LectureServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:3000", methods = { RequestMethod.GET, RequestMethod.POST,
		RequestMethod.DELETE })
public class LectureController {
	private final LectureServiceImpl lectureServiceImpl;

	@Autowired
	public LectureController(LectureServiceImpl lectureServiceImpl) {
		this.lectureServiceImpl = lectureServiceImpl;
	}

	@GetMapping("/api/lecture")
	public ResponseEntity<ResponseDto<List<Lecture>>> getAllLecture() {
		return new ResponseEntity<>(lectureServiceImpl.getAllLecture(), HttpStatus.OK);
	}

}
