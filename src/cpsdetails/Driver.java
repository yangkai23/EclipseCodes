package cpsdetails;

import java.io.IOException;
import java.sql.SQLException;

public class Driver {
	// cps
	// bundle

	public static void main(String[] args) throws IOException, SQLException {
		CPSDetailsFetch.getDetailsUsingID(
				CPSDetailsFetch.getPreparedStatement(CPSDetailsFetch.getConnection("prod"), CpsQueries.prepIdQuery),
				"cps");
		System.out.println("Done");
	}
}
