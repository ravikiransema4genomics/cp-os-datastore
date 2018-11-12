package com.sema4genomics.os.datastore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sema4genomics.os.datastore.dao.DispatcherDao;
import com.sema4genomics.os.datastore.dto.DispatcherConfigDto;
import com.sema4genomics.os.datastore.dto.ResponseDto;
import com.sema4genomics.os.datastore.service.DispatcherService;

@Service("dispatcherService")
public class DispatcherServiceImpl
		implements DispatcherService<DispatcherConfigDto> {

	private static final String SUCCESS = "SUCCESS";

	@Autowired
	private DispatcherDao<DispatcherConfigDto> dao;

	@Override
	public ResponseDto save(DispatcherConfigDto configDto) {
		dao.save(configDto);
		ResponseDto responseDto = new ResponseDto();
		responseDto.setStatus(SUCCESS);
		return responseDto;
	}

	@Override
	public ResponseDto update(DispatcherConfigDto configDto) {
		dao.update(configDto);
		ResponseDto responseDto = new ResponseDto();
		responseDto.setStatus(SUCCESS);
		return responseDto;
	}

	@Override
	public ResponseDto delete(Long id) {
		dao.delete(id);
		ResponseDto responseDto = new ResponseDto();
		responseDto.setStatus(SUCCESS);
		return responseDto;

	}

}
