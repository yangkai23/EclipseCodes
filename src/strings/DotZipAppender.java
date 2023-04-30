package strings;

import java.io.*;

public class DotZipAppender {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\cps\\docs\\appender.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\cps\\docs\\result.txt"));
        String zipFile = reader.readLine();
        try {
            if (Integer.valueOf(Integer.parseInt(zipFile)) instanceof Integer) {
                inputIsNumber(reader, writer, zipFile);
            }

        } catch (NumberFormatException e) {
            inputIsString(reader, writer, zipFile);
        } finally {
            writer.flush();
            writer.close();
            reader.close();
        }
    }

    public static void inputIsString(BufferedReader reader, BufferedWriter writer, String zipFile) throws IOException {
        while (zipFile != null) {

            if (zipFile.endsWith(".zip")) {
                zipFile = "'" + zipFile + "',";
            } else {
                zipFile = "'" + zipFile + ".zip',";
            }
            writer.write(zipFile);
            writer.newLine();
            zipFile = reader.readLine();
        }

    }

    public static void inputIsNumber(BufferedReader reader, BufferedWriter writer, String zipFile) throws IOException {
        while (zipFile != null) {

            writer.write("'" + zipFile + "',");
            writer.newLine();
            zipFile = reader.readLine();
        }

    }
}