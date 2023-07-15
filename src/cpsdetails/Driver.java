package cpsdetails;

public class Driver {
	public static void main(String[] args) {
		CPSDetailsFetch.getDetailsUsingID(
				CPSDetailsFetch.getPreparedStatement(CPSDetailsFetch.getConnection("uat"), CpsQueries.receiptIdQuery));
		System.out.println("Done");
	}
}
