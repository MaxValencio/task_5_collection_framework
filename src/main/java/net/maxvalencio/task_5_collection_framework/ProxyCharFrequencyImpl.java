package net.maxvalencio.task_5_collection_framework;

public class ProxyCharFrequencyImpl implements CharFrequency {
	
	private CharFrequency charFrequency;
	private Cache cache = new CacheImpl();

	public ProxyCharFrequencyImpl(CharFrequency charFrequency) {
		this.charFrequency = charFrequency;
	}

	public String calculateCharFrequency(String line) {
		if (line != null) {
			if (cache.isKeyContains(line)) {
				return cache.getCacheValue(line);
			} else {
				String result = charFrequency.calculateCharFrequency(line);
				cache.save(line, result);
				return result;
			}
		} else {
			return "Error!!! Line = null, the line cannot be null.";
		}
	}
}
