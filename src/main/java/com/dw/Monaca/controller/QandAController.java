package com.dw.Monaca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dw.Monaca.dto.ResponseDto;
import com.dw.Monaca.model.QandA;
import com.dw.Monaca.service.impl.QandAServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:3000", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
public class QandAController {
	private final QandAServiceImpl qandaServiceImpl;

	@Autowired
	public QandAController(QandAServiceImpl qandaServiceImpl) {
 		this.qandaServiceImpl = qandaServiceImpl;
	}

	@GetMapping("/api/qanda")
	public ResponseEntity<ResponseDto<List<QandA>>> getAllQandA() {
		return new ResponseEntity<>(qandaServiceImpl.getAllQandA(), HttpStatus.OK);
		// qandaDto 필요
	}
	
	@PutMapping("/api/qanda/delete/{id}/")
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	public ResponseEntity<ResponseDto<QandA>> deleteQandA(@PathVariable Long id) {
		
		return new ResponseEntity<>(
				qandaServiceImpl.deleteQandA(id),
				HttpStatus.OK);
	}
	
}
