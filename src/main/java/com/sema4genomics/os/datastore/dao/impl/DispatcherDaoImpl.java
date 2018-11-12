package com.sema4genomics.os.datastore.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity.Builder;
import com.google.cloud.datastore.IncompleteKey;
import com.google.cloud.datastore.Key;
import com.sema4genomics.os.datastore.dao.DispatcherDao;
import com.sema4genomics.os.datastore.dto.DispatcherConfigDto;

@Repository("dispatcherRepo")
public class DispatcherDaoImpl implements DispatcherDao<DispatcherConfigDto> {

	private static final String DISPATCHER = "dispatcher";

	@Autowired
	private Datastore datastore;

	@Override
	public void save(DispatcherConfigDto dispatcherConfigDto) {
		IncompleteKey key = datastore.newKeyFactory().setKind(DISPATCHER).newKey();
		Builder<IncompleteKey> builder = Entity.newBuilder(key);
		builder.set("dispatcher", dispatcherConfigDto.getName())
				.set("dispatcher_config", dispatcherConfigDto.getConfig()).set("event_id",
						dispatcherConfigDto.getEventId())
				.set("payload_schema", dispatcherConfigDto.getPayloadSchema());
		datastore.put(builder.build());
	}

	@Override
	public void update(DispatcherConfigDto dispatcherConfigDto) {
		Key key = datastore.newKeyFactory().setKind(DISPATCHER).newKey(dispatcherConfigDto.getId());
		Entity.Builder builder = Entity.newBuilder(key);
		builder.set("dispatcher", dispatcherConfigDto.getName())
				.set("dispatcher_config", dispatcherConfigDto.getConfig())
				.set("event_id", dispatcherConfigDto.getEventId())
				.set("payload_schema", dispatcherConfigDto.getPayloadSchema());
		datastore.put(builder.build());

	}

	@Override
	public void delete(Long id) {
		Key key = datastore.newKeyFactory().setKind(DISPATCHER).newKey(id);
		datastore.delete(key);

	}

}
