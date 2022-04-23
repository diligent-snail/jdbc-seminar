package org.diligentsnail.jdbc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestMailboxClient implements MailBoxClient {
	private final List<String> usernames = new ArrayList<>();

	@Override
	public List<Letter> getInboxByUsername(String username) throws MailBoxException {
		usernames.add(username);
		return Collections.emptyList();
	}

	@Override
	public void sendLetter(Letter letter) throws MailBoxException {

	}

	public List<String> getUsernames() {
		return usernames;
	}
}
