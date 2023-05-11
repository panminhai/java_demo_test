package com.example.java_demo_test.respository;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.util.CollectionUtils;



public class BaseDao{
	
	@PersistenceContext // Jpa專有的註釋
	private EntityManager etityManager;
	
	// Map(key:只能是"String"型, value: 可多樣型) sql: sql語法
	
	@SuppressWarnings("unchecked")
	// <EntityType>: 泛型寫法, 內部可帶入各種型態的變數
	protected <EntityType> List<EntityType> doQuery(String sql, Map<String, Object>
	params, Class<EntityType> clazz){
		
		// 建立query並設置設置(set)參數, query: 資料庫查詢語句
		Query query = etityManager.createQuery(sql, clazz);
		
		// 防呆
		if(!CollectionUtils.isEmpty(params)) {
			for(Entry<String, Object> item : params.entrySet()) {
				query.setParameter(item.getKey(), item.getValue());
			}
			
//			for(Parameter p: query.getParameters()) {
//				query.setParameter(p, params.get(p.getName()));
//			}
		}
		
		for(Entry<String, Object> item : params.entrySet()) {
			
			query.setParameter(item.getKey(), item.getValue());
		}
		
//		for(Parameter p: query.getParameters()) {
//			query.setParameter(p, params.get(p).getName()));
//		}
//		
//
//		}
		
//		return query.getResultList();
		return doQuery(sql, params, clazz, -1);
		
	}
	
	
	
	// Map(key:只能是"String"型, value: 可多樣型) sql: sql語法
	@SuppressWarnings("unchecked")
	protected <EntityType> List<EntityType> doQuery(String sql, Map<String, Object>
	params, Class<EntityType> clazz, int limitSize){
		
		// 建立query並設置設置(set)參數
//		Query query = etityManager.createQuery(sql, clazz);
//		
//		if(!CollectionUtils.isEmpty(params)) {
//			for(Entry<String, Object> item : params.entrySet()) {
//				query.setParameter(item.getKey(), item.getValue());
//			}
//			
//
//		}
//		
//		if(limitSize > 0) {
//			query.setMaxResults(limitSize);
//		}
	

//		return query.getResultList();
		return doQuery(sql, params, clazz, limitSize, -1);

	}

	/*
	 * limitSize: 限制回傳比數
	 * startPosition: 每頁起始位置
	 */
	@SuppressWarnings("unchecked")
	protected <EntityType> List<EntityType> doQuery(String sql, Map<String, Object>
	params, Class<EntityType> clazz, int limitSize, int startPosition){
		
		// 建立query並設置設置(set)參數
		Query query = etityManager.createQuery(sql, clazz);
		
		if(!CollectionUtils.isEmpty(params)) {
			for(Entry<String, Object> item : params.entrySet()) {
				query.setParameter(item.getKey(), item.getValue());
			}
			
//			for(Parameter p: query.getParameters()) {
//				query.setParameter(p, params.get(p.getName()));
//			}
		}
		if(limitSize > 0) {
			query.setMaxResults(limitSize);
		}
		
		if(startPosition >= 0) {
			query.setFirstResult(startPosition);
		}
	
		return query.getResultList();
	}


	protected int doUpdate (String sql, Map<String, Object> params) {

		Query query = etityManager.createQuery(sql);
		
		
		if(!CollectionUtils.isEmpty(params)) {
			for(Entry<String, Object> item : params.entrySet()) {
				query.setParameter(item.getKey(), item.getValue());
			}
	}
		// 值得類型: Int
		return query.executeUpdate();
		}

}

	
	
