package com.dw.Monaca.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dw.Monaca.dto.ResponseDto;
import com.dw.Monaca.enumStatus.ResultCode;
import com.dw.Monaca.exception.InvalidRequestException;
import com.dw.Monaca.model.QandABin;
import com.dw.Monaca.repository.QandABinRepository;
import com.dw.Monaca.repository.QandARepository;
import com.dw.Monaca.service.QandABinService;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class QandABinServiceImpl implements QandABinService{

	private final QandABinRepository qandaBinRepository;
	private final QandARepository qandaRepository;


	@Autowired
	public QandABinServiceImpl(QandABinRepository qandaBinRepository, QandARepository qandaRepository) {
		this.qandaBinRepository = qandaBinRepository;
		this.qandaRepository = qandaRepository;
	}
	
	public ResponseDto<List<QandABin>> getAllQandABin() {
		List<QandABin> qandaBins = qandaBinRepository.findAll();
		if (qandaBins.isEmpty()) {
			throw new InvalidRequestException("QandABin Empty", "삭제한 질의응답이 존재하지 않습니다.");
		}
		return new ResponseDto<>(ResultCode.SUCCESS.name(), qandaBins, ResultCode.SUCCESS.getMsg());
	}
}