package com.sema4genomics.os.datastore.service;

import com.sema4genomics.os.datastore.dto.ResponseDto;

public interface DispatcherService<T> {

	ResponseDto save(T dispatcherConfigDto);

	ResponseDto update(T dispatcherConfigDto);

	ResponseDto delete(Long id);
	
}
