package serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SerializationInputTest {

	public static void main(String[] args) throws IOException {
		File file = new File("user.txt");
		try (FileInputStream fileInputStream = new FileInputStream(file);
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
			User user = (User) objectInputStream.readObject();
			System.out.println(user);
		} catch (FileNotFoundException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
}
