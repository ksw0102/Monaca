package com.dw.Monaca.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dw.Monaca.dto.ResponseDto;
import com.dw.Monaca.enumStatus.ResultCode;
import com.dw.Monaca.exception.InvalidRequestException;
import com.dw.Monaca.jwtauthority.model.User;
import com.dw.Monaca.jwtauthority.repository.UserRepository;
import com.dw.Monaca.model.Reply;
import com.dw.Monaca.repository.ReplyRepository;
import com.dw.Monaca.service.ReplyService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ReplyServiceImpl implements ReplyService {
	private final ReplyRepository replyRepository;
	private final UserRepository userRepository;

	@Autowired
	public ReplyServiceImpl(ReplyRepository replyRepository, UserRepository userRepository) {
		this.replyRepository = replyRepository;
		this.userRepository = userRepository;
	}

	public ResponseDto<List<Reply>> getAllReply() {
		List<Reply> replies = replyRepository.findAll();
		if (replies.isEmpty()) {
			throw new InvalidRequestException("Reply Empty", "답변이 존재하지 않습니다.");
		}
		return new ResponseDto<>(ResultCode.SUCCESS.name(), replies, ResultCode.SUCCESS.getMsg());
	}

	@Override
	public ResponseDto<Void> createReply(Reply reply) {
		User user = userRepository.findByLoginId(reply.getUser());
		
		if (user == null) {
			throw new InvalidRequestException("Invalid User", "답글을 쓸 수 있는 권한이 없습니다.");
		}
		
		Reply replied = new Reply();
		replied.setTitle(replied.getTitle());
		replied.setText(replied.getText());
		replied.setUser(replied.getUser());
		
		replyRepository.save(replied);
		return new ResponseDto<>(ResultCode.SUCCESS.name(),null, "답변등록이 완료되었습니다.");
	}

	@Override
	public ResponseDto<Long> deleteReply(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}