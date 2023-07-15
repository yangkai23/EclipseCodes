package cps.grants;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class RePackagingTask implements Runnable {

	private final String srcPath;
	private final String destPath;

	public RePackagingTask(String srcPath, String destPath) {
		this.srcPath = srcPath;
		this.destPath = destPath;
	}

	@Override
	public void run() {
		System.out.println("PackageTask: " + srcPath);
		File src = new File(srcPath);
		String bundleName = src.getName();
		FileOutputStream fos = null;
		ZipOutputStream zipOut = null;
		try {
			fos = new FileOutputStream(destPath + File.separator + bundleName + ".zip");
			zipOut = new ZipOutputStream(fos);
			zipFile(src, bundleName, bundleName, zipOut);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				zipOut.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void zipFile(File fileToZip, String origFolder, String fileName, ZipOutputStream zipOut)
			throws IOException {
		if (fileToZip.isHidden()) {
			return;
		}
		if (fileToZip.isDirectory()) {
//					if (!fileToZip.getName().equals(origFolder)) {
//						if (fileName.endsWith("/")) {
//							zipOut.putNextEntry(new ZipEntry(fileName));
//							zipOut.closeEntry();
//						} else {
//							zipOut.putNextEntry(new ZipEntry(fileName + "/"));
//							zipOut.closeEntry();
//						}
//					}
			File[] children = fileToZip.listFiles();
			for (File childFile : children) {
				if (!fileToZip.getName().equals(origFolder)) {
					zipFile(childFile, origFolder, fileName + File.separator + childFile.getName(), zipOut);
				} else {
					zipFile(childFile, origFolder, childFile.getName(), zipOut);
				}
			}
			return;
		}
		FileInputStream fis = new FileInputStream(fileToZip);
		ZipEntry zipEntry = new ZipEntry(fileName);
		zipOut.putNextEntry(zipEntry);
		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zipOut.write(bytes, 0, length);
		}
		fis.close();
	}

}
