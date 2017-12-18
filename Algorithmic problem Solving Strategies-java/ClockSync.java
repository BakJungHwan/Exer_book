/*
프로그램 명 : 클록 싱크
설명 : 주어진 16개 시계에서 각가의 시간이 있고, 10개의 스위치가 주어진다.
	10개의 스위치는 누르면 해당하는 시계의 시침을 3시간씩 더한다.
	스위치를 눌러서 모든 시계의 시간을 12시로 맞추기 위해 스위치를 누른 횟수를 세고,
	그 최소값을 반환한다. 그렇지 않으면 -1을 반환한다.
방법 : p.168의 시계맞추기 문제 답안을 미리 본상태에서 재현한 것.

*/

import java.util.*;

class  ClockSync
{
	// INFINITE값을 설정한다. 최소값을 뽑아내기 위함.
	// 스위치별 움직이는 시계를 연결시킨다.
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


	// clock은 현재 시계의 시간을 저장하는 배열이다.
	public static int[] clock = new int[16];

	// countPushSwitch는 스위치를 몇번이나 눌렀는지 저장하는 배열이다.
	// 그러나 단순 누적으로 충분히 해결할 수 있다는 것을 알 수 있었다.

	public static int[] countPushSwitch = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};


	// 원하는 상황이 되었을 때, 총 몇번 스위치를 눌렀는지 알려주는 함수
	public static int countProperSettings(int currentSwitch)
	{
		// ret는 리턴값을 저장하고 처리할 별수이다.
		int ret = 0;

		// 현재 눌러보는 스위치의 index가 10이면 더이상 누를 스위치가 없는 것이다.
		if(currentSwitch == 10)
		{

			// 이전에 만든 코드. 각 스위치별 누른 횟수를 저장하였다가
			// 여기서 그 합을 구한 후에 반환하였다.
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


			// 현재 코드, 값의 누적을 for문에서 하기 때문에 누적하는 코드가 필요가 없다.
			// INF를 사용하지 않고 100000을 사용한 것은 INF를 반환했을 때,
			// 아래 누적값을 구하는 수식에 INF가 더해짐으로써 정수값의 오버플로우가 일어났기 때문이다.

			if(checkClock())
			{
				return 0;
			}
			return 100000;
		}

		// 최소값을 구하기 위해 리턴값을 INF로 설정했다. 이것도 100000으로 설정해도 큰 무리가 없다.
		// 왜냐하면 스위치 네번을 누르면 제자리로 돌아로므로 스위치의 상태는 0,1,2,3 네가지로 볼 수 있다.
		// 스위치를 누르는 횟수의 함은 많아봐야 30이다. 그 이상은 의미가 없은 작동이다.

		ret=INF;

		for(int i=0; i<4; ++i)
		{
			// 이전 코드와 현재 코드가 다르다.
			// 이전 코드 : 각 스위치별 작동횟수를 배열에 저장하고, 작동시킨다.
			//			재귀함수를 통해 다음 단계의 반복문으로 진입하고 최종적으로 하나의 사례를 만든다.
			//			이전 코드에서는 그 전체 사례의 스위치 작동횟수를 기저사례에서 계산에서 반환한다.

			// 현재 코드 : 현재 스위치 작동횟수에 다음 재귀함수에서 스위치 작동횟수를 반환하게 된다.
		
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


	// 스위치를 작동시켰을 때 시계의 시침을 이동시키는 함수이다.
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


	// 시계들이 모두 12시에 위치해 있는지 확인하는 함수이다.
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
