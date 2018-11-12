package com.sema4genomics.os.datastore.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity.Builder;
import com.google.cloud.datastore.IncompleteKey;
import com.google.cloud.datastore.Key;
import com.sema4genomics.os.datastore.dao.EventDao;
import com.sema4genomics.os.datastore.dto.EventConfigDto;

@Repository("eventRepo")
public class EventDaoImpl implements EventDao<EventConfigDto> {

	private static final String EVENT = "event";

	@Autowired
	private Datastore datastore;

	@Override
	public void save(EventConfigDto eventConfigDto) {
		IncompleteKey key = datastore.newKeyFactory().setKind(EVENT).newKey();
		Builder<IncompleteKey> builder = Entity.newBuilder(key);
		builder.set("type", eventConfigDto.getType()).set("description", eventConfigDto.getDescription()).set("schema",
				eventConfigDto.getSchema());
		datastore.put(builder.build());
	}

	@Override
	public void update(EventConfigDto eventConfigDto) {
		Key key = datastore.newKeyFactory().setKind(EVENT).newKey(eventConfigDto.getId());
		Entity.Builder builder = Entity.newBuilder(key);
		builder.set("type", eventConfigDto.getType()).set("description", eventConfigDto.getDescription()).set("schema",
				eventConfigDto.getSchema());
		datastore.put(builder.build());

	}

	@Override
	public void delete(Long id) {
		Key key = datastore.newKeyFactory().setKind(EVENT).newKey(id);
		datastore.delete(key);

	}

}
