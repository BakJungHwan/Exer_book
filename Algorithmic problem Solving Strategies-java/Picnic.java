/*
프로그램 명 : 소풍
설 명 : 주어진 모든 학생들을 '친구'들끼리 짝찌우는 경우의 수 세기
방 법 : 알고리즘 문제풀이전략 p.155 ~ 157 답안까지 공부한 후 재현

*/

import java.util.*;

class Picnic 
{
	// 친구를 짝찌워주는 프로그램.
	// ret는 return값을 누적하는 변수
	// stu는 현재 플로우에서 짝지워주고 있는 대상
	// 중복을 피하기 위해, 짝찌워지지 않은 가장 첫번째 학생부터 매칭
	// map은 친구관계가 있으면 true, 아니면 false로 저장된 관계맵. 좌표가 꼬일 것을 대비하여 대칭형으로 세팅
	// taken은 짝이 있는지 여부를 저장하는 배열
	public static int makeFriend(boolean[][] map, boolean[] taken)
	{
		int ret=0;
		int stu=0;

		// 매칭되지 않은 가장 앞의 학생을 찾는다.
		// 단, 학생이 배열의 index를 벗어나면 오버플로우 되므로 조건문을 걸어둔다.
		while(stu != map.length && taken[stu])
		{
			System.out.println("taken[" + stu + "]=" + taken[stu]);
			++stu;
		}

		// 모든 학생이 매칭되면, 현재 학생은 index밖의 학생이다.
		// 매칭 가능한 방법을 찾았으니 결과로 1을 리턴한다.
		if(stu == map.length)
		{
			ret = 1;
			return ret;
		}
		
		// 현재 짝지워줄 학생을 매칭시켰다고 표시해둔다.
		taken[stu] = true;

		// 현재 학생과 친구인 학생을 찾아서 매칭시킨다.
		// 현재 학생보다 앞에 있는 학생은 이미 매칭된 상태이기 때문에 순회할 필요가 없다.
		// 현재 학생바로 다음부터 순회한다.
		for(int i=stu+1; i<map.length; ++i)
		{
			// 대상은 매칭되지 않았으며, 친구인 학생
			if(!taken[i] && map[stu][i])
			{
				// 현재학생의 짝을 매칭시킨다.
				// 관계는 동시에 생성되는 것이기 때문에
				// taken[stu] = taken[i] = true;
				// 가 의미적으로 훨씬 좋아보인다.

				taken[i] = true;
				System.out.println("stu = " + stu);
				System.out.println("i = " + i);

				// 이번에 매칭되지 않은 나머지 매칭에서 나올 수 있는 경우의 수를 더한다.
				ret += makeFriend(map, taken);

				// 매칭을 취소하고, 반복문으로 돌아가서 다른 짝지워줄 대상이 있는지 순회한다.
				// 이경우에도 관계가 동시에 사라지는 것이기 때문에
				// taken[stu] = taken[i] = false;
				// 가 의미적으로 훌륭한 표기법이라고 생각된다.
				taken[i] = false;
			}
			
		}

		// 현재 학생의 모든 매칭시도가 종료되었으니 학생의 매칭상태를 해제한다.
		taken[stu] = false;

		// 경우의 수를 반환한다.
		return ret;

	}


	// 관계맵 확인용 출력함수
	/*
	public static void printFriendMap(int[][] map)
	{
		for(int i=0; i<map.length; ++i)
		{
			for(int j=0; j<map[0].length; ++j)
			{
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	*/

	
	public static void main(String[] args) 
	{
	
		// C는 케이스 수
		// n은 학생수
		// m은 친구 관계수
		// k와 l은 친구 관계맵을 설정하기 위한 인덱스

		int C;
		int n;
		int m;
		int k;
		int l;

		Scanner scan = new Scanner(System.in);

		C = scan.nextInt();

		// case 수만큼 반복한다.
		for(int i=0; i<C; ++i)
		{
			n = scan.nextInt();
			m = scan.nextInt();

			// 관계맵과 매칭학생 체크 배열을 생성
			// 기본적으로 false로 초기화되기 때문에 그대로 둔다.
			boolean[][] map = new boolean[n][n];
			boolean[] taken = new boolean[n];
			
			
			// 입력받은 친구관계를 관계맵에 세팅한다.
			for(int j=0; j<m; ++j)
			{
				k = scan.nextInt();
				l = scan.nextInt();

				map[k][l] = true;
				map[l][k] = true;
			}

			System.out.println(makeFriend(map, taken));
		}


		


	}
}
