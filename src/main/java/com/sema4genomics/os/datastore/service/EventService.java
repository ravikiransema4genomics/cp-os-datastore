package com.sema4genomics.os.datastore.service;

import com.sema4genomics.os.datastore.dto.ResponseDto;

public interface EventService<T> {

	ResponseDto save(T eventConfigDto);

	ResponseDto update(T eventConfigDto);

	ResponseDto delete(Long id);
	
}
