import java.util.*;

class IsPrimeNumber 
{
	public static boolean isPrimeNumber(int n)
	{
		if(n == 2)
		{
			return true;
		}
		else if(n % 2 == 0 || n == 1)
		{
			return false;
		}
		else
		{
			for(int i=3; i<Math.sqrt(n) ; i+=2)
			{
				if(n%i == 0)
				{
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) 
	{
		int T;

		Scanner scan = new Scanner(System.in);

		T = scan.nextInt();

		for(int i=0; i<T; ++i)
		{
			int n;
			n=scan.nextInt();

			if(isPrimeNumber(n))
			{
				System.out.println("Prime");
			}
			else
			{
				System.out.println("Not prime");
			}
			
		}

		scan.close();
	}
}
