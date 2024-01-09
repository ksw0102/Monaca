package com.dw.Monaca.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dw.Monaca.dto.QandADto;
import com.dw.Monaca.dto.ResponseDto;
import com.dw.Monaca.enumStatus.ResultCode;
import com.dw.Monaca.exception.InvalidRequestException;
import com.dw.Monaca.jwtauthority.model.User;
import com.dw.Monaca.jwtauthority.repository.UserRepository;
import com.dw.Monaca.jwtauthority.util.SecurityUtil;
import com.dw.Monaca.model.QandA;
import com.dw.Monaca.model.QandABin;
import com.dw.Monaca.repository.QandABinRepository;
import com.dw.Monaca.repository.QandARepository;
import com.dw.Monaca.service.QandAService;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class QandAServiceImpl implements QandAService{
	
	private final QandARepository qandaRepository;
	private final UserRepository userRepository;
	private final QandABinRepository qandaBinRepository; 
	

	@Autowired
	public QandAServiceImpl(QandARepository qandaRepository, UserRepository userRepository, QandABinRepository qandaBinRepository) {
		this.qandaRepository = qandaRepository;
		this.userRepository = userRepository;
		this.qandaBinRepository = qandaBinRepository;
	}
	
	public ResponseDto<Void> createQandA(QandADto qandaDto) {
		User user = userRepository.findByLoginId(qandaDto.getUser());
		if (user == null) {
			throw new InvalidRequestException("Invalid User","글쓰기 권한이 없습니다.");
		}
		// QandA객체 생성
		QandA qanda = new QandA();
		qanda.setCreateAt(LocalDateTime.now());
		qanda.setUser(qandaDto.getUser());
		qanda.setLecture(qandaDto.getLecture());
		qanda.setTitle(qandaDto.getTitle());
		qanda.setText(qandaDto.getText());
		qanda.setDisposablePw(qandaDto.getDisposablePw());
		qanda.setIs_hide(qandaDto.isIs_hide());
		
		qandaRepository.save(qanda);
		return new ResponseDto<>(ResultCode.SUCCESS.name(),null, "질문등록이 완료되었습니다.");
	}

	public ResponseDto<List<QandA>> getAllQandA() {
		List<QandA> qandas = qandaRepository.findAll();
		if (qandas.isEmpty()) {
			throw new InvalidRequestException("QandA Empty", "질의응답이 존재하지 않습니다.");
		}
		return new ResponseDto<>(ResultCode.SUCCESS.name(), qandas, ResultCode.SUCCESS.getMsg());
	}

	@Override
	public ResponseDto<QandA> deleteQandA(Long id) {
	    Optional<QandA> optionalQandA = qandaRepository.findById(id);
	    
	    if (optionalQandA.isEmpty()) {
	        throw new InvalidRequestException(Long.toString(id), "해당 질문이 존재하지 않습니다.");
	    }
	    QandA qandA = optionalQandA.get();

	    if (!qandA.getUser().getLoginId().equals(SecurityUtil.getCurrentLoginId())) {
	       throw new InvalidRequestException("loginId", "삭제하려는 id와 글쓴이 id가 일치하지 않습니다.");
	    	
	    } else {
	          
	          QandABin qandaBin = new QandABin();
	          qandaBin.setQandA(qandA);
	          qandaBinRepository.save(qandaBin);
	          
	          qandA.setIs_hide(true);
	          qandaRepository.save(qandA);
	    }

	    return new ResponseDto<>("SUCCESS", null, "해당 질문이 삭제되었습니다.");
	}

	
}
