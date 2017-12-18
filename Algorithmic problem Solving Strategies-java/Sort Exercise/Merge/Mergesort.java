class Mergesort
{
	public static void mergesort(int[] array, int begin, int end)
	{
		if(begin >= end)
		{
			return;
		}
		
		int mid = (begin+end)/2;

		mergesort(array, begin, mid);
		mergesort(array, mid+1, end);
		merge(array, begin, end, mid);
	}

	public static void merge(int[] array, int begin, int end, int mid)
	{
		int[] temp = new int[end-begin + 1];
		
		int b = begin;
		int m = mid+1;
		int tempP = 0;

		while(b <= mid && m <= end)
		{
			if(array[b] <= array[m])
			{
				temp[tempP] = array[b];
				++tempP;
				++b;
			}
			else
			{
				temp[tempP] = array[m];
				++tempP;
				++m;
			}

		}


		if(b > mid)
		{
			while(m <= end)
			{
				temp[tempP] = array[m];
				++tempP;
				++m;
			}
		}
		else
		{
			while(b <= mid)
			{
				temp[tempP] = array[b];
				++tempP;
				++b;
			}
		}


		for(int i=begin; i<=end; ++i)
		{
			array[i] = temp[i-begin];
		}


		System.out.print("{ ");
		for(int a : array)
		{
			System.out.print(a + ", ");
		}
		System.out.printf("\b\b }\n");

		

	}



	public static void main(String[] args) 
	{
		int[] array = {12,6,2,88,12,33,7,17,47,57,43,22,4,76,5,7};
		
		System.out.print("{ ");
		for(int a : array)
		{
			System.out.print(a + ", ");
		}
		System.out.printf("\b\b }\n");

		mergesort(array,0,array.length-1);

				System.out.print("{ ");
		for(int a : array)
		{
			System.out.print(a + ", ");
		}
		System.out.printf("\b\b }\n");
	}
}
