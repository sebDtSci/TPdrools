package com.adis.questionnaire.util;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenUID {
	private static Logger LOGGER = LoggerFactory.getLogger(GenUID.class);

	public static String getUID(String libelle) {
		String uid = UUID.nameUUIDFromBytes(libelle.getBytes(StandardCharsets.UTF_8)).toString();

		LOGGER.debug(libelle + " -> " + uid);
		return uid;
	}
}
