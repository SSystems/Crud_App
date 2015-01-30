package com.globacomp.ssystem.data.dao;

import java.util.List;

import com.globacomp.ssystem.data.Createable;
import com.globacomp.ssystem.data.Model;
import com.globacomp.ssystem.data.Modifiable;
import com.globacomp.ssystem.data.Updateable;

public interface ApplicationDAO<T extends Model> {

	 List<T> findAll();

	 List<T> findByName(String queryString, String name);

	 T findById(String id);

	 T create(Createable model);

	 T update(Updateable model);

	 void deactivate(Modifiable entity);

	 void persist(T entity);

	 T merge(T entity);

	 void refresh(T entity);

	 void delete(T entity);
	 
}
