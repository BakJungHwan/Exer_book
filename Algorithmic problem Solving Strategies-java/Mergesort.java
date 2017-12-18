/*
���α׷��� : Mergesort����

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

		

		// ���⼭ p1���� ����Ƽ� �ָԾ��µ�, ��� p1�̳� p2�� ���� ������ �ʰ��ߴٸ�
		// �׶�����, �ʰ��� �ش� �����Ͱ� �ƴ� �ٸ� �����ͷ� ������ �Ϲۿ� ���� ������
		// �� ����� ������. �Ѥ�;

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
