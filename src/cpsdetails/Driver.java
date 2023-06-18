package cpsdetails;

public class Driver {
	public static void main(String[] args) {
		CPSDetailsFetch.getDetailsUsingID(CPSDetailsFetch.getPreparedStatement(CPSDetailsFetch.getConnection("prod"),
				CpsQueries.inputFileNameQuery));
		System.out.println("Done");
	}
}
