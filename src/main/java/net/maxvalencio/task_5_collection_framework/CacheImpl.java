package net.maxvalencio.task_5_collection_framework;

import java.util.HashMap;
import java.util.Map;

public class CacheImpl implements Cache {

	private Map<String, StringBuilder> storage = new HashMap<>();

	public void put(String line, StringBuilder result) {
		storage.put(line, result);
	}

	public StringBuilder get(String list) {
		return storage.get(list);
	}

	public boolean contains(String list) {
		return storage.containsKey(list);
	}
}
