package com.dw.Monaca.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dw.Monaca.dto.MessageDto;
import com.dw.Monaca.dto.ResponseDto;
import com.dw.Monaca.enumStatus.ResultCode;
import com.dw.Monaca.exception.InvalidRequestException;
import com.dw.Monaca.jwtauthority.repository.UserRepository;
import com.dw.Monaca.jwtauthority.util.SecurityUtil;
import com.dw.Monaca.model.Message;
import com.dw.Monaca.model.MessageBin;
import com.dw.Monaca.repository.MessageBinRepository;
import com.dw.Monaca.repository.MessageRepository;
import com.dw.Monaca.service.MessageService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

	private final MessageRepository messageRepository;
	private final UserRepository userRepository;
	private final MessageBinRepository messageBinRepository;

	@Autowired
	public MessageServiceImpl(MessageRepository messageRepository, UserRepository userRepository,
			MessageBinRepository messageBinRepository) {
		super();
		this.messageRepository = messageRepository;
		this.userRepository = userRepository;
		this.messageBinRepository = messageBinRepository;
	}
	
	@Override
	public List<Message> getAllMessages() {
		// TODO: 전체 쪽지 목록 조회 로직 작성
		return messageRepository.findAll();
	}
//
//
//	@Override
//	public Optional<Message> getMessageById(Long messageId) {
//		// TODO: 특정 쪽지 ID로 쪽지 조회 로직 작성
//		return messageRepository.findById(messageId);
//	}
//
//	@Override
//	public List<Message> getSentMessagesByLoginId(String loginId) {
//		// TODO: 특정 사용자가 보낸 쪽지 목록 조회 로직 작성
//		return null;
//
//	}
//
//	@Override
//	public List<Message> getReceivedMessagesByLoginId(String receiver) {
//		// TODO: 특정 사용자가 받은 쪽지 목록 조회 로직 작성
//		return null;
//	}
//
//	@Override
//	public void sendMessage(String loginId, String receiver, MessageDto messageDto) {
//		// TODO: 특정 수신자에게 쪽지 전송 로직 작성
//	}
//
//	@Override
//	public void markMessageAsRead(Long messageId) {
//		// TODO: 특정 쪽지를 읽음으로 표시하는 로직 작성
//	}

//	@Override
//	public void deleteAllMessage(Long messageId) {
//		// TODO: 모든 쪽지 삭제 로직 작성
//	}

	
	// TODO: 특정 쪽지 삭제 로직 작성
	@Override
	public ResponseDto<Message> deleteMessage(Long id) {
		Optional<Message> optionalMessage = messageRepository.findById(id);

		if (optionalMessage.isEmpty()) {
			throw new InvalidRequestException(Long.toString(id), "해당 쪽지가 존재하지 않습니다.");
		}
		Message message = optionalMessage.get();

		if (!message.getUser().getLoginId().equals(SecurityUtil.getCurrentLoginId().get())) {
			throw new InvalidRequestException("loginId", "삭제하려는 유저의 id와 쪽지를 쓴 유저의 id가 일치하지 않습니다.");

		} else {
			message.setIs_hide(true);
			messageRepository.save(message);

			MessageBin messageBin = new MessageBin();
			messageBin.setMessage(message);
			messageBinRepository.save(messageBin);

		}

		return new ResponseDto<>("SUCCESS", null, "해당 쪽지가 삭제되었습니다.");
	}

//	@Override
//	public void deleteMessagesByLoginId(String loginId) {
//		// TODO: 특정 사용자가 보낸 쪽지 삭제 로직 작성
//	}
//
//	@Override
//	public void deleteMessagesByReceiver(String receiver) {
//		// TODO: 특정 수신자에게 온 쪽지 삭제 로직 작성
//	}
//
//	@Override
//	public void deleteMessagesByLoginIdAndReceiver(String loginId, String receiver) {
//		// TODO: 특정 사용자가 특정 수신자에게 보낸 쪽지 삭제 로직 작성
//	}
//
//	@Override
//	public void deleteAllMessages() {
//		// TODO Auto-generated method stub
//		
//	}

}
