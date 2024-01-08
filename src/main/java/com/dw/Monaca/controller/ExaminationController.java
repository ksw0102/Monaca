package com.dw.Monaca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dw.Monaca.dto.ResponseDto;
import com.dw.Monaca.model.Examination;
import com.dw.Monaca.service.impl.ExaminationServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:3000", methods = { RequestMethod.GET })
public class ExaminationController {
	private final ExaminationServiceImpl examinationServiceImpl;

	@Autowired
	public ExaminationController(ExaminationServiceImpl examinationServiceImpl) {
		this.examinationServiceImpl = examinationServiceImpl;
	}

	@GetMapping("/api/examination")
	@PreAuthorize("hasAnyRole('USER')")
	public ResponseEntity<ResponseDto<List<Examination>>> getAllExamination() {
		return new ResponseEntity<>(examinationServiceImpl.getAllExamination(), HttpStatus.OK);
	}
}
