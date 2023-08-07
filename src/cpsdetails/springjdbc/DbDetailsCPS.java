package cpsdetails.springjdbc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DbDetailsCPS {
	private static final String prodUrl = "jdbc:oracle:thin:@//localhost:1521/CPSAMP";
	private static final String uatUrl = "jdbc:oracle:thin:@//cps-amp-stable.czazctzymxax.us-west-2.rds.amazonaws.com:1521/CPSAMP";
	private static final String userName = "cps_user";
	private static final String password = "cps_user";

	public static void get(String env, String listFilepath, String sql) throws IOException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(new DriverManagerDataSource(
				env.intern().equalsIgnoreCase("prod") ? prodUrl : uatUrl, userName, password));
		List<String> list = Files.readAllLines(Paths.get(listFilepath));
		int insertIndex = sql.lastIndexOf('?');
		sql = sql.substring(0, insertIndex) + String.join(",", Collections.nCopies(list.size(), "?"));
		
		

	}
}
