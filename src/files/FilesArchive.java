package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.CompressionLevel;

public class FilesArchive {

	public static void createZipFile(String WORKING_FOLDER) throws IOException {
		String DATE = WORKING_FOLDER.substring(WORKING_FOLDER.length() - 10);
		System.out.println(DATE);
		Path path = Paths.get(WORKING_FOLDER);
		List<Path> files;
		try (Stream<Path> stream = Files.list(path)) {
			files = stream.collect(Collectors.toList());
		}
		ZipParameters zipParameters = new ZipParameters();
		zipParameters.setCompressionLevel(CompressionLevel.NORMAL);
		Iterator<Path> itr = files.listIterator();
		while (itr.hasNext()) {
			Path path1 = itr.next();
			Path folder = path1.getFileName();
			try (ZipFile zipFile = new ZipFile(folder + "_" + DATE + ".zip")) {
				Iterator<Path> fol = Files.list(Paths.get(path1.toString())).collect(Collectors.toList()).iterator();
				while (fol.hasNext()) {
					Path file = fol.next();
					zipFile.addFile(file.toString(), zipParameters);
					System.out.println(file);
				}
				System.out.println(zipFile.isValidZipFile());
				Files.move(
						Paths.get("C:\\Users\\U6070304\\OneDrive - Clarivate Analytics\\Desktop\\practice\\DCE\\"
								+ folder + "_" + DATE + ".zip"),
						Paths.get(path1.toString() + "\\" + folder + "_" + DATE + ".zip"));
			}
			System.out
					.println("Done-----------------------------------------------------------------------------------");
		}
	}
}
