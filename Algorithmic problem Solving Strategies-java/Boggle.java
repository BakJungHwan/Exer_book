/*
프로그램 명 : Boggle
설명 : 5X5 격자안에 알파벳 대문자가 써있다. 정해진 위치에서 전후좌우대각선으로 계속해서 연결하여 해당하는 단어를 찾을 수 있는지 여부를 찾는 문제이다.
방법 : p. 150~152의 설명을 참조하여 재현

*/


class  Boggle
{

	// 주변 좌표 검색을 위한 이동좌표 세트!!
	public static final int[] dx = {1,1,1,-1,-1,-1,0,0};
	public static final int[] dy = {1,0,-1,1,0,-1,1,-1};


	
	// 주어진 격자
	public static String[] map = {"NNNNS","NEEEN","NEYEN","NEEEEN", "NNNNN"};
	
	public static boolean hasWord(int x, int y, String word)
	{

		// 격자를 벗어난 좌표인 경우 false 반환
		if( x<0 || y<0 || x>4 || y>4 )
		{
			System.out.println("F out of range");
			return false;
		}

		
		// 현재 찾고 있는 문자와 현재 위치한 곳의 문자가 같지 않으면 false반환

		// String.substring()은 String을 반환하는데 신기하게도, 같은 값으로 선언된 String == String은 true인 반면,
		// String.substring()의 출력결과가 같아도 String.substring(~,~) == String.substring(~,~)은 false가 나왔다.
		// 그래서 charAt을 사용해서 비교를 했을 때는 true가 나왔다.
		// ComparedString에 적절한 예제를 작성해 두었다.

		if(word.charAt(0) != map[x].charAt(y))
		{
			System.out.println(word.substring(0,1));
			System.out.println(map[x].substring(y,y+1));
			System.out.println("F No matching");
			return false;
		}

		// 좌표가 격자를 벗어나지 않았음.
		// 현재 찾고 있는 문자와 현재 위치한 곳의 문자가 일치함.
		// 재귀함수를 호출할 때, 매칭된 문자를 자르고 그 다음문자를 전달하고 있으므로, 전달된 문자열의 길이가 1이면, 모두 매칭된 상황이다.

		if(word.length() == 1)
		{
			System.out.println("T word");
			return true;			
		}

		
		// 주변 좌표를 검색하여 문자열의 다음부분을 탐색

		for(int i = 0; i<8 ; ++i)
		{
			int nx = x+dx[i];
			int ny = y+dy[i];

			if(hasWord(nx, ny, word.substring(1)))
			{
				System.out.println("T substring");
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) 
	{
		System.out.println(hasWord(2,2,"YES"));
	}
}
