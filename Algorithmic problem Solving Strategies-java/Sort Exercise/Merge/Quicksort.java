class Quicksort 
{
	public static void quicksort(int[] array, int begin, int end)
	{
		if(begin >= end)
		{
			return;
		}


		int mid = partitioning(array, begin, end);

		quicksort(array, begin, mid-1);
		quicksort(array, mid+1, end);
	}


	public static int partitioning(int[] array, int begin, int end)
	{	
		int i = begin-1;

		while(begin <= end-1)
		{
			if(array[begin] <= array[end])
			{
				int temp=array[begin];
				array[begin] = array[++i];
				array[i] = temp;
			}
			++begin;
		}

		System.out.println("end : " + array[end]);

		if(array[end] < array[i+1])
		{
			int temp = array[++i];
			array[i] = array[end];
			array[end] = temp;
		}
	
			System.out.print("{ ");
		for(int a : array)
		{
			System.out.print(a + ", ");
		}
		System.out.printf("\b\b }\n");


		return i;
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


		quicksort(array, 0, array.length-1);

		System.out.print("{ ");
		for(int a : array)
		{
			System.out.print(a + ", ");
		}
		System.out.printf("\b\b }\n");


	}
}
