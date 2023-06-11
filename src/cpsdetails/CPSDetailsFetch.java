package cpsdetails;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class CPSDetailsFetch {
	private static final String prodUrl = "jdbc:oracle:thin:@//localhost:1521/CPSAMP";
	private static final String uatUrl = "jdbc:oracle:thin:@//cps-amp-stable.czazctzymxax.us-west-2.rds.amazonaws.com:1521/CPSAMP";
	private static final String userName = "cps_user";
	private static final String password = "cps_user";
	private static boolean likeFlag = false;

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static BufferedReader getReader() throws IOException {
		return new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get("C:\\cps\\sql\\input.txt"))));
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

	public static Optional<PreparedStatement> getPreparedStatement(Optional<Connection> connection, String sql) {
		if (connection.isPresent()) {
			try {
				if (sql.contains("Like"))
					likeFlag = true;
				return Optional.ofNullable(connection.get().prepareStatement(sql));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return Optional.empty();
	}

	public static void getDetailsUsingID(Optional<PreparedStatement> statement) {
		PreparedStatement preparedStatement = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		String field = null;
		try {
			reader = getReader();
			writer = getWriter();
			field = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (statement.isPresent()) {
			preparedStatement = statement.get();
			fileRead: while (field != null) {
				System.out.println(field);
				ResultSet resultSet = null;
				try {
					if (likeFlag)
						field = "%" + field.concat("%");
					preparedStatement.setString(1, field);
					resultSet = preparedStatement.executeQuery();
					if (!resultSet.next()) {
						writer.write("No details found");
						field = reader.readLine();
						continue fileRead;
					}
					while (resultSet.next()) {
						System.out.println("Inside ");
						StringBuilder builder = new StringBuilder();
						for (int i = 1; i <= 13; i++) {
							builder.append(resultSet.getString(i));
							if (i < 13)
								builder.append(",");
						}
						writer.write(builder.toString());
						writer.newLine();
						writer.flush();
					}
					field = reader.readLine();
				}

				catch (SQLException | IOException e) {
					e.printStackTrace();
				}
			}

		} else {
			System.out.println("Check the credetials");
		}

	}
}
