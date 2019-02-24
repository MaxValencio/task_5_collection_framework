package net.maxvalencio.task_5_collection_framework;

import java.util.HashMap;
import java.util.Map;

public class ProxyCharFrequencyImpl implements CharFrequency{
	
	private Map<String, String> cache = new HashMap<String, String>();
	
	public String calculateCharFrequency(String line) {
		if(line != null) {
			if(cache.containsKey(line)) {
				return cache.get(line);
			} else {
				CharFrequencyImpl charFrequency = new CharFrequencyImpl();
				String result = charFrequency.calculateCharFrequency(line);
				cache.put(line,result);
				return result;
			}
		}else {
			return "Error!!! Line = null, the line cannot be null.";
		}
	}
	
	public Map<String, String> getCache() {
		return cache;
	}
}
