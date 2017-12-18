/*
���α׷� �� : ShortestPath
���� : n���� ���� ���� ���� ��ΰ� ����Ǿ� �ִ�. ��� ���ø� ��ȸ�ϴ� ���� ª�� ��θ� ã�ƶ�.
��� : �˰��� �����ذ����� p.165����� ���� ����

*/


import java.util.*;

class  ShortestPath
{
	// MAX�� ������ ��
	// dist�� �� ������ �Ÿ��� ¦���� ǥ
	// visited�� �� ���ø� �湮�ߴ��� ���ߴ����� üũ�ϴ� ǥ
	// INF�� ���� ū���� ���. �ּҰ��� ã������ ��ġ

	public static int n;
	public static int MAX = 10;
	public static double[][] dist = new double[MAX][MAX];
	public static boolean[] visited = new boolean[MAX];
	public static final double INF = Integer.MAX_VALUE;


	public static double shortestPath(boolean[] visited, Stack<Integer> path, double currentLength)
	{
		// ������� : Stack�� ����� ������ ũ��� �������� ��Ȳ(�湮������ Stack�� �׾Ƽ� ���)
		if(path.size() == n)
		{
			System.out.println("ShorestPath now : " + (currentLength + dist[0][path.peek()]));
			return currentLength + dist[0][path.peek()];
		}

		// �ּҰ� ������ ���� �񱳰� ����
		double ret = INF;


		// �� ������ �湮���� ���� ���ø� ã�� ��θ� �ۼ�.
		for(int next=0; next<n; ++next)
		{
			if(visited[next])
			{
				continue;
			}

			// ������ ��ġ�� Ȯ���ϰ� ������. �迭���� ���絵�ÿ� ���� ������ �Ÿ��� ����Ű�� ����.
			int here;

			// next��, ������ �湮�� ���ÿ� �湮�� ǥ��.

			// ���� ��ġ�� ����صΰ�, path Stack�� ���� �༱���� push.
			visited[next] = true;
			if(path.empty()) here=0;
			else{
			here = path.peek();
			}
			path.push(next);

			System.out.println("Push : " + next);

			double cand = shortestPath(visited,path,currentLength+dist[next][here]);
			

			// �ſ� �߿� �� ���ذ� �ȵǾ���.
			// ���� �̷����� �ϳ��� ��ü ��ʰ� ��������� ������ ����ϴ� ���� ����.
			// ���� Ʈ���� �����϶�� ��.

			// �߰� �������� ���� �񱳵ǰ� �ٽ� ���� �������� ��ȸ�Ѵ�.

			// �ϳ��� ��ʰ� ��������� �Ÿ��� ���� cand�� ����ȴ�.
			// min�Լ��� �ּҰ��� �����.
			ret = Math.min(ret, cand);

			//���� �湮���� �湮 ����ϰ� ���� ������ �ʱ�ȭ�Ͽ�, �ٸ� �湮���� �湮�� �� �ֵ��� �Ѵ�.
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
