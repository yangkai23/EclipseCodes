package cps;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.FileUtils;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class CountFetcher implements Runnable {
	private final String host = "sftp.springernature.com";
	private final int port = 22;
	private final String username = "sftpisi";
	private final String pwd = "pxetf93G";
	private String dir;
	private String toFile;
	private BufferedWriter writer;

	public CountFetcher(String dir, String toFile, BufferedWriter writer) throws IOException {
		this.writer = writer;
		this.toFile = toFile;
		this.dir = dir;
	}

	/*
	 * public static void main(String[] args) throws IOException {
	 * 
	 * String textFilePath = args[0]; writer = new
	 * BufferedWriter(Files.newBufferedWriter(Paths.get(textFilePath))); }
	 */
	@Override
	public void run() {
		Session session = null;
		ChannelSftp channel = null;
		try {
			JSch jsch = new JSch();
			session = jsch.getSession(username, host, port);
			session.setPassword(pwd);
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect();
			channel = (ChannelSftp) session.openChannel("sftp");
			channel.connect();
			System.out.println("Connected to SFTP");
			channel.cd(dir);
			System.out.println("Inside the folder");
			Vector<?> filelist = channel.ls(dir);
			System.out.println("Count: " + filelist.size());
			StringBuilder builder = new StringBuilder();
			/*
			 * for (int i = 0; i < filelist.size(); i++) { String filename = ((LsEntry)
			 * filelist.get(i)).getFilename(); if (filename.equals(".") ||
			 * filename.equals("..")) continue; String fullPath = dir + "/" + filename;
			 * builder.append(fullPath).append(",").append(String.valueOf(getCountInZip(
			 * channel, fullPath))) .append("\n"); synchronized (writer) {
			 * writer.append(builder.toString()); writer.newLine(); writer.flush(); }
			 * 
			 * }
			 */

		} catch (JSchException | SftpException e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.disconnect();
			if (channel != null)
				channel.exit();
		}

	}

	public int getCountInZip(ChannelSftp channel, String currPath) {
		System.out.println(currPath);
		int size = 0;
		ZipInputStream inputStream = null;
		try {
			inputStream = new ZipInputStream(channel.get(currPath));
			while (inputStream.getNextEntry() != null) {
				size++;
			}
			return size;
		} catch (SftpException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return size;
	}

	/*
	 * public ChannelSftp getChannel() throws IOException {
	 * 
	 * Session session = null; ChannelSftp channel = null;
	 * 
	 * try { JSch jsch = new JSch(); session = jsch.getSession(username, host,
	 * port); session.setPassword(pwd); java.util.Properties config = new
	 * java.util.Properties(); config.put("StrictHostKeyChecking", "no");
	 * session.setConfig(config); session.connect(); channel = (ChannelSftp)
	 * session.openChannel("sftp"); channel.connect();
	 * System.out.println("Connected to SFTP"); channel.cd(dir);
	 * System.out.println("Inside the folder"); Vector<?> filelist =
	 * channel.ls(dir); System.out.println("Count: " + filelist.size());
	 * 
	 * } catch (JSchException | SftpException e) { e.printStackTrace(); } finally {
	 * if (session != null) session.disconnect(); if (channel != null)
	 * channel.exit(); } return channel; }
	 */
	/*
	 * public void getCount(ChannelSftp channel, Vector<?> filelist, LsEntry
	 * lsEntry, String currPath) throws IOException {
	 * 
	 * if (lsEntry.getFilename().intern().equals("ARCHIVE")) return;
	 * 
	 * try { if (!currPath.equals("/frontfile")) { filelist = channel.ls(currPath);
	 * }
	 * 
	 * } catch (SftpException e1) { e1.printStackTrace(); } //
	 * filelist.stream().map(i -> ((LsEntry)
	 * i).getFilename()).forEach(System.out::println); for (int i = 0; i <
	 * filelist.size(); i++) {
	 * 
	 * LsEntry entry = (LsEntry) filelist.get(i); if
	 * (entry.getFilename().equals(".") || entry.getFilename().equals(".."))
	 * continue; if (entry.getAttrs().isDir()) { try { System.out.println(currPath +
	 * "/" + entry.getFilename()); currPath = currPath + "/" + entry.getFilename();
	 * channel.cd(currPath); getCount(channel, filelist, entry, currPath);
	 * 
	 * currPath = currPath.substring(0, currPath.lastIndexOf("/"));
	 * channel.cd(currPath);
	 * 
	 * } catch (SftpException e) { e.printStackTrace(); }
	 * 
	 * } if (entry.getFilename().intern().endsWith(".zip")) { StringBuilder
	 * countWriter = new StringBuilder(); try {
	 * countWriter.append(currPath).append("/").append(entry.getFilename()).append('
	 * ,') .append(getCountInZip(channel, lsEntry, currPath + "/" +
	 * entry.getFilename())); writer.append(countWriter.toString());
	 * writer.newLine(); writer.flush(); channel.cd(currPath);
	 * 
	 * } catch (IOException | SftpException e) { e.printStackTrace(); } } }
	 * 
	 * }
	 */

}
