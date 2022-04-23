package org.diligentsnail.jdbc;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class Client {
	private final MailBoxClient mailBoxClient;
	private final Scanner scanner;
	private final PrintStream printStream;

	public Client(MailBoxClient mailBoxClient, Scanner scanner, PrintStream printStream) {
		this.mailBoxClient = mailBoxClient;
		this.scanner = scanner;
		this.printStream = printStream;
	}

	public static void main(String[] args) {
/*
		Scanner scanner = new Scanner();
		Socket socket = new Socket();
		socket.getOutputStream().write();
*/
		// new Client().run();

		new Client(
				new DefaultMailBoxClient(),
				new Scanner(System.in),
				System.out
		).run();
	}

	public void run() {
		//
		try {
			String username = scanner.next();
			List<Letter> inbox = mailBoxClient.getInboxByUsername(username);
		} catch (MailBoxException e) {
			System.out.println("Не получилось. Вот ваш стектрейс:");
			e.printStackTrace(System.out);
		}
	}
}

