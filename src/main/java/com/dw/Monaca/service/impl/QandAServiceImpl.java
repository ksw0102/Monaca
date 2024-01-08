package com.dw.Monaca.service.impl;

import com.dw.Monaca.service.QandAService;

public class QandAServiceImpl implements QandAService{

@Service
@Transactional
public class QandAServiceImpl implements QandAService{
private final QandARepository qandaRepository;

@Autowired
public QandAServiceImpl(QandARepository qandaRepository) {
this.qandaRepository = qandaRepository;
}

public ResponseDto<List<QandA>> getAllQandA() {
List<QandA> qandas = qandaRepository.findAll();
if (qandas.isEmpty()) {
throw new InvalidRequestException("QandA Empty", "질의응답이 존재하지 않습니다.");
}
return new ResponseDto<>(ResultCode.SUCCESS.name(), qandas, ResultCode.SUCCESS.getMsg());