package org.systemexception.logger.test;

import org.junit.Test;
import org.systemexception.logger.api.Logger;
import org.systemexception.logger.impl.LoggerImpl;

import java.io.File;

import static org.junit.Assert.assertTrue;

/**
 * @author leo
 * @date 08/06/15 21:25
 */
public class LoggerImplTest {

	private static final Logger sut = LoggerImpl.getFor(LoggerImplTest.class);

	@Test
	public void testInfo() {
		sut.info("TestInfo");
		assertTrue(new File("target/info.log").exists());
	}

	@Test
	public void testDebug() {
		sut.debug("TestDebug");
		assertTrue(new File("target/debug.log").exists());
	}

	@Test
	public void testError() {
		sut.error("TestError", new Exception());
		assertTrue(new File("target/error.log").exists());
	}

	@Test
	public void testCorrectClassIsLogged() {
		
	}
}