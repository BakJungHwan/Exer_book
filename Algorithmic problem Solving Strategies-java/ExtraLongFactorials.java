import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ExtraLongFactorials {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		BigInteger fact = new BigInteger("1");
		BigInteger count = new BigInteger("1");
		
		for(int i=0; i<n; ++i)
		{
			fact = fact.multiply(count);
			count = count.add(count.ONE);
			System.out.println("count : " + count);
			System.out.println("fact : " + fact);
		}

		System.out.println(fact);

	}
}