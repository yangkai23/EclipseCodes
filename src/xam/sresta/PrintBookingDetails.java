package xam.sresta;

public class PrintBookingDetails {
	static String driver_name = "Murali";
	static String driver_phone = "9566171366";
	static String car_type = "Silver Indica";
	static String car_license = "AP14F4434";
	static double peak_time_charge = 1.8;

	public static void main(String[] args) {
		StringBuilder details = new StringBuilder();
		details.append(driver_name).append(" (").append(driver_phone).append(')')
				.append(" is on the way to your location in a ").append(car_type).append(car_license)
				.append(". ").append(peak_time_charge).append(" times peak time charge is applicable on this booking");
		System.out.println(details);
	}
}
