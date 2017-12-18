/*
���α׷� �� : Ŭ�� ��ũ
���� : �־��� 16�� �ð迡�� ������ �ð��� �ְ�, 10���� ����ġ�� �־�����.
	10���� ����ġ�� ������ �ش��ϴ� �ð��� ��ħ�� 3�ð��� ���Ѵ�.
	����ġ�� ������ ��� �ð��� �ð��� 12�÷� ���߱� ���� ����ġ�� ���� Ƚ���� ����,
	�� �ּҰ��� ��ȯ�Ѵ�. �׷��� ������ -1�� ��ȯ�Ѵ�.
��� : p.168�� �ð���߱� ���� ����� �̸� �����¿��� ������ ��.

*/

import java.util.*;

class  ClockSync
{
	// INFINITE���� �����Ѵ�. �ּҰ��� �̾Ƴ��� ����.
	// ����ġ�� �����̴� �ð踦 �����Ų��.
	public static final int INF = Integer.MAX_VALUE;
	public static final int[][] clockSwitch = {
		{0, 1, 2},
		{3, 7, 9, 11},
		{4, 10, 14, 15},
		{0, 4, 5, 6, 7},
		{6, 7, 8, 10, 12},
		{0, 2, 14, 15},
		{3, 14, 15},
		{4, 5, 7, 14, 15},
		{1, 2, 3, 4, 5},
		{3, 4, 5, 9, 13}
	};


	// clock�� ���� �ð��� �ð��� �����ϴ� �迭�̴�.
	public static int[] clock = new int[16];

	// countPushSwitch�� ����ġ�� ����̳� �������� �����ϴ� �迭�̴�.
	// �׷��� �ܼ� �������� ����� �ذ��� �� �ִٴ� ���� �� �� �־���.

	public static int[] countPushSwitch = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};


	// ���ϴ� ��Ȳ�� �Ǿ��� ��, �� ��� ����ġ�� �������� �˷��ִ� �Լ�
	public static int countProperSettings(int currentSwitch)
	{
		// ret�� ���ϰ��� �����ϰ� ó���� �����̴�.
		int ret = 0;

		// ���� �������� ����ġ�� index�� 10�̸� ���̻� ���� ����ġ�� ���� ���̴�.
		if(currentSwitch == 10)
		{

			// ������ ���� �ڵ�. �� ����ġ�� ���� Ƚ���� �����Ͽ��ٰ�
			// ���⼭ �� ���� ���� �Ŀ� ��ȯ�Ͽ���.
			/*
			if(checkClock())
			{
				for(int count : countPushSwitch)
				{
					ret+=count;	
				}
				return ret;
			}else
			{
				ret = -1;
			}
			return INF;
			*/


			// ���� �ڵ�, ���� ������ for������ �ϱ� ������ �����ϴ� �ڵ尡 �ʿ䰡 ����.
			// INF�� ������� �ʰ� 100000�� ����� ���� INF�� ��ȯ���� ��,
			// �Ʒ� �������� ���ϴ� ���Ŀ� INF�� ���������ν� �������� �����÷ο찡 �Ͼ�� �����̴�.

			if(checkClock())
			{
				return 0;
			}
			return 100000;
		}

		// �ּҰ��� ���ϱ� ���� ���ϰ��� INF�� �����ߴ�. �̰͵� 100000���� �����ص� ū ������ ����.
		// �ֳ��ϸ� ����ġ �׹��� ������ ���ڸ��� ���ƷιǷ� ����ġ�� ���´� 0,1,2,3 �װ����� �� �� �ִ�.
		// ����ġ�� ������ Ƚ���� ���� ���ƺ��� 30�̴�. �� �̻��� �ǹ̰� ���� �۵��̴�.

		ret=INF;

		for(int i=0; i<4; ++i)
		{
			// ���� �ڵ�� ���� �ڵ尡 �ٸ���.
			// ���� �ڵ� : �� ����ġ�� �۵�Ƚ���� �迭�� �����ϰ�, �۵���Ų��.
			//			����Լ��� ���� ���� �ܰ��� �ݺ������� �����ϰ� ���������� �ϳ��� ��ʸ� �����.
			//			���� �ڵ忡���� �� ��ü ����� ����ġ �۵�Ƚ���� ������ʿ��� ��꿡�� ��ȯ�Ѵ�.

			// ���� �ڵ� : ���� ����ġ �۵�Ƚ���� ���� ����Լ����� ����ġ �۵�Ƚ���� ��ȯ�ϰ� �ȴ�.
		
			/*
			countPushSwitch[currentSwitch] = i;
			if(i>0)
			{
					pushCurrentSwitch(currentSwitch);
			}
			
			int temp = countProperSettings(currentSwitch+1);
			ret = Math.min(ret,temp);
			*/
			
			ret = Math.min(ret, i+countProperSettings(currentSwitch+1));
			pushCurrentSwitch(currentSwitch);

		}

		/*
		pushCurrentSwitch(currentSwitch);
		countPushSwitch[currentSwitch] = 0;
		*/
		return ret;
	}


	// ����ġ�� �۵������� �� �ð��� ��ħ�� �̵���Ű�� �Լ��̴�.
	public static void pushCurrentSwitch(int currentSwitch)
	{
		for(int i=0; i<clockSwitch[currentSwitch].length; ++i)
		{
			clock[clockSwitch[currentSwitch][i]]+=3;
			if(clock[clockSwitch[currentSwitch][i]] == 15)
			{
				clock[clockSwitch[currentSwitch][i]] = 3;
			}
		}
	}


	// �ð���� ��� 12�ÿ� ��ġ�� �ִ��� Ȯ���ϴ� �Լ��̴�.
	public static boolean checkClock()
	{
		for(int i=0; i<16; ++i)
		{
			if(clock[i]!=12)
			{
				return false;
			}
		}
		return true;
	}


	public static void main(String[] args) 
	{
		int C;
		Scanner scan = new Scanner(System.in);

		C = scan.nextInt();

		for(int i=0; i<C ;++i)
		{
			for(int j=0; j<16; ++j)
			{
				clock[j] = scan.nextInt();
			}
			System.out.println(countProperSettings(0));
		}

	}
}
