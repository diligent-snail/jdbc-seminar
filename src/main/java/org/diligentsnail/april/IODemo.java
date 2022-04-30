package org.diligentsnail.april;

import java.io.PrintStream;
import java.util.Objects;

public class IODemo {
	private final PrintStream printStream;

	public IODemo(PrintStream printStream) {
		this.printStream = Objects.requireNonNull(printStream);
	}

	public void run(String[] args) {
		String name = "BSE-207";
		if (args.length > 0) {
			name = args[0];
		}
		printStream.println("Hi, " + name + "!");
	}

	public static void main(String[] args) {
		new IODemo(System.out).run(args);
	}
}
