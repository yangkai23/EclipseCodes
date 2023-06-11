package cpsdetails;

public class Driver {
	public static void main(String[] args) {
		CPSDetailsFetch.getDetailsUsingID(CPSDetailsFetch.getPreparedStatement(CPSDetailsFetch.getConnection("PROD"),
				CpsQueries.workflowIdQuery));
		System.out.println("Done");
	}
}
