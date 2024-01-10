package com.dw.Monaca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.dw.Monaca.dto.ResponseDto;
import com.dw.Monaca.model.Message;
import com.dw.Monaca.service.impl.MessageServiceImpl;

public class MessageController {

	 private final MessageServiceImpl messageService;

	    @Autowired
	    public MessageController(MessageServiceImpl messageService) {
	        this.messageService = messageService;
	    }
	    
	    
	@PutMapping("/api/message/delete/{id}")
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	public ResponseEntity<ResponseDto<Message>> deleteMessage(@PathVariable Long id) {
		
		return new ResponseEntity<>(
				messageService.deleteMessage(id),
				HttpStatus.OK);
	}
	
}
