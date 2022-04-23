package org.diligentsnail.jdbc;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefaultMailBoxClient implements MailBoxClient, AutoCloseable {
	private final Closeable closeable = new Closeable() {
		@Override
		public void close() throws IOException {
		}
	};

	@Override
	public List<Letter> getInboxByUsername(String username) {
		List<Letter> letters = new ArrayList<>();
		// 0. username валидный: не null и без переносов
		// 1. new Socket(...)
		// 2. GET ->
		// 3. username ->
		// 4. flush()
		// 5. Вычитать ответ
		// 6. Letter letter = new Letter(..);
		// 7. letters.add(letter);
		// 8. returns letters;
		try {
			//
			return Collections.emptyList();
		} catch (RuntimeException/*IOException*/ e) {
			throw new MailBoxException("sdafas", e);
		}
	}

	@Override
	public void sendLetter(Letter letter) {

	}

	@Override
	public void close() {
		try (closeable) {
		} catch (IOException e) {
			// в лог
		}
	}
}
