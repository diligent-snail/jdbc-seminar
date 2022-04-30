package org.diligentsnail.april;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.UncheckedIOException;
import java.lang.annotation.RetentionPolicy;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.util.Collections.synchronizedList;

public class Thirtieth {
	// 1. Здравствуйте 👋
	// 2. Вопросы 🙋
	// 3. Serializable 🧙
	//  Это интерфейс такой


	record Book(String title) implements Serializable {
	}

	public static class SerializableDemo {
		public static void main(String[] args) throws IOException, ClassNotFoundException {
			// Book -> byte[]

/*
			Book abc = new Book("abc");
			try (ObjectOutputStream outputStream
					// socket.getOutputStream()
						 = new ObjectOutputStream(new FileOutputStream("f.dat"))) {
				outputStream.writeObject(abc);
			}
*/
			try (ObjectInputStream inputStream
						 // socket.getInputStream()
						 = new ObjectInputStream(new FileInputStream("f.dat"))) {
				Book o = (Book) inputStream.readObject();
				System.out.println(o);
			}
		}
	}

	// 6. Многопоточность 🧵

	// ArrayList, в разных потоках?

	public static class MultithreadingCollections {
		public static void main(String[] args) {
			List<Object> objects = synchronizedList(new ArrayList<>());

			objects.add("abc");
			synchronized (objects) {
				for (Object object : objects) {
				}
			}

		}
	}

	// 10. Многомодульный проект 🦉 https://github.com/diligent-snail/maven-multimodule-project-demo
	// jdbc
	// 11. Вопросы 🙋🙋
	// 12. До свидания 💚
	// 4. Исключения 📗

	// Зачем?
	// 1. Компилятор ругается(нас заставляют): IOException, ClassNotFoundException, SQLException
	//      1. Мы знаем что делать
	public static void main0(String[] args) {
		// Прочитали имя файла
		try {
			String string = Files.readString(Path.of(""));
			System.out.println(string);
		} catch (IOException e) {
			System.out.println("Не получилось, " + e.getMessage());
			e.printStackTrace(System.out);
		}
	}

	public void init() {
		try {
			Files.readString(Path.of("file.config"));
			// используем настройки из файла
		} catch (IOException e) {
			// используем настройки по умолчания
		}
	}

	// Залогировать исключение, прекратить работу

	//      2. Мы не знаем что делать
	public String readFile(Path path) {
		try {
			return Files.readString(path);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	// 2. Мы сами обрабатываем исключения:
	//      1. Мы знаем что делать
	public int getPort(String string) {
		try {
			return Integer.parseInt(string);
		} catch (NumberFormatException e) {
			// лог
			return 8080;
		}
	}
	//      2. Мы не знаем что делать -> catch (Exception e). Не надо ловить, если мы не знаем что делать

	// 8. IO и тесты 🤯


	// 7. import static. тут всё легко
	public static void main(String[] args) {
		RetentionPolicy runtime = RUNTIME;
		synchronizedList(new ArrayList<>());
	}
	// 5. Generic'и 📕
	// Что известно? List<String>, List<Integer>
	// Type erasure
	// PECS: producer extends, consumer super
	///      ? extends T, ? super T

	public static class Erasure {
		public static void main(String[] args) {
			List<String> strings = new ArrayList<>();
			List list = strings;
			list.add(8L);

			String s = strings.get(0);
		}
	}

	// 9. Как код делить 🥶
}
