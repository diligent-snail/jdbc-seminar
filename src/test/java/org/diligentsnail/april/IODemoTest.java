package org.diligentsnail.april;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class IODemoTest {

	@Test
	void noArguments_bse207() {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		new IODemo(printStream).run(new String[0]);
		printStream.flush();

		String output = outputStream.toString();

		assertEquals("Hi, BSE-207!" + System.lineSeparator(), output);
	}

	@Test
	void withArguments() {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		new IODemo(printStream).run(new String[]{"abc"});
		printStream.flush();

		String output = outputStream.toString();

		assertEquals("Hi, abc!" + System.lineSeparator(), output);
	}

	// @TmpDir, Jimfs
	// InputStream -> ByteArrayInputStream
	// OutputStream -> ByteArrayOutputStream
	// Reader -> StringReader
	// Writer -> StringWriter
}
