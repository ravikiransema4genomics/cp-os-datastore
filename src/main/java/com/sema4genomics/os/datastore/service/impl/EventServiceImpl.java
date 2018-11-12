package com.sema4genomics.os.datastore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sema4genomics.os.datastore.dao.EventDao;
import com.sema4genomics.os.datastore.dto.EventConfigDto;
import com.sema4genomics.os.datastore.dto.ResponseDto;
import com.sema4genomics.os.datastore.service.EventService;

@Service("eventService")
public class EventServiceImpl implements EventService<EventConfigDto> {

	private static final String SUCCESS = "SUCCESS";

	@Autowired
	private EventDao<EventConfigDto> dao;

	@Override
	public ResponseDto save(EventConfigDto configDto) {
		dao.save(configDto);
		ResponseDto responseDto = new ResponseDto();
		responseDto.setStatus(SUCCESS);
		return responseDto;
	}

	@Override
	public ResponseDto update(EventConfigDto configDto) {
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
