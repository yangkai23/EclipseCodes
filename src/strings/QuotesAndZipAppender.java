package strings;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class QuotesAndZipAppender {
	private static final int ID_LENGTH = 8;

	public static void main(String[] args) throws IOException {
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(Files.newInputStream(Paths.get("C:\\cps\\docs\\appender.txt"))));
				BufferedWriter writer = new BufferedWriter(
						new OutputStreamWriter(Files.newOutputStream(Paths.get("C:\\cps\\docs\\result.txt"))))) {
			boolean isString = false;
			String firstLine = reader.readLine();

			for (char c : firstLine.toCharArray()) {
				if (!Character.isDigit(c)) {
					isString = true;
					break;
				}
			}
			if (firstLine.equals("doi"))
				isString = false;
			if (!isString && firstLine.length() != ID_LENGTH)
				isString = true;
			if (firstLine.equalsIgnoreCase("doi"))
				isString = false;
			StringBuilder line = new StringBuilder(firstLine);
			append(reader, writer, isString, line);
			System.out.println("Done");
		} catch (IOException e) {
			System.out.println("Please check the file path");
		}
	}

	public static void append(BufferedReader reader, BufferedWriter writer, boolean isString, StringBuilder line)
			throws IOException {
		StringBuilder temp;
		if (isString) {
			while (line != null) {
				if (!line.substring(line.length() - 4).contentEquals(".zip")) {
					line.insert(0, "'");
					line.append(".zip'");
				} else {
					line.insert(0, "'");
					line.append("'");
				}
				temp = line;
				String next = reader.readLine();
				if (next != null) {
					temp.append(",");
					line = new StringBuilder(next);
				} else
					line = null;
				writer.write(temp.toString());
				System.out.println(temp.toString());
				writer.newLine();
			}
		} else {
			while (line != null) {
				line.insert(0, "'");
				line.append("'");
				temp = line;
				String next = reader.readLine();
				if (next != null) {
					temp.append(",");
					line = new StringBuilder(next);
				} else
					line = null;
				writer.write(temp.toString());
				writer.newLine();
			}
		}

	}
}
