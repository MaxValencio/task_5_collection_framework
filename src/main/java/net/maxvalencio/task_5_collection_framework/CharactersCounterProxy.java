package net.maxvalencio.task_5_collection_framework;

public class CharactersCounterProxy implements CharactersCounter {
	
	private CharactersCounter counter = new CharactersCounterImpl();
	private Cache cache = new CacheImpl();

	public StringBuilder count(String line) {
		if(line == null) {
			throw new IllegalArgumentException("Line = null, the line cannot be null");
		}
		if (cache.contains(line)) {
			return cache.get(line);
		} else {
			StringBuilder result = new StringBuilder();
			result.append(counter.count(line).toString());
			cache.put(line, result);
			return result;
		}
	}
}
