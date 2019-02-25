package net.maxvalencio.task_5_collection_framework;

import java.util.LinkedHashMap;
import java.util.Map;

public class CharactersCounterImpl implements CharactersCounter {

	public StringBuilder count(String line) {
		Map<Character, Integer> charsAndQuantity = new LinkedHashMap<Character, Integer>();
		if(line == null) {
			throw new IllegalArgumentException("Line = null, the line cannot be null!");
		} 
		char[] symbols = line.toCharArray();
		for (Character symbol : symbols) {
			if(charsAndQuantity.containsKey(symbol)) {
				charsAndQuantity.put(symbol, charsAndQuantity.get(symbol) + 1);
			} else {
				charsAndQuantity.put(symbol, 1);
			}
		}
		return createResult(line, charsAndQuantity);
	}

	private StringBuilder createResult(String line, Map<Character, Integer> storage) {
		StringBuilder result = new StringBuilder();
		result.append(line).append("\n");
		for (Map.Entry<Character, Integer> entry : storage.entrySet()) {
			result.append("\"" + entry.getKey() + "\"" + " - " + entry.getValue() + "\n");
		}
		return result;
	}
}
