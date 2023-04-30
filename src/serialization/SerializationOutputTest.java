package serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationOutputTest {
	public static void main(String[] args) {
		File file = new File("user.txt");
		try (FileOutputStream fileOutputStream = new FileOutputStream(file);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
			if (!file.exists())
				file.createNewFile();
			User user = new User();
			user.setId(131);
			user.setName("Anirudh");
			objectOutputStream.writeObject(user);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
