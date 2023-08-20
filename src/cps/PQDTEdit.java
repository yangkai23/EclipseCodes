package cps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PQDTEdit {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(Files.newInputStream(Paths.get("C:\\cps\\sql\\input.txt"))));
		BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(Files.newOutputStream(Paths.get("C:\\cps\\sql\\output.txt"))));
		String line = reader.readLine();
		while (line != null) {
			if (line.contains("<xsl:when test=\"$pqSubj")) {
				int start = line.indexOf("'");
				int end = line.lastIndexOf("'") + 1;
				StringBuilder builder = new StringBuilder();
				for (char c : line.substring(start, end).toCharArray()) {
					builder.append(Character.toLowerCase(c));
				}
				writer.write(line.substring(0, start).concat(builder.toString()).concat(line.substring(end, line.length())));
			} else {
				writer.write(line);
			}
			line = reader.readLine();
			writer.newLine();
		}
		writer.flush();
		writer.close();
		reader.close();
	}
}
