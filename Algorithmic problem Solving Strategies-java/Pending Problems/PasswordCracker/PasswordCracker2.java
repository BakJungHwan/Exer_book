/*
���α׷� �� : PasswordCracker2
���� : PasswordCracker�� 3��° ����. ù��° ������ �����Ͽ� �ӵ��� �������״�. 
���� : HackerRank�� PasswordCracker������ Ǭ ��. ������ �߸����� �ټ� �ٸ� ���� ���Դ�.

*/


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PasswordCracker2 {

	// PUT�� �õ��ϴ� ���忡 ��ġ��ų �н����� �ڸ��� '����ߴ�'�� ǥ���ϱ� ���� �ɼ�Ű
	// PICK�� �õ��ϴ� ���忡 ��ġ��Ų �н������� ��ġ�� '������� �ʾҴ�'�� �ٽ� ǥ���ϱ� ���� �ɼ�Ű
    public static final int PUT = 1;
    public static final int PICK = 0;
    

	// �õ��ϴ� ���忡 �ش��ϴ� �н����带 ��ġ��Ű�ų� ��ġ��ҽ�Ű�� �Լ�.
    public static int usePW(String attempt, String[] passwd, int[] usedAttempt, int option, int passNum)
    {
		// �ɼǿ� ���� �Է��� ���� check������ ����
		int check;
		
		if(option == PUT)
		{
			check = passNum;
		}
		else
		{
			System.out.println("check : " + (-1));
			check =-1;
		}

		int fromIndex = 0;
		int ret = 0;

		// passwd�� �ε����κ��� passwd�� �ش��ϴ� ���ڰ� �ִ� �õ������� ��ġ���� üũ
		// �� ���������� ��ġ�� ��� �ܾ���� ��ġ�� ǥ���ϴ� ������ ���ߴ�.
		while(true)
		{
			fromIndex = attempt.indexOf(passwd[passNum],fromIndex);
			if(fromIndex==-1)
			{
				System.out.println("Current usedAttempt");
				for(int a : usedAttempt)
				{
					System.out.print(a + " ");
				}
				System.out.println();

				System.out.println("ret : " + ret);
				System.out.println("passwd : " + passwd[passNum]);
				System.out.println();
				return ret;
			}
			


			if(check==passNum)
			{
				boolean filled = true;
				for(int i=0; i<passwd[passNum].length(); ++i)
				{
					System.out.println("usedAttempt[fromIndex+i] : " + usedAttempt[fromIndex+i]);

					if(usedAttempt[fromIndex+i]==-1)
					{
						System.out.println("1");
						usedAttempt[fromIndex+i] = check;
					}
					else
					{
						for(int j=fromIndex; j<fromIndex+i; ++j)
						{
							System.out.println("2");
							usedAttempt[j] = -1;
						}
						filled = false;
						break;
					}
				}

				if(filled) ret += passwd[passNum].length();
			}
			else
			{
				for(int j=fromIndex; j<passwd[passNum].length(); ++j)
				{
					System.out.println("3");
					usedAttempt[j] = -1;
				}
			}

			fromIndex += passwd[passNum].length();

		}
    }
    


	// ���ǿ� �´� �н����带 ����� �Լ�
	// �õ������ ��ġ��Ų ���ڼ��� ���� �� ���̰� �õ������� ���̿� ������ ����
	// �� �˰��򿡼��� ���������� passwd�迭�� ��ȸ�ϸ� üũ�ص� ��������Ƿ�, ��� passwd�� ��ȸ�������� ������ʿ� �߰��Ͽ���.
    public static boolean makePW(String attempt, String[] passwd, 
		int[] usedAttempt, int countPutAttempt, int countCheckedPassword, boolean[] usedPassword)
    {
		if(countPutAttempt==attempt.length())
		{
			return true;
		}

		if(countCheckedPassword == passwd.length)
		{
			return false;
		}

		// ��ȸ
		for(int i=0; i<passwd.length; ++i)
		{
			// ���� ��ȸ�ϴ� �н����带 �̹� �˻��ߴٸ� ���� �༮���� �̵�
			if(usedPassword[i]) continue;
			
			// ��Ī��ų passwd�� ��ġ�� üũ��.
			// �Լ��� ��Ī�� ���� ������ ��ȯ��.
			usedPassword[i] = true;
			int countPutPWToAttempt = usePW(attempt, passwd, usedAttempt, PUT, i);
			// ��Ī�� ���ڼ��� 0�̸� ��Ī���� �ʾ����Ƿ� �����ϰ� �����н����� �Ѿ.
			// ��Ī�� ���ڰ� �ִٸ�, �ش��ϴ� passwd�� ����ߴٰ� ǥ���ϰ�, ���� ��ȸ�� �Ѿ.
			if(countPutPWToAttempt > 0)
			{
				if(makePW(attempt, passwd, usedAttempt,
					countPutAttempt+countPutPWToAttempt, countCheckedPassword+1, usedPassword))
				{
						return true;
				}

				// ��Ī���״� ���ڸ� ����
				System.out.println("Dematching : " + passwd[i]);
				System.out.println();
				usePW(attempt, passwd, usedAttempt, PICK, i);

			}
			usedPassword[i] = false;
		}

		return false;
       
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
		int N;
		
        for(int i=0; i<T; ++i)
        {
            N = scan.nextInt();
            String[] passwd = new String[N];
        
            for(int j=0; j<N; ++j)
            {
                passwd[j] = scan.next();
            }

			String attempt = scan.next();            
			boolean[] usedPassword = new boolean[N];
			int[] usedAttempt = new int[attempt.length()];
			Arrays.fill(usedAttempt, -1);





			if(makePW(attempt, passwd, usedAttempt,0,0, usedPassword))
			{
				for(int a : usedAttempt)
				{
					System.out.print(a + " ");
				}

				int j=0;
				for(int k=0; k<N; ++k)
				{
					if(usedAttempt[j] == k)
					{
						System.out.print(passwd[k] + " ");
						j+=passwd[k].length();
						k=-1;
						if(j==usedAttempt.length)
						{
							break;
						}
					}
				}
				System.out.println();
					
			}			
			else
			{
				// password�� ����µ� �����ϸ�, WRONG PASSWORD�� ��ȯ
				System.out.println("WRONG PASSWORD");
			}
        }
        
        scan.close();
    }
}