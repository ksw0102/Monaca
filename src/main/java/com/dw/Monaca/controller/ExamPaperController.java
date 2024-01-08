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
import com.dw.Monaca.model.ExamPaper;
import com.dw.Monaca.service.impl.ExamPaperServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET})

public class ExamPaperController {
private final ExamPaperServiceImpl examPaperServiceImpl;

@Autowired
public ExamPaperController(ExamPaperServiceImpl examPaperServiceImpl) {
this.examPaperServiceImpl = examPaperServiceImpl;
}

@GetMapping("/api/exampaper")
@PreAuthorize("hasAnyRole('ADMIN','PROFESSOR')")
public ResponseEntity<ResponseDto<List<ExamPaper>>> getAllExamPaper() {
return new ResponseEntity<>(examPaperServiceImpl.getAllExamPaper(), HttpStatus.OK);
}


}
