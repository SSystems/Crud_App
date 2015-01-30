package com.globacomp.ssystem.data.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.dao.DataAccessException;

import com.globacomp.ssystem.common.Configuration;
import com.globacomp.ssystem.data.Createable;
import com.globacomp.ssystem.data.Model;
import com.globacomp.ssystem.data.Modifiable;
import com.globacomp.ssystem.data.Updateable;
import com.globacomp.ssystem.data.dao.ApplicationDAO;

public abstract class AbstractApplicationDAO<T extends Model> implements
		ApplicationDAO<T> {

	public static final Logger logger = Logger
			.getLogger(AbstractApplicationDAO.class.getName());

	@PersistenceContext
	protected EntityManager entityManager;

	protected Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public AbstractApplicationDAO() {

		@SuppressWarnings("rawtypes")
		Class<? extends AbstractApplicationDAO> applicationDAOClass = getClass();
		Type genericSuperclass = applicationDAOClass.getGenericSuperclass();

		ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
		Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
		Type type = actualTypeArguments[0];
		this.entityClass = (Class<T>) type;
	}

	public List<T> findAll() throws DataAccessException {

		String entityClassName = entityClass.getSimpleName();
		String entityClassAlias = entityClassName.toLowerCase()+"1";
		StringBuilder stb = new StringBuilder();
		stb.append("SELECT ");
		stb.append(entityClassAlias);
		stb.append(" FROM ");
		stb.append(entityClassName);
		stb.append(" ");
		stb.append(entityClassAlias);
		stb.append(" WHERE status = :Status ");
		String queryString = stb.toString();
		TypedQuery<T> query = entityManager.createQuery(queryString,
				entityClass);
		query.setParameter("Status", (byte) 1);
		List<T> employees = query.getResultList();

		return employees;
	}

	public T findById(String id) throws DataAccessException {

		return this.entityManager.find(entityClass, id);
	}

	public List<T> findByName(String queryString, String name)
			throws DataAccessException {

		TypedQuery<T> query = entityManager.createQuery(queryString,
				entityClass);
		query.setParameter("Status", (byte) 1);
		query.setParameter("Name", name);
		List<T> list = query.getResultList();

		return list;
	}

	@SuppressWarnings("unchecked")
	public T create(Createable model) throws DataAccessException {
		
		this.entityManager.persist(model);
		this.entityManager.flush();

		return (T) model;
	}

	@SuppressWarnings("unchecked")
	public T update(Updateable model) throws DataAccessException {

		this.entityManager.merge(model);
		this.entityManager.flush();

		return (T) model;
	}

	public void deactivate(Modifiable entity) throws DataAccessException {

		entity.setStatus(Configuration.STATUS.DELETED.getStatus());
		this.entityManager.merge(entity);
	}

	public void persist(T entity) throws DataAccessException {

		this.entityManager.persist(entity);
		this.entityManager.flush();
	}

	public T merge(T entity) throws DataAccessException {

		this.entityManager.merge(entity);
		this.entityManager.flush();

		return (T) entity;
	}

	public void refresh(T entity) throws DataAccessException {

		this.entityManager.refresh(entity);
		this.entityManager.flush();

	}

	public void delete(T entity) throws DataAccessException {

		this.entityManager.remove(entity);
		this.entityManager.flush();

	}
}