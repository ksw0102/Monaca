package com.dw.Monaca.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dw.Monaca.dto.ResponseDto;
import com.dw.Monaca.enumStatus.ResultCode;
import com.dw.Monaca.exception.InvalidRequestException;
import com.dw.Monaca.model.MessageBin;
import com.dw.Monaca.repository.MessageBinRepository;
import com.dw.Monaca.repository.MessageRepository;
import com.dw.Monaca.service.MessageBinService;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class MessageBinServiceImpl implements MessageBinService{

	private final MessageBinRepository messageBinRepository;
	private final MessageRepository messageRepository;


	@Autowired
	public MessageBinServiceImpl(MessageBinRepository messageBinRepository,MessageRepository messageRepository) {
		this.messageBinRepository = messageBinRepository;
		this.messageRepository = messageRepository;
	}

	public ResponseDto<List<MessageBin>> getAllMessageBin() {
		List<MessageBin> messageBins = messageBinRepository.findAll();
		if (messageBins.isEmpty()) {
			throw new InvalidRequestException("MessageABin Empty", "삭제한 쪽지가 존재하지 않습니다.");
		}
		return new ResponseDto<>(ResultCode.SUCCESS.name(), messageBins, ResultCode.SUCCESS.getMsg());
	}





}