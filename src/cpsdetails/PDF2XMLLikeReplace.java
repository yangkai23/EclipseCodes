package cpsdetails;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PDF2XMLLikeReplace {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(Files.newInputStream(Paths.get("C:\\cps\\sql\\input.txt"))));
		BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(Files.newOutputStream(Paths.get("C:\\cps\\sql\\output.txt"))));
		String file = reader.readLine();
//		int sum = 0;
		while (file != null) {
			writer.write(file.replace("batch1", "batch2"));
			writer.newLine();
			writer.flush();
//			sum += Integer.parseInt(file);
			file = reader.readLine();
		}
//		System.out.println(sum);
		writer.close();
		reader.close();
	}
}
