package ru.rostvertolplc.osapr.helpers;

import java.util.HashMap;

import com.teamcenter.rac.kernel.TCPreferenceService;
import com.teamcenter.rac.kernel.TCSession;

public class PreferenceHelper {

	private static TCPreferenceService service = ((TCSession)com.teamcenter.rac.aifrcp.AIFUtility.getDefaultSession()).getPreferenceService();

	public static String getPreferenceValue(String id) {
		return service.getStringValue(id);
	}

	public static String[] getPreferenceValueArray(String id) {
		return service.getStringValues(id);
	}

	public static HashMap<String, String> getPreferenceValueHashMap(String id, String delim) {

		String[] strList = service.getStringValues(id);
		if (strList == null) {
			return null;
		} else {
			HashMap<String, String> map1 = new HashMap<String, String>();
			int delimLength = delim.length();
			for (String str : strList) {
				int delimPos = str.indexOf(delim);
				if (delimPos > 0) {
					map1.put(str.substring(0,delimPos), str.substring(delimPos+delimLength));
				}
			}
			return map1;
		}
	}

	public static HashMap<String, String> getPreferenceValueHashMap(String id) {
		return getPreferenceValueHashMap(id, "=");
	}
	

}
