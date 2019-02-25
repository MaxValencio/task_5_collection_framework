package net.maxvalencio.task_5_collection_framework;

public interface Cache {

	void put(String line, StringBuilder result);
	
	StringBuilder get(String line);
	
	boolean contains(String line);
}
