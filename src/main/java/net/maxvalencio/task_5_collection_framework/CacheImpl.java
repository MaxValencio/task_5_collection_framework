package net.maxvalencio.task_5_collection_framework;

import java.util.HashMap;
import java.util.Map;

public class CacheImpl implements Cache {
	
	private Map<String, String> storage = new HashMap<String, String>();
	
	public void save(String key, String value) {
		storage.put(key, value);
	}
	
	public String getCacheValue(String key) {
		return storage.get(key);
	}
	
	public boolean isKeyContains(String key) {
		return storage.containsKey(key);
	}
}
