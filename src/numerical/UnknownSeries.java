package numerical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UnknownSeries {
    public static void main(String[] args) {
        int arr[] = new int[101];
        arr[0] = 1;
        for (int n = 1; n <= 100; n++) {
            arr[n] = (int) (3 * Math.pow(n, 2) - n + 2) / (2);
        }
        getPrimes(arr);
    }

    public static int getPrimes(int[] arr) {

        IntPredicate predicate = (n) -> {
            for (int i = 2; i < n / 2; i++) {
                if (n % i == 0) return false;
            }
            return true;
        };


        Supplier<ArrayList<Integer>> supplier=()->new ArrayList<>();

//        ArrayList<Integer> list = Arrays.stream(arr).filter(predicate).reduce();
//        System.out.println(list);
        return 0;
    }

}
