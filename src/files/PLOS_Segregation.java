package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PLOS_Segregation {
	private static final String WORKING_FOLDER = "C:\\cps\\provider_setup\\PLoS\\scraping\\File\\2023-05-26";

	/*
	 * Files.move is not equivalent to the mv command. It won't detect that the
	 * destination is a directory and move files into there.
	 * 
	 * You have to construct the full destination path, file by file. If you want to
	 * copy /src/a.txt to /dest/2014/, the destination path needs to be
	 * /dest/2014/a.txt.
	 */

	public static void main(String[] args) throws IOException {
		Path path = Paths.get(WORKING_FOLDER);
		List<Path> files;
		try (Stream<Path> stream = Files.list(path)) {

			files = stream.collect(Collectors.toList());
		}
		Iterator<Path> itr = files.listIterator();

		Path fileNameWithPath;
		Path fileName;
		String folderName;
		Path directory;
		Path destination;
		while (itr.hasNext()) {
			fileNameWithPath = itr.next();
			fileName = fileNameWithPath.getFileName();
			folderName = fileName.toString().substring(0, 4);
			directory = Paths.get(path + "\\" + folderName + "\\");
			destination = Paths.get(directory + "\\" + fileName);
			if (Files.exists(directory)) {
				Files.move(fileNameWithPath, destination);
			} else {
				Files.createDirectory(directory);
				Files.move(fileNameWithPath, destination);
			}
		}
		System.out.println(" Partition Done");
		FilesArchive.createZipFile(WORKING_FOLDER);
		System.out.println("Files Zipped");

	}
}