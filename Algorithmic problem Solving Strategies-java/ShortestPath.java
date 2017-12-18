/*
프로그램 명 : ShortestPath
설명 : n개의 도시 각각 서로 경로가 연결되어 있다. 모든 도시를 순회하는 가장 짧은 경로를 찾아라.
방법 : 알고리즘 문제해결전략 p.165답안을 보고 재현

*/


import java.util.*;

class  ShortestPath
{
	// MAX는 도시의 수
	// dist는 각 도시의 거리를 짝지은 표
	// visited는 각 도시를 방문했는지 안했는지를 체크하는 표
	// INF는 가장 큰값을 사용. 최소값을 찾기위한 장치

	public static int n;
	public static int MAX = 10;
	public static double[][] dist = new double[MAX][MAX];
	public static boolean[] visited = new boolean[MAX];
	public static final double INF = Integer.MAX_VALUE;


	public static double shortestPath(boolean[] visited, Stack<Integer> path, double currentLength)
	{
		// 기저사례 : Stack의 사이즈가 도시의 크기와 같아지는 상황(방문순서를 Stack에 쌓아서 사용)
		if(path.size() == n)
		{
			System.out.println("ShorestPath now : " + (currentLength + dist[0][path.peek()]));
			return currentLength + dist[0][path.peek()];
		}

		// 최소값 추출을 위한 비교값 설정
		double ret = INF;


		// 각 도시중 방문하지 않은 도시를 찾아 경로를 작성.
		for(int next=0; next<n; ++next)
		{
			if(visited[next])
			{
				continue;
			}

			// 현재의 위치를 확인하고 저장함. 배열에서 현재도시와 다음 도시의 거리를 가리키기 위함.
			int here;

			// next즉, 다음에 방문할 도시에 방문을 표시.

			// 현재 위치를 기억해두고, path Stack에 다음 행선지를 push.
			visited[next] = true;
			if(path.empty()) here=0;
			else{
			here = path.peek();
			}
			path.push(next);

			System.out.println("Push : " + next);

			double cand = shortestPath(visited,path,currentLength+dist[next][here]);
			

			// 매우 중요 잘 이해가 안되었다.
			// 역시 이런경우는 하나의 전체 사례가 만들어지는 과정을 상상하는 것이 좋다.
			// 선택 트리를 생각하라는 뜻.

			// 중간 갈래에서 값이 비교되고 다시 다음 선택지로 순회한다.

			// 하나의 사례가 만들어지면 거리의 합이 cand에 저장된다.
			// min함수로 최소값만 남긴다.
			ret = Math.min(ret, cand);

			//현재 방문지를 방문 취소하고 현재 선택을 초기화하여, 다른 방문지를 방문할 수 있도록 한다.
			visited[next] = false;

System.out.println("Poped : " + path.pop());



		}
		return ret;
	}


	public static void main(String[] args) 
	{
		n=4;
		Scanner scan = new Scanner(System.in);

		for(int i=0; i<n; ++i)
		{
			for(int j=0; j<n; ++j)
			{
				if(i==j || dist[i][j] != 0)
				{
					continue;
				}

				dist[i][j] = dist[j][i] = scan.nextDouble();
			}
		}
		
		Stack<Integer> path = new Stack();

		System.out.println(shortestPath(visited,path,0));


	}
}
