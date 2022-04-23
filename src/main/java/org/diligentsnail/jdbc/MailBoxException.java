package org.diligentsnail.jdbc;

public class MailBoxException extends RuntimeException {
	public MailBoxException(String message) {
		super(message);
	}

	public MailBoxException(String message, Throwable cause) {
		super(message, cause);
	}
}
