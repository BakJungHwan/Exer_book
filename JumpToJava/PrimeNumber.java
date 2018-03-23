import java.util.Scanner;

public class PrimeNumber {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		boolean isPrime = true;
		for(int i=2; i<(int)Math.sqrt(num)+1;++i)
		{
			if(num % i == 0)
			{
				isPrime = false;
				break;
			}
		}
		if(isPrime)
		{
			System.out.println("소수");
		}
		else
		{
			System.out.println("소수아님");
		}
		sc.close();
	}
}