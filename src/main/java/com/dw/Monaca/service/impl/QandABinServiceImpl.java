package com.dw.Monaca.service.impl;

import com.dw.Monaca.service.QandABinService;

public class QandABinServiceImpl implements QandABinService{

@Service
@Transactional
public class QandABinServiceImpl implements QandABinService{
private final QandABinRepository qandaBinRepository;

@Autowired
public QandABinServiceImpl(QandABinRepository qandaBinRepository) {
this.qandaBinRepository = qandaBinRepository;
}

public ResponseDto<List<QandABin>> getAllQandABin() {
List<QandABin> qandabins = qandabinRepository.findAll();
if (qandabins.isEmpty()) {
throw new InvalidRequestException("QandABin Empty", "질의응답이 존재하지 않습니다.");
}
return new ResponseDto<>(ResultCode.SUCCESS.name(), qandabins, ResultCode.SUCCESS.getMsg());