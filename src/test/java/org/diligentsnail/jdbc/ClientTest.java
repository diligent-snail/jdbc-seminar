package org.diligentsnail.jdbc;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

class ClientTest {
	@Test
	void whenUserEnters1WeCallGetInboxByUsernameMockito() {
		// Создаём мок MailBoxClient'а
		MailBoxClient mailBoxClient = Mockito.mock(MailBoxClient.class);

		// 1. Когда вызовут метод getInboxByUsername c аргументом "abc" вернуть пустой список
		given(mailBoxClient.getInboxByUsername("abc"))
				.willReturn(List.of());

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		Client client = new Client(
				mailBoxClient,
				new Scanner("abc\n1"),
				new PrintStream(byteArrayOutputStream)
		);
		client.run();

		// Проверяем, что действительно вызвали метод с аргументом "abc"
		then(mailBoxClient).should().getInboxByUsername("abc");
	}

	@Test
	void whenUserEnters1WeCallGetInboxByUsername() {
		TestMailboxClient testMailboxClient = new TestMailboxClient();

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		Client client = new Client(
				testMailboxClient, new Scanner("abc\n1"), new PrintStream(byteArrayOutputStream)
		);
		client.run();

		List<String> usernames = testMailboxClient.getUsernames();
		assertEquals(List.of("abc"), usernames);
	}
}
