//package com.dw.Monaca.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.dw.Monaca.dto.ResponseDto;
//import com.dw.Monaca.model.Reply;
//import com.dw.Monaca.service.impl.ReplyServiceImpl;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:3000", methods = { RequestMethod.GET })
//public class ReplyController {
//	private final ReplyServiceImpl replyServiceImpl;
//
//	@Autowired
//	public ReplyController(ReplyServiceImpl replyServiceImpl) {
//		this.replyServiceImpl = replyServiceImpl;
//	}
//
//	@GetMapping("/api/reply")
//	public ResponseEntity<ResponseDto<List<Reply>>> getAllReply() {
//		return new ResponseEntity<>(replyServiceImpl.getAllReply(), HttpStatus.OK);
//		// replyDto 필요
//	}
//}
