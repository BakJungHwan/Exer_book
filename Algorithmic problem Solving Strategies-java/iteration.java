/*
���α׷� �� : n�� ���ҿ��� m�� ���� ��� ����ϱ�
�ڵ� ���� : �˰��� �����ذ� ������ �����ϰ� Ǯ�� �н�
�ڵ� ��� : 1�� 149p.�� �ִ� c++ �ڵ带 �������� ����, �ణ�� ����
*/


class  iteration
{
	
	// ����Լ� ����
	// pick = ���õ� n���� �� [0, n)
	// picked = ���õ� ���� ����Ǵ� �迭
	// topick = ������ ���� m
	// currentpick = ���� �����ϴ� ���� ��ġ(�ڸ�)

	public static void recursiveIteration(int pick, int[] picked, int topick, int currentpick)
	{
		// ���� �ڸ����� topick�� ���ٴ� �� �迭�� �����ϸ� �����ȴٴ� ��
		// �׷��Ƿ� ���� ��ʷ� ����

		if(currentpick == topick)
		{
			// picked�� �ִ� ������ ���
			for(int i = 0; i<picked.length ; ++i)
			{
				System.out.print(picked[i] + " ");
			}
			System.out.println();
			return;
		}

		// ���� ���ÿ��� ������ �� �ִ� ���� ���� ���� ����
		int smallest;
	
		if(currentpick == 0)
		{
			smallest=0;
		}
		else
		{
			// ������ ����� ��Ȳ�̹Ƿ�, ������ ������ ���ؼ� ������ ���ذ�
			// �����ڸ��� �� ���� �տ� ���� ������ 1ū���� �־� �ߺ��Ǵ� ����� ���� ����
			smallest=picked[currentpick-1]+1;
		}

		// ù�ڸ����� [0,n-m) ���� ���� �� ����. ���� n-1�ڸ��� ���ڸ� �־��ַ��� �ִ밪�� ����ؾ���.
		// ���� ������ ��°�ڸ����� [1,n-m+1)���� ���� �� ����.
		for(int i=smallest ; i<pick - (topick - 1 - currentpick) ; ++i)
		{
			picked[currentpick] = i;
			recursiveIteration(pick, picked, topick, currentpick+1);
		}
		
		return;

	}



	public static void main(String[] args) 
	{
		int pick = 10;
		int topick = 2;
		int[] picked = new int[topick];

		recursiveIteration(pick,picked,topick,0);

		return;
	}
}
