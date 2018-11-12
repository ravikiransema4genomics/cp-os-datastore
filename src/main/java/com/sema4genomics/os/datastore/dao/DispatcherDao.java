package com.sema4genomics.os.datastore.dao;

public interface DispatcherDao<T> {

	void save(T t);

	void update(T t);

	void delete(Long id);

}
