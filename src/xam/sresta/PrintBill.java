package xam.sresta;

public class PrintBill {
	public static void main(String[] args) {
		String order_id = "OD487321268625838008";
		int amount = 4166;
		String delivery_date = "Fri 14, Feb 2020";
		StringBuilder billTemplate = new StringBuilder();
		billTemplate.append("We have received your order ").append(order_id).append(" amounting to Rs.").append(amount)
				.append(" and it is being processed. You can expect delivery by ").append(delivery_date)
				.append(". You can manage your order at http://fkrt.it/zzBolukluN. Thank you!");
		System.out.println(billTemplate);
	}
}
