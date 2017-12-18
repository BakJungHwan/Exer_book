/*
프로그램명 : Mergesort연습

*/

class  Mergesort
{
	public static void mergesort(int[] array, int begin, int end)
	{
		if(begin >= end)
		{
			return;
		}

		int q = (begin + end)/2;
		
		mergesort(array, begin, q);
		mergesort(array, q+1, end);

		merge(array,begin,end,q);
		

		for(int a : array)
		{
			System.out.print(a + " ");
		}
		System.out.println();

	}

	public static void merge(int[] array, int begin, int end, int q)
	{
		int[] temp = new int[array.length];
		int i = begin;

		int p1 = begin;
		int p2 = q+1;
		
		while( p1 <= q && p2 <= end)
		{
			if(array[p1] < array[p2])
			{
				temp[i] = array[p1];
				++i;
				++p1;
			}
			else
			{
				temp[i] = array[p2];
				++i;
				++p2;
			}
		}

		

		// 여기서 p1값을 못잡아서 애먹었는데, 사실 p1이나 p2가 기준 범위를 초과했다면
		// 그때부터, 초과한 해당 포인터가 아닌 다른 포인터로 전달할 일밖에 없기 때문에
		// 별 상관이 없었다. ㅡㅡ;

		if(p1 == q+1)
		{
			while(p2 != end+1)
			{
				temp[i] = array[p2];
				++i;
				++p2;
			}
		}
		else
		{
			while(p1 != q+1)
			{
				temp[i] = array[p1];
				++i;
				++p1;
			}
		}

		for(i=begin; begin <= end; ++begin)
		{
			
			array[begin] = temp[begin];
		}
	}



	public static void main(String[] args) 
	{
		int[] array = {7,93,1,6,3,2,1,1,7,7,10,33,57};

		for(int i : array)
		{
			System.out.print(i + ", ");
		}
		System.out.println();


		mergesort(array,0,array.length-1);

		for(int i : array)
		{
			System.out.print(i + ", ");
		}

		System.out.println();

	}
}
