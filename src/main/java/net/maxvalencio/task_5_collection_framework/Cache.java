package net.maxvalencio.task_5_collection_framework;

public interface Cache {

	void save(String key, String value);
	String getCacheValue(String key);
	boolean isKeyContains(String key);
}
