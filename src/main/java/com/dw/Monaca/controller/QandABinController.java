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
import com.dw.Monaca.model.QandABin;
import com.dw.Monaca.service.impl.QandABinServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:3000", methods = { RequestMethod.GET })
public class QandABinController {
	private final QandABinServiceImpl qandabinServiceImpl;

	@Autowired
	public QandABinController(QandABinServiceImpl qandabinServiceImpl) {
		this.qandabinServiceImpl = qandabinServiceImpl;

	}

	@GetMapping("/api/qandabin")
	public ResponseEntity<ResponseDto<List<QandABin>>> getAllQandABin() {
		return new ResponseEntity<>(qandabinServiceImpl.getAllQandABin(), HttpStatus.OK);
	}
}
