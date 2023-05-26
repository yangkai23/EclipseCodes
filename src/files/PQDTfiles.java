package files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PQDTfiles {
	public static void main(String[] args) throws IOException {
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(Files.newInputStream(Paths.get("C:\\cps\\cps adhoc\\SIdata_upd.txt"))));
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
						Files.newOutputStream(Paths.get("C:\\cps\\cps adhoc\\SIdata_upd_op.txt"))))) {

			StringBuilder file = new StringBuilder(reader.readLine());
			while (file != null) {
				StringBuilder builder = new StringBuilder(file);
				System.out.println();
				builder.replace(0, 1, "");
				builder.replace(27, 28, ".zip");
				writer.write(builder.toString());
				writer.newLine();
				file = new StringBuilder(reader.readLine());
			}
			writer.flush();
		}

	}
}
