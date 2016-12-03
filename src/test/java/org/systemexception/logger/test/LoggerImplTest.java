package org.systemexception.logger.test;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.systemexception.logger.api.Logger;
import org.systemexception.logger.impl.LoggerImpl;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.InvalidParameterException;

import static org.junit.Assert.assertTrue;

/**
 * @author leo
 * @date 08/06/15 21:25
 */
public class LoggerImplTest {

	private static final Logger sut = LoggerImpl.getFor(LoggerImplTest.class);
	private File infoLogFile = new File("target/info.log");
	private File debugLogFile = new File("target/debug.log");
	private File errorLogFile = new File("target/error.log");

	@Test
	public void testInfo() throws IOException {
		String messageToLog = "TestInfoMessage" + System.currentTimeMillis();

		sut.info(messageToLog);
		String fileToString = FileUtils.readFileToString(infoLogFile, Charset.defaultCharset());

		assertTrue(fileToString.contains(messageToLog));
	}

	@Test
	public void testDebug() throws IOException {
		String messageToLog = "TestDebugMessage" + System.currentTimeMillis();

		sut.debug(messageToLog);
		String fileToString = FileUtils.readFileToString(debugLogFile, Charset.defaultCharset());

		assertTrue(fileToString.contains(messageToLog));
	}

	@Test
	public void testError() throws IOException {
		String messageToLog = "TestErrorMessage" + System.currentTimeMillis();
		InvalidParameterException invalidParameterException = new InvalidParameterException("InvalidParameter");

		sut.error(messageToLog, invalidParameterException);
		String fileToString = FileUtils.readFileToString(errorLogFile, Charset.defaultCharset());

		assertTrue(fileToString.contains(messageToLog));
		assertTrue(fileToString.contains(invalidParameterException.getMessage()));
	}
}