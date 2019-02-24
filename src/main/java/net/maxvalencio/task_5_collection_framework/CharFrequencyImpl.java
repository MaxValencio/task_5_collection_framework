package net.maxvalencio.task_5_collection_framework;

import java.util.LinkedHashMap;
import java.util.Map;

public class CharFrequencyImpl implements CharFrequency {

	public String calculateCharFrequency(String line) {
		Map<Character, Integer> storage = new LinkedHashMap<Character, Integer>();
		if (line != null) {
			for (Character symbol : line.toCharArray()) {
				Integer count = storage.get(symbol);
				int newCount = (count == null ? 1 : count + 1);
				storage.put(symbol, newCount);
			}
			return createStringResult(line, storage);
		} else {
			return "Error!!! Line = null, the line cannot be null.";
		}
	}

	private String createStringResult(String line, Map<Character, Integer> storage) {
		StringBuilder result = new StringBuilder();
		result.append(line).append("\n");
		for (Map.Entry<Character, Integer> entry : storage.entrySet()) {
			result.append("\"" + entry.getKey() + "\"" + " - " + entry.getValue() + "\n");
		}
		return result.toString();
	}
}
