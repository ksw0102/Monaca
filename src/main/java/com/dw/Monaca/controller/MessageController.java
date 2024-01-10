package com.dw.Monaca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dw.Monaca.dto.ResponseDto;
import com.dw.Monaca.model.Message;
import com.dw.Monaca.service.impl.MessageServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:3000", methods = { RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,
		RequestMethod.POST })
public class MessageController {

	private final MessageServiceImpl messageServiceImpl;

	@Autowired
	public MessageController(MessageServiceImpl messageServiceImpl) {
		this.messageServiceImpl = messageServiceImpl;
	}

	@PutMapping("/api/message/delete/{id}")
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	public ResponseEntity<ResponseDto<Message>> deleteMessage(@PathVariable Long id) {

		return new ResponseEntity<>(messageServiceImpl.deleteMessage(id), HttpStatus.OK);
	}

}
