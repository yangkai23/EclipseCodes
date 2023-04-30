package numerical;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;

public class PrahithXamStrings {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test != 0) {
			System.out.println("enter size");
			int n = Integer.parseInt(br.readLine());
			String ar[] = new String[n];
			System.out.println("enter " + n + " elements");
			for (int i = 0; i < ar.length; i++) {
				ar[i] = br.readLine();
			}
			HashMap<String, Integer> map = new HashMap<>();
			for (int i = 0; i < ar.length; i++) {
				if (map.containsKey(ar[i]))
					map.put(ar[i], map.get(ar[i]) + 1);
				else
					map.put(ar[i], 1);
			}
			Entry<String, Integer> x = null;
			int max = 0;
			for (Entry<String, Integer> entry : map.entrySet()) {
				if (entry.getValue() > max) {
					max = entry.getValue();
					x = entry;
				}
			}
			System.out.println(x.getKey() + " " + x.getValue());
			test--;
		}
	}
}
