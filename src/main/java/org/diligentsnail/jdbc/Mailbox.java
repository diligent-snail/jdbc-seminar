package org.diligentsnail.jdbc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mailbox {
	// Непонятно, что делать
	// Как дождаться ответа? ++
	// ready
	// null'ы какие-то приходят. Не поняла, что и куда?
	// Socket + AutoCloseable
	// MailClient
	// DataInputStream + DataOutputStream
	// new ArrayList<>(), new HashSet<>() в разных потоках

	// GET
	// username
	//
	// Map<String, List<Letter>> letters = ...;
	// String method = bufferedReader.readLine();
	// if (method.equals(GET)) {
	//    String username = bufferedReader.readLine();
	//    List<Letter> letters = collection.get(username);
	//    for (Letter letter : letters) {
	//        bufferedWriter.write(letter.getFrom());
	//        bufferedWriter.newLine();
	//        bufferedWriter.write(letter.getTo());
	//        bufferedWriter.newLine();
	//        bufferedWriter.write(letter.getBody());
	//        bufferedWriter.newLine();
	//    }
	//    if (method.equals(POST)) {
	//       // 1. Вычитать письмо
	//       // 2. Сохранить в коллекцию
	//       // 3. "OK" отправить клиенту
	//    }
	// }


	// Письмо:
	// Отправитель (без переносов строк)
	// Получатель (без переносов строк)
	// Тело письма (без переносов строк)


	// POST
	// Отправитель (без переносов строк)
	// Получатель (без переносов строк)
	// Тело письма (без переносов строк)
	// bufferedReader.readLine().equals("OK");

	public static void main(String[] args) {
		List<Object> objects1 = Collections.synchronizedList(new ArrayList<>());
		synchronized (objects1) {
			for (Object o : objects1) {

			}
		}
		List<Object> objects = new ArrayList<>();
		new Thread(() -> {
			// нельзя использовать objects
		}).start();
	}
}
