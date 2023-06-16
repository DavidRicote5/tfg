package org.agaray.spring.pap2023.helpers;

import org.agaray.spring.pap2023.exception.DangerException;
import org.agaray.spring.pap2023.exception.InfoException;

public class PRG {

	public static void info(String mensaje, String link) throws InfoException {
		throw new InfoException(mensaje+"@"+link);
	}

	public static void info(String mensaje) throws InfoException {
		throw new InfoException(mensaje+"@"+"/");
	}
	
	public static void error(String mensaje, String link) throws DangerException {
		throw new DangerException(mensaje+"@"+link);
	}

	public static void error(String mensaje) throws DangerException {
		throw new DangerException(mensaje+"@"+"/");
	}
}

