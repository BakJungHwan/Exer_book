/*
프로그램 명 : QuickSort 구현 연습
*/

class Quicksort 
{

	public static void quicksort(int[] array, int p, int q)
	{
		if(p >= q)
		{
			return;
		}

		int big = q-1;
		int small = p;

		while(true)
		{
			while(big>0 && array[big] >= array[q]) --big;
			while(array[small] < array[q]) ++small;
			
			if(small < big)
			{

				int temp = array[big];
				array[big] = array[small];
				array[small] = temp;
			}
			else
			{
				int temp = array[small];
				array[small] = array[q];
				array[q] = temp;
				break;
			}
		}

		quicksort(array, p, small-1);
		quicksort(array, small+1, q);
	}

	public static void main(String[] args) 
	{
		int[] array = {7,93,1,6,3,2,1,1,7,7,10,33,57};

		for(int i : array)
		{
			System.out.print(i + ", ");
		}
		System.out.println();


		quicksort(array,0,array.length-1);

		for(int i : array)
		{
			System.out.print(i + ", ");
		}

		System.out.println();


	}
}
