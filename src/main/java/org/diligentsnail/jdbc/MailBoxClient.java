package org.diligentsnail.jdbc;

import java.util.List;

public interface MailBoxClient {
	List<Letter> getInboxByUsername(String username) throws MailBoxException;

	void sendLetter(Letter letter) throws MailBoxException;
}
