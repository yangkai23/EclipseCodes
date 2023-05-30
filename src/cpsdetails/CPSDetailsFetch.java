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

public class CPSDetailsFetch {
	private static final String prodUrl = "jdbc:oracle:thin:@//localhost:1521/CPSAMP";
	private static final String uatUrl = "jdbc:oracle:thin:@//cps-amp-stable.czazctzymxax.us-west-2.rds.amazonaws.com:1521/CPSAMP";
	private static final String userName = "cps_user";
	private static final String password = "cps_user";
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws ClassNotFoundException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(Files.newInputStream(Paths.get("C:\\cps\\sql\\input.txt"))));
				BufferedWriter writer = new BufferedWriter(
						new OutputStreamWriter(Files.newOutputStream(Paths.get("C:\\cps\\sql\\output.txt"))))) {
			connection = DriverManager.getConnection(prodUrl, userName, password);
			preparedStatement = connection.prepareStatement(CpsQueries.prepIdQuery);
			String field = reader.readLine();
			while (field != null) {
				preparedStatement.setString(1, field);
				resultSet = preparedStatement.executeQuery();
				StringBuilder builder = new StringBuilder();
				if (resultSet.next()) {
					for (int i = 1; i <= 13; i++) {
						builder.append(resultSet.getString(i));
						if (i < 13)
							builder.append(",");
					}
				}
				writer.write(builder.toString());
				writer.newLine();
				field = reader.readLine();
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
