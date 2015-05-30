package ru.auquid.forum.util;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JndiNameBuilder {

	private static String JNDI_MODULE_PREFIX;

	static {
		try {
			setPrefix("java:app/"
					+ (String) new InitialContext().lookup("java:app/AppName")
					+ "/");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public <T> String buildEjbName(Class<T> beanLocal) {
		if (beanLocal == null)
			throw new IllegalArgumentException(
					"Illegal 'beanLocal' argument value: null.");
		StringBuilder name = new StringBuilder(JNDI_MODULE_PREFIX);
		name.append(beanLocal.getSimpleName().split("Remote")[0]).append(
				"!ru.auquid.forum.beans." + beanLocal.getSimpleName());
		return name.toString();
	}

	public static void setPrefix(String prefix) {
		JNDI_MODULE_PREFIX = prefix;
	}
}
