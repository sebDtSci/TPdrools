package util;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Util {
    	private static Logger LOGGER = LoggerFactory.getLogger(Util.class);

	public static void debug(String s) {
		LOGGER.debug(s);
	}

	public static boolean estRenseigne(Object o) {
		if (o == null)
			return false;
		if (o instanceof String) {
			String s = (String) o;
			return s.isEmpty() == false;
		} else if (o instanceof Collection) {
			Collection<?> c = (Collection<?>) o;
			return c.isEmpty() == false;
		}
		return true;
	}

}
