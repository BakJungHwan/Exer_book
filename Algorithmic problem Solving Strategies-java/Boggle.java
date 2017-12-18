/*
���α׷� �� : Boggle
���� : 5X5 ���ھȿ� ���ĺ� �빮�ڰ� ���ִ�. ������ ��ġ���� �����¿�밢������ ����ؼ� �����Ͽ� �ش��ϴ� �ܾ ã�� �� �ִ��� ���θ� ã�� �����̴�.
��� : p. 150~152�� ������ �����Ͽ� ����

*/


class  Boggle
{

	// �ֺ� ��ǥ �˻��� ���� �̵���ǥ ��Ʈ!!
	public static final int[] dx = {1,1,1,-1,-1,-1,0,0};
	public static final int[] dy = {1,0,-1,1,0,-1,1,-1};


	
	// �־��� ����
	public static String[] map = {"NNNNS","NEEEN","NEYEN","NEEEEN", "NNNNN"};
	
	public static boolean hasWord(int x, int y, String word)
	{

		// ���ڸ� ��� ��ǥ�� ��� false ��ȯ
		if( x<0 || y<0 || x>4 || y>4 )
		{
			System.out.println("F out of range");
			return false;
		}

		
		// ���� ã�� �ִ� ���ڿ� ���� ��ġ�� ���� ���ڰ� ���� ������ false��ȯ

		// String.substring()�� String�� ��ȯ�ϴµ� �ű��ϰԵ�, ���� ������ ����� String == String�� true�� �ݸ�,
		// String.substring()�� ��°���� ���Ƶ� String.substring(~,~) == String.substring(~,~)�� false�� ���Դ�.
		// �׷��� charAt�� ����ؼ� �񱳸� ���� ���� true�� ���Դ�.
		// ComparedString�� ������ ������ �ۼ��� �ξ���.

		if(word.charAt(0) != map[x].charAt(y))
		{
			System.out.println(word.substring(0,1));
			System.out.println(map[x].substring(y,y+1));
			System.out.println("F No matching");
			return false;
		}

		// ��ǥ�� ���ڸ� ����� �ʾ���.
		// ���� ã�� �ִ� ���ڿ� ���� ��ġ�� ���� ���ڰ� ��ġ��.
		// ����Լ��� ȣ���� ��, ��Ī�� ���ڸ� �ڸ��� �� �������ڸ� �����ϰ� �����Ƿ�, ���޵� ���ڿ��� ���̰� 1�̸�, ��� ��Ī�� ��Ȳ�̴�.

		if(word.length() == 1)
		{
			System.out.println("T word");
			return true;			
		}

		
		// �ֺ� ��ǥ�� �˻��Ͽ� ���ڿ��� �����κ��� Ž��

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
