package com.mongodb;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.gitchina.framework.commons.utils.PropertiesUtils;

import com.mongodb.util.JSON;

/**
 * MongoDB Manager
 * 
 * @author Ken Chau
 * 
 */
@SuppressWarnings("deprecation")
public class MongoDBManager {
	private static Logger log = Logger.getLogger(MongoDBManager.class);
	private static Mongo mg = null;
	private static DB db = null;
	private static String host = PropertiesUtils.getPropertiesByKey("host",
			"mongodb.properties");
	private static String dbName = PropertiesUtils.getPropertiesByKey("dbName",
			"mongodb.properties");
	private static int port = Integer.parseInt(PropertiesUtils
			.getPropertiesByKey("port", "mongodb.properties"));

	private static class InnerHolder {
		static final MongoDBManager INSTANCE = new MongoDBManager();
	}

	/**
	 *      * 实例化      * @return      * @throws Exception      
	 */
	public static MongoDBManager getInstance() throws Exception {
		return InnerHolder.INSTANCE;
	}

	static {
		try {
			mg = new Mongo(host, port);
			MongoOptions opt = mg.getMongoOptions();
			opt.connectionsPerHost = Integer.parseInt(PropertiesUtils
					.getPropertiesByKey("poorSize", "mongodb.properties"));
			opt.threadsAllowedToBlockForConnectionMultiplier = Integer
					.parseInt(PropertiesUtils.getPropertiesByKey("blockSize",
							"mongodb.properties"));
			db = mg.getDB(dbName);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Can't connect MongoDB!");
			e.printStackTrace();
		}
	}

	/**
	 *      * 获取集合（表）      * @param collection      
	 */
	public static DBCollection getCollection(String collection) {
		return db.getCollection(collection);
	}

	/**
	 *      * 插入      * @param collection      * @param map      
	 */
	public void insert(String collection, Map<String, Object> map) {
		try {
			DBObject dbObject = map2Obj(map);
			getCollection(collection).insert(dbObject);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("MongoException:" + e.getMessage());
		}
	}

	/**
	 *      * 插入      * @param collection      * @param map      
	 */
	public void insert(String collection, String json) {
		try {
			DBObject dbObject = (DBObject) JSON.parse(json);
			getCollection(collection).insert(dbObject);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("MongoException:" + e.getMessage());
		}
	}

	/**
	 *      * 删除      * @param collection      * @param map      
	 */
	public void delete(String collection, Map<String, Object> map) {
		DBObject obj = map2Obj(map);
		getCollection(collection).remove(obj);
	}

	public void delete(String collection, String json) {
		DBObject dbObject = (DBObject) JSON.parse(json);
		getCollection(collection).remove(dbObject);
	}

	/**
	 *        * 删除全部        * @param collection        * @param map        
	 */
	public void deleteAll(String collection) {
		List<DBObject> rs = findAll(collection);
		if (rs != null && !rs.isEmpty()) {
			for (int i = 0; i < rs.size(); i++) {
				getCollection(collection).remove(rs.get(i));
			}
		}
	}

	/**
	 *      * 批量删除      * @param collection      * @param list      
	 */
	public void deleteBatch(String collection, List<Map<String, Object>> list) {
		if (list == null || list.isEmpty()) {
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			getCollection(collection).remove(map2Obj(list.get(i)));
		}
	}

	/**
	 *      * 计算满足条件条数      * @param collection      * @param map      
	 */
	public long getCount(String collection, Map<String, Object> map) {
		return getCollection(collection).getCount(map2Obj(map));
	}

	public long getCount(String collection, String json) {
		return getCollection(collection).getCount((DBObject) JSON.parse(json));
	}

	/**
	 *      * 计算集合总条数      * @param collection      * @param map      
	 */
	public long getCount(String collection) {
		return getCollection(collection).find().count();
	}

	/**
	 *      * 更新      * @param collection      * @param setFields      * @param
	 * whereFields      
	 */
	public void update(String collection, Map<String, Object> setFields,
			Map<String, Object> whereFields) {
		DBObject obj1 = map2Obj(setFields);
		DBObject obj2 = map2Obj(whereFields);
		getCollection(collection).updateMulti(obj1, obj2);
	}

	public void update(String collection, String setFieldsJson,
			String whereFieldsJson) {
		DBObject obj1 = (DBObject) JSON.parse(setFieldsJson);
		DBObject obj2 = (DBObject) JSON.parse(whereFieldsJson);
		getCollection(collection).updateMulti(obj1, obj2);
	}

	/**
	 *      * 查找对象（根据主键_id）      * @param collection      * @param _id      
	 */
	public DBObject findById(String collection, String _id) {
		DBObject obj = new BasicDBObject();
		obj.put("_id", ObjectId.massageToObjectId(_id));
		return getCollection(collection).findOne(obj);
	}

	/**
	 *      * 查找集合所有对象      * @param collection      
	 */
	public List<DBObject> findAll(String collection) {
		return getCollection(collection).find().toArray();
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> findAll(Class<T> clazz, String collection) {
		DBCollection c = getCollection(collection);
		c.setObjectClass(clazz);
		return (List<T>) c.find();
	}

	/**
	 *      * 查找（返回一个对象）      * @param map      * @param collection      
	 */
	public DBObject findOne(String collection, Map<String, Object> map) {
		DBCollection coll = getCollection(collection);
		return coll.findOne(map2Obj(map));
	}

	@SuppressWarnings("unchecked")
	public <T> T findOne(Class<T> clazz, String collection,
			Map<String, Object> map) {
		DBCollection coll = getCollection(collection);
		coll.setObjectClass(clazz);
		return (T) coll.findOne(map2Obj(map));
	}

	public DBObject findOne(String collection, String json) {
		DBCollection coll = getCollection(collection);
		return coll.findOne((DBObject) JSON.parse(json));
	}

	@SuppressWarnings("unchecked")
	public <T> T findOne(Class<T> clazz, String collection, String json) {
		DBCollection coll = getCollection(collection);
		coll.setObjectClass(clazz);
		return (T) coll.findOne((DBObject) JSON.parse(json));
	}

	/**
	 *      * 查找（返回一个List<DBObject>）      * @param <DBObject>      * @param map
	 *      * @param collection      * @throws Exception      
	 */
	public List<DBObject> find(String collection, Map<String, Object> map)
			throws Exception {
		DBCollection coll = getCollection(collection);
		DBCursor c = coll.find(map2Obj(map));
		if (c != null)
			return c.toArray();
		else
			return null;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> find(Class<T> clazz,String collection, Map<String, Object> map)
			throws Exception {
		DBCollection coll = getCollection(collection);
		coll.setObjectClass(clazz);
		DBCursor c = coll.find(map2Obj(map));
		if (c != null)
			return (List<T>) c;
		else
			return null;
	}

	public List<DBObject> find(String collection, String json) throws Exception {
		DBCollection coll = getCollection(collection);
		DBCursor c = coll.find((DBObject) JSON.parse(json));
		if (c != null)
			return c.toArray();
		else
			return null;
	}
	@SuppressWarnings("unchecked")
	public <T> List<T> find(Class<T> clazz,String collection, String json)
			throws Exception {
		DBCollection coll = getCollection(collection);
		coll.setObjectClass(clazz);
		DBCursor c = coll.find((DBObject) JSON.parse(json));
		if (c != null)
			return (List<T>) c;
		else
			return null;
	}
	private DBObject map2Obj(Map<String, Object> map) {
		DBObject ob = new BasicDBObject();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			ob.put(entry.getKey(), entry.getValue());
		}
		return ob;
	}

}
