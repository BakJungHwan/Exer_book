/*
���α׷� �� : ��ǳ
�� �� : �־��� ��� �л����� 'ģ��'�鳢�� ¦���� ����� �� ����
�� �� : �˰��� ����Ǯ������ p.155 ~ 157 ��ȱ��� ������ �� ����

*/

import java.util.*;

class Picnic 
{
	// ģ���� ¦����ִ� ���α׷�.
	// ret�� return���� �����ϴ� ����
	// stu�� ���� �÷ο쿡�� ¦�����ְ� �ִ� ���
	// �ߺ��� ���ϱ� ����, ¦������� ���� ���� ù��° �л����� ��Ī
	// map�� ģ�����谡 ������ true, �ƴϸ� false�� ����� �����. ��ǥ�� ���� ���� ����Ͽ� ��Ī������ ����
	// taken�� ¦�� �ִ��� ���θ� �����ϴ� �迭
	public static int makeFriend(boolean[][] map, boolean[] taken)
	{
		int ret=0;
		int stu=0;

		// ��Ī���� ���� ���� ���� �л��� ã�´�.
		// ��, �л��� �迭�� index�� ����� �����÷ο� �ǹǷ� ���ǹ��� �ɾ�д�.
		while(stu != map.length && taken[stu])
		{
			System.out.println("taken[" + stu + "]=" + taken[stu]);
			++stu;
		}

		// ��� �л��� ��Ī�Ǹ�, ���� �л��� index���� �л��̴�.
		// ��Ī ������ ����� ã������ ����� 1�� �����Ѵ�.
		if(stu == map.length)
		{
			ret = 1;
			return ret;
		}
		
		// ���� ¦������ �л��� ��Ī���״ٰ� ǥ���صд�.
		taken[stu] = true;

		// ���� �л��� ģ���� �л��� ã�Ƽ� ��Ī��Ų��.
		// ���� �л����� �տ� �ִ� �л��� �̹� ��Ī�� �����̱� ������ ��ȸ�� �ʿ䰡 ����.
		// ���� �л��ٷ� �������� ��ȸ�Ѵ�.
		for(int i=stu+1; i<map.length; ++i)
		{
			// ����� ��Ī���� �ʾ�����, ģ���� �л�
			if(!taken[i] && map[stu][i])
			{
				// �����л��� ¦�� ��Ī��Ų��.
				// ����� ���ÿ� �����Ǵ� ���̱� ������
				// taken[stu] = taken[i] = true;
				// �� �ǹ������� �ξ� ���ƺ��δ�.

				taken[i] = true;
				System.out.println("stu = " + stu);
				System.out.println("i = " + i);

				// �̹��� ��Ī���� ���� ������ ��Ī���� ���� �� �ִ� ����� ���� ���Ѵ�.
				ret += makeFriend(map, taken);

				// ��Ī�� ����ϰ�, �ݺ������� ���ư��� �ٸ� ¦������ ����� �ִ��� ��ȸ�Ѵ�.
				// �̰�쿡�� ���谡 ���ÿ� ������� ���̱� ������
				// taken[stu] = taken[i] = false;
				// �� �ǹ������� �Ǹ��� ǥ����̶�� �����ȴ�.
				taken[i] = false;
			}
			
		}

		// ���� �л��� ��� ��Ī�õ��� ����Ǿ����� �л��� ��Ī���¸� �����Ѵ�.
		taken[stu] = false;

		// ����� ���� ��ȯ�Ѵ�.
		return ret;

	}


	// ����� Ȯ�ο� ����Լ�
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
	
		// C�� ���̽� ��
		// n�� �л���
		// m�� ģ�� �����
		// k�� l�� ģ�� ������� �����ϱ� ���� �ε���

		int C;
		int n;
		int m;
		int k;
		int l;

		Scanner scan = new Scanner(System.in);

		C = scan.nextInt();

		// case ����ŭ �ݺ��Ѵ�.
		for(int i=0; i<C; ++i)
		{
			n = scan.nextInt();
			m = scan.nextInt();

			// ����ʰ� ��Ī�л� üũ �迭�� ����
			// �⺻������ false�� �ʱ�ȭ�Ǳ� ������ �״�� �д�.
			boolean[][] map = new boolean[n][n];
			boolean[] taken = new boolean[n];
			
			
			// �Է¹��� ģ�����踦 ����ʿ� �����Ѵ�.
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
