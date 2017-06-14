package ru.rostvertolplc.osapr.helpers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CollectionHelper {

	public static String[] getHashMapKeys(HashMap<String, String> map1) {
		if (map1.size() == 0 || map1 == null) {
			return null;
		} else {
			String[] listTypes = new String[map1.size()];
			Set<Map.Entry<String, String>> set = map1.entrySet();
			int i = 0;
			for (Map.Entry<String, String> me : set)
				listTypes[i++] = me.getKey();
			return listTypes;
		}
	}

	public static String[] getHashMapValues(HashMap<String, String> map1) {
		if (map1.size() == 0 || map1 == null) {
			return null;
		} else {
			String[] listTypes = new String[map1.size()];
			Set<Map.Entry<String, String>> set = map1.entrySet();
			int i = 0;
			for (Map.Entry<String, String> me : set)
				listTypes[i++] = me.getValue();
			return listTypes;
		}
	}
}
