/*
프로그램 명 : n개 원소에서 m개 원소 사례 출력하기
코딩 이유 : 알고리즘 문제해결 전략의 무식하게 풀기 학습
코딩 방식 : 1권 149p.에 있는 c++ 코드를 바탕으로 재현, 약간의 개선
*/


class  iteration
{
	
	// 재귀함수 구현
	// pick = 선택될 n개의 수 [0, n)
	// picked = 선택된 수가 저장되는 배열
	// topick = 선택할 갯수 m
	// currentpick = 현재 선택하는 수의 위치(자리)

	public static void recursiveIteration(int pick, int[] picked, int topick, int currentpick)
	{
		// 현재 자리수가 topick과 같다는 건 배열로 접근하면 오버된다는 뜻
		// 그러므로 기저 사례로 설정

		if(currentpick == topick)
		{
			// picked에 있는 값들을 출력
			for(int i = 0; i<picked.length ; ++i)
			{
				System.out.print(picked[i] + " ");
			}
			System.out.println();
			return;
		}

		// 현재 선택에서 선택할 수 있는 가장 작은 수를 설정
		int smallest;
	
		if(currentpick == 0)
		{
			smallest=0;
		}
		else
		{
			// 조합을 만드는 상황이므로, 강제로 순서를 정해서 순서를 없앤것
			// 다음자리에 들어갈 수는 앞에 뽑은 수보다 1큰수를 넣어 중복되는 경우의 수를 없앰
			smallest=picked[currentpick-1]+1;
		}

		// 첫자리수는 [0,n-m) 까지 가질 수 있음. 뒤의 n-1자리에 숫자를 넣어주려면 최대값을 고려해야함.
		// 같은 이유로 둘째자리수는 [1,n-m+1)까지 가질 수 있음.
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
