package net.maxvalencio.task_5_collection_framework;

import java.util.LinkedHashMap;
import java.util.Map;

public class CharactersCounterImpl implements CharactersCounter {

	public StringBuilder count(String line) {
		if (line == null) {
			throw new IllegalArgumentException("Line = null, the line cannot be null!");
		}
		Map<Character, Integer> charsQuantity = new LinkedHashMap<>();
		char[] symbols = line.toCharArray();
		for (Character symbol : symbols) {
			if (charsQuantity.containsKey(symbol)) {
				charsQuantity.put(symbol, charsQuantity.get(symbol) + 1);
			} else {
				charsQuantity.put(symbol, 1);
			}
		}
		return createResult(line, charsQuantity);
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
