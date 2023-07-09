package cpsdetails;

public class Driver {
	public static void main(String[] args) {
		CPSDetailsFetch.getDetailsUsingID(CPSDetailsFetch.getPreparedStatement(CPSDetailsFetch.getConnection("prod"),
				CpsQueries.inputFileNameQueryUsingLike));
		System.out.println("Done");
	}
}
