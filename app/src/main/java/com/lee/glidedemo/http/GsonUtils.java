package com.lee.glidedemo.http;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.lang.reflect.Type;

public class GsonUtils {

	public static Gson GSON = new Gson();

	/**
	 * Gson 解析entity
	 * 
	 * @param json
	 * @param c
	 * @return
	 */
	public static Object asJSONToEntity(String json, Class c) {
		Object obj = GSON.fromJson(json, c);
		return obj;
	}

	public static <T> Object asJSONToT(String json, Class<T> c) {
		Object obj = GSON.fromJson(json, c);
		return obj;
	}

	public static Object asJSONToType(String json, Type type) {
		Object obj = GSON.fromJson(json, type);
		return obj;
	}

	/**
	 * Gson 解析 entitys
	 * 
	 * @param json
	 * @param c
	 * @return
	 */
	public static Object[] asJSONArrayToEntitys(String json, Class c) {
		Object[] obj = (Object[])GSON.fromJson(json, c);
		return obj;
	}

	public static String getValueByKey(String json, String key) {
		JsonObject obj = new JsonParser().parse(json).getAsJsonObject();
		String value = obj.get(key).getAsString();
		return value;
	}

	public static String getNoticeValueByKey(String json, String key) {
		JsonObject obj = new JsonParser().parse(json).getAsJsonObject();
		String value = "";
		if (obj.has(key)) {
			value = obj.get(key).getAsString();
		}
		return value;
	}

	public static JsonArray getArrayJsonByJSON(String json, String key) {
		JsonObject obj = new JsonParser().parse(json).getAsJsonObject();
		JsonArray array = obj.get(key).getAsJsonArray();
		return array;
	}

	public static JsonObject getJsonObjByJSON(String json, String key) {
		JsonObject obj = new JsonParser().parse(json).getAsJsonObject();
		JsonObject jsonObj = obj.get(key).getAsJsonObject();
		return jsonObj;
	}

	public static String toJson(Object obj) {
		return GSON.toJson(obj);
	}

	/**
	 * 是否是json 对象
	 * 
	 * @param json
	 * @return
	 */
	public static boolean isJSONObject(String json) {
		JsonElement jsonElement = new JsonParser().parse(json);
		return jsonElement.isJsonObject();
	}

	/**
	 * 是否是json数组
	 * 
	 * @param json
	 * @return
	 */
	public static boolean isJSONArray(String json) {
		JsonElement jsonElement = new JsonParser().parse(json);
		return jsonElement.isJsonArray();
	}

	public static EventResponseEntity asJSONToResponseEntity(String json) {
		JsonObject obj = new JsonParser().parse(json).getAsJsonObject();
		String code = obj.get("code").getAsString();
		String message = obj.get("message").getAsString();
		JsonElement dataobj = obj.get("data");
		String data = "";
		if (dataobj != null) {
			if (dataobj.isJsonObject())
				data = dataobj.getAsJsonObject().toString();
			else if (dataobj.isJsonArray())
				data = dataobj.getAsJsonArray().toString();
		}
		EventResponseEntity entity = new EventResponseEntity();
		entity.code = code;
		entity.message = message;
		entity.data = data;
		return entity;
	}

}
