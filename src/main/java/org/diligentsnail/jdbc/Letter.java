package org.diligentsnail.jdbc;

import java.util.Objects;

public record Letter(
		String from,
		String to,
		String body
) {
	public Letter {
		Objects.requireNonNull(from, "from == null");
		Objects.requireNonNull(to, "to == null");
		Objects.requireNonNull(body, "body == null");

		if (from.contains("\r") || from.contains("\n")) {
			throw new IllegalArgumentException("Переносы запрещены, from " + from);
		}
	}
}
