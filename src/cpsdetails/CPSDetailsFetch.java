package cpsdetails;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class CPSDetailsFetch {
	private static final String prodUrl = "jdbc:oracle:thin:@//localhost:1521/CPSAMP";
	private static final String uatUrl = "jdbc:oracle:thin:@//cps-amp-stable.czazctzymxax.us-west-2.rds.amazonaws.com:1521/CPSAMP";
	private static final String userName = "cps_user";
	private static final String password = "cps_user";
	private static boolean likeFlag;

	enum Rows {
		CPS_PROD(13), ARTICLE_METADATA(21), BUNDLE_AUDIT(12);

		private int rows;

		Rows(int i) {
			this.rows = i;
		}

		public int getVal() {
			return this.rows;
		}
	}

	static String listFilepath = "C:\\cps\\sql\\input.txt";
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static BufferedWriter getWriter() throws IOException {
		return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(Paths.get("C:\\cps\\sql\\output.txt"))));
	}

	public static Optional<Connection> getConnection(String env) {
		try {
			String connUrl = env.equalsIgnoreCase("prod") ? prodUrl : uatUrl;
			return Optional.ofNullable(DriverManager.getConnection(connUrl, userName, password));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	public static Optional<PreparedStatement> getPreparedStatement(Optional<Connection> connection, String sql)
			throws IOException {

		int insertIndex = sql.lastIndexOf('?');
		sql = sql.substring(0, insertIndex) + String.join(",", Collections.nCopies(1000, "?")) + ")";
		System.out.println(sql);
		if (connection.isPresent()) {
			try {
				if (sql.contains("like"))
					CPSDetailsFetch.likeFlag = true;
				return Optional.ofNullable(connection.get().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return Optional.empty();
	}

	public static void getDetailsUsingID(Optional<PreparedStatement> statement, String table)
			throws IOException, SQLException {
		PreparedStatement preparedStatement = null;
		BufferedWriter writer = null;
		try {
			writer = getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (statement.isPresent()) {
			preparedStatement = statement.get();
			int fieldCount = 1;
			List<String> list = Files.readAllLines(Paths.get(listFilepath));
			for (int i = 0; i < list.size() / 1000; i++) {
				int initialVal = 1;
				while (initialVal <= 1000 && fieldCount > list.size()) {
					preparedStatement.setString(initialVal, list.get(fieldCount));
					initialVal++;
					fieldCount++;
				}
				int rowsNum = table.intern().equalsIgnoreCase("cps") ? Rows.CPS_PROD.getVal()
						: table.equalsIgnoreCase("bundle") ? Rows.BUNDLE_AUDIT.getVal()
								: Rows.ARTICLE_METADATA.getVal();
				ResultSet rs = preparedStatement.executeQuery();
				ResultSetMetaData metaData = preparedStatement.getMetaData();
				int temp = 1;
				while (temp <= rowsNum) {
					writer.write(metaData.getColumnName(temp++));
					writer.write(',');
					writer.flush();
				}
				writer.newLine();

				if (rs.first()) {
					System.out.println("Hi");
					rs.beforeFirst();
					while (rs.next()) {
						List<String> rsList = new LinkedList<>();
						for (int k = 1; k <= rowsNum; k++) {

							rsList.add(rs.getString(k));
						}
						StringBuilder builder = new StringBuilder();
						System.out.println(rsList);
						rsList.stream().map(s -> builder.append(s).append(','));
						writer.write(builder.toString());
						writer.newLine();
						writer.flush();
					}
				}

			}
			StringBuilder mailSubject = new StringBuilder();
			mailSubject.append("Details Fetching completed .............\n")
					.append("No . of items searched : " + fieldCount);
			MailNotification.sendMail(mailSubject.toString(), "Details Fetching Notification");
		} else {
			System.out.println("Check the credetials");
			MailNotification.sendMail("Connection lost Please enable the VPN / bastion connection",
					"Connection Error Notification");
		}

	}
}
