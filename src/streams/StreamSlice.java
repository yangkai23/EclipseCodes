package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamSlice {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 10; i++)
			list.add(i);

		/*
		 * Stream<Integer> stream = list.stream(). peek(System.out::println). limit(5)
		 * .forEach(System.out::println);
		 */
		/* filter(n -> n % 2 == 0).map(n -> n - 1) */;
		/* stream. */
		
	}
}
