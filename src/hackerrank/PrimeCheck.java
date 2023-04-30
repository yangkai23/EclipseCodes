package hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrimeCheck {
	/*
	 * public static List<String> collectedPrime = new ArrayList<>(); public static
	 * void main(String[] args) {
	 * 
	 * try{ BufferedReader br = new BufferedReader(new
	 * InputStreamReader(System.in)); br.lines().forEach(o ->
	 * collectedPrime.add(o)); for(int i=1;i<=5;i++) {
	 * collectedPrime.add(br.readLine()); } br.close(); } catch (Exception e) {
	 * System.out.println(e); } checkPrime(collectedPrime);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * private static void checkPrime(List<String> collectedPrime){ List<String>
	 * filteredPrime = new ArrayList<>(); for(int i = 0; i< collectedPrime.size();
	 * i++) {
	 * 
	 * if (isPrime(Integer.valueOf(collectedPrime.get(i)))) {
	 * filteredPrime.add(collectedPrime.get(i)); System.out.println(filteredPrime);
	 * } if(i != 3){
	 * System.out.println(filteredPrime.stream().collect(Collectors.joining(" ")));
	 * } }
	 * 
	 * } static boolean isPrime(int num) { if(num<=1) { return false; } for(int
	 * i=2;i<=num/2;i++) { if((num%i)==0) return false; } return true; }
	 */
	/*
	 * public static void main(String[] args) { Scanner scanner = new
	 * Scanner(System.in); Prime prime = new Prime(); int[] n= new int[5]; for (int
	 * i=0; i<5; i++) { n[i]=scanner.nextInt(); }
	 * 
	 * for (int i=0; i<4; i++) { int to = i == 3 ? 4 : i;
	 * prime.checkPrime(Arrays.copyOfRange(n, 0, to + 1)); }
	 * 
	 * } }
	 * 
	 * class Prime{ public void checkPrime(int ...n){
	 * System.out.println(Arrays.toString(n)); for (int i: n) { BigInteger bigInt =
	 * new BigInteger(String.valueOf(i)); if (bigInt.isProbablePrime(1)) {
	 * System.out.print(i + " "); } } System.out.println(); }
	 */
	
	static class Prime {
	    
	    public void checkPrime(int ... n) {
	    	System.out.println(Arrays.toString(n));
	     
	        for(int i = 0; i < n.length ; i++) {
	             if(isPrime(n[i])) {
	                 System.out.print(n[i] + " ");
	             }
	        }
	        
	      System.out.println();
	        
	    }
	    
	    private boolean isPrime(int n) {
	        if ( n == 1) return false;
	        
	         if ( n == 2) return true;
	         
	         boolean isPrime = true;
	        
	        for(int i = n - 1; i > 1; i --) {
	         //   System.out.println(n+"%"+i+"="+n%i);
	            if (n%i == 0) {
	                isPrime = false;
	            }
	            
	        }
	         
	        return isPrime;
	    }
	}
	
	 public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        
	        try{
	        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	        int n1=Integer.parseInt(br.readLine());
	        int n2=Integer.parseInt(br.readLine());
	        int n3=Integer.parseInt(br.readLine());
	        int n4=Integer.parseInt(br.readLine());
	        int n5=Integer.parseInt(br.readLine());
	        Prime ob=new Prime();
	        ob.checkPrime(n1);
	        ob.checkPrime(n1,n2);
	        ob.checkPrime(n1,n2,n3);
	        ob.checkPrime(n1,n2,n3,n4,n5);    
	        Method[] methods=Prime.class.getDeclaredMethods();
	        Set<String> set=new HashSet<>();
	        boolean overload=false;
	        for(int i=0;i<methods.length;i++)
	        {
	            if(set.contains(methods[i].getName()))
	            {
	                overload=true;
	                break;
	            }
	            set.add(methods[i].getName());
	            
	        }
	        if(overload)
	        {
	            throw new Exception("Overloading not allowed");
	        }
	        }
	        catch(Exception e)
	        {
	            System.out.println(e);
	        }
	    }
	
	
	
	
	
	
}
