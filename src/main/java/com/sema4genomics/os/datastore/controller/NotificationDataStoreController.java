package com.sema4genomics.os.datastore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sema4genomics.os.datastore.dto.DispatcherConfigDto;
import com.sema4genomics.os.datastore.dto.EventConfigDto;
import com.sema4genomics.os.datastore.dto.ResponseDto;
import com.sema4genomics.os.datastore.service.DispatcherService;
import com.sema4genomics.os.datastore.service.EventService;

@RestController
@RequestMapping("/cp-os-datastore")
public class NotificationDataStoreController {

	@Autowired
	private EventService<EventConfigDto> eventService;
	
	@Autowired
	private DispatcherService<DispatcherConfigDto> dispatcherService;

	@RequestMapping(value = "/notification/event", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public ResponseDto create(@RequestBody @Valid EventConfigDto config) {
		return eventService.save(config);
	}

	@RequestMapping(value = "/notification/event", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public ResponseDto update(@RequestBody @Valid EventConfigDto config) {
		return eventService.update(config);
	}

	@RequestMapping(value = "/notification/event/{id}", method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	public ResponseDto deleteEvent(@PathVariable("id") Long id) {
		return eventService.delete(id);
	}

	@RequestMapping(value = "/notification/dispatcher", method = RequestMethod.POST)
	public void create(DispatcherConfigDto config) {
		dispatcherService.save(config);
	}

	@RequestMapping(value = "/notification/dispatcher", method = RequestMethod.PUT)
	public void update(DispatcherConfigDto config) {
		dispatcherService.update(config);
	}

	@RequestMapping(value = "/notification/dispatcher/{id}", method = RequestMethod.DELETE)
	public void deleteDispatcher(@PathVariable("id") Long id) {
		dispatcherService.delete(id);
	}


}
