import java.util.*;

class Karatsuba 
{
	public static void nomalize(int[] array)
	{
		int carry;

		for(int i=0; i<array.length; ++i)
		{
			if(Math.abs(array[i]) > 9)
			{
				if(array[i] <0)
				{
					carry = (Math.abs(array[i])+9)/10;
					array[i+1] -= carry;
					array[i] = 10*carry + array[i];
				}
				else
				{
					array[i+1] += array[i] /10;
					array[i] %= 10;
				}
			}
		}
	}

	public static int[] multiply(int[] a, int[] b)
	{
		int[] temp = new int[a.length + b.length];

		for(int i=0; i<a.length; ++i)
		{
			for(int j=0; j<b.length; ++j)
			{
				temp[i+j] += a[i] * b[j];
			}
		}
		nomalize(temp);

		return temp;

	}

	
	public static void printBigIntArray(int[] array)
	{
		int i = array.length-1;

		if(array[i] == 0)
		{
			while(array[i--] != 0);
		}

		for(int j=i ; j>=0; --j)
		{
			System.out.print(array[j]);
		}
	}


	public static int[] karatsuba(int[] a, int[] b)
	{
		int size_a = a.length;
		int size_b = b.length;

		if(size_b > size_a) karatsuba(b, a);

		if(size_a == 0 || size_b==0) return a;

		if(size_a == 1) return multiply(a, b);

		int half = size_a/2;

		int[] a0 = new int[half];
		int[] a1 = new int[size_a - half];

		int[] b0 = new int[half];
		int[] b1 = new int[size_b - half];

		if(size_b > half)
		{
			for(int i=0; i<size_b-half; ++i)
			{
				b1[i] = b[half+i];
			}
		}


		for(int i=0; i<size_a-half; ++i)
		{
			a1[i] = a[half+i];
		}

		for(int i=0; i<half; ++i)
		{
			a0[i] = a[i];

			if(i < size_b)
			{
				b0[i] = b[i];
			}
		}


		int[] z2 = karatsuba(a1, b1);
		int[] z0 = karatsuba(a0, b0);

		System.out.println("z2");
		for(int t : z2)
		{
			System.out.print(t + " ");
		}
		System.out.println();

		System.out.println("z0");
		for(int t : z0)
		{

			System.out.print(t + " ");
		}
		System.out.println();


		System.out.println("1");
		addTo(a0, a1, 0);

		System.out.println("2");
		addTo(b0, b1, 0);

		int[] z1 = karatsuba(a0, b0);

		subFrom(z1, z0);
		subFrom(z1, z2);

		int[] ret = new int[size_a+size_b];

		System.out.println("3");
		addTo(ret, z0, 0);
		System.out.println("4");
		addTo(ret, z2, half*2);

		System.out.println("5");
		addTo(ret, z1, half);

		return ret;
	}


	public static void addTo(int[] a, int[]b, int k)
	{
		System.out.println("k : " + k);
		System.out.println("b.length : " + b.length);
		
		System.out.println("array a");
		for(int t : a)
		{
			System.out.print(t + " ");
		}

		System.out.println();
		System.out.println("array b");

		for(int t : a)
		{
			System.out.print(t + " ");
		}

		for(int i=0; i<b.length; ++i)
		{
			System.out.println("i : " + i);
			a[k+i] += b[i];
		}
		nomalize(a);
	}

	public static void subFrom(int[] a, int[] b)
	{
		int i = 0;
		while(i < b.length)
		{
			a[i] -= b[i];
			++i;
		}
		nomalize(a);
	}


	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		String input;

		input = scan.next();

		char[] aC = input.toCharArray();

		input = scan.next();
		char[] bC = input.toCharArray();

		int[] a = new int[aC.length];
		int[] b = new int[bC.length];


		for(int i=aC.length-1; i>=0 ; --i)
		{
			a[aC.length-1-i] = aC[i] - 0x30; 
		}

		for(int i=bC.length-1; i>=0 ; --i)
		{
			b[bC.length-1-i] = bC[i] - 0x30;
		}


		for(int t : a)
		{
			System.out.print(t + " ");
		}
		System.out.println();

		for(int t : b)
		{
			System.out.print(t + " ");
		}
		System.out.println();

		
		int[] sum = karatsuba(a, b);

		printBigIntArray(sum);


	 scan.close();
	}
}
