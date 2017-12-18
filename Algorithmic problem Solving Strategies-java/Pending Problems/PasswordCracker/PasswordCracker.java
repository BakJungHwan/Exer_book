/*
���α׷� �� : PasswordCracker
���� : �־��� ������ �־��� ���� �ܹ��� �������� ��Ÿ�� �� �ִ��� ������ Ȯ���ϴ� ����.
���� : HackerRank�� PasswordCracker������ Ǭ ��. ������ �߸����� �ټ� �ٸ� ���� ���Դ�.

*/


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PasswordCracker {

	// PUT�� �õ��ϴ� ���忡 ��ġ��ų �н����� �ڸ��� '����ߴ�'�� ǥ���ϱ� ���� �ɼ�Ű
	// PICK�� �õ��ϴ� ���忡 ��ġ��Ų �н������� ��ġ�� '������� �ʾҴ�'�� �ٽ� ǥ���ϱ� ���� �ɼ�Ű
    public static final int PUT = 1;
    public static final int PICK = 0;
    

	// �õ��ϴ� ���忡 �ش��ϴ� �н����带 ��ġ��Ű�ų� ��ġ��ҽ�Ű�� �Լ�.
    public static int usePW(String attempt, String passwd, boolean[] usedAttempt, int option)
    {
		// �ɼǿ� ���� �Է��� ���� check������ ����
		boolean check;
		
		if(option == PUT)
		{
			check = true;
		}
		else
		{
			check =false;
		}

		int fromIndex = 0;
		int ret = 0;

		// passwd�� �ε����κ��� passwd�� �ش��ϴ� ���ڰ� �ִ� �õ������� ��ġ���� üũ
		// �� ���������� ��ġ�� ��� �ܾ���� ��ġ�� ǥ���ϴ� ������ ���ߴ�.
		while(true)
		{
			fromIndex = attempt.indexOf(passwd,fromIndex);
			if(fromIndex==-1)
			{
				return ret;
			}

			for(int i=0; i<passwd.length(); ++i)
			{
				usedAttempt[fromIndex+i] = check;
			}

			fromIndex += passwd.length();

			ret += passwd.length();
		}
    }
    


	// ���ǿ� �´� �н����带 ����� �Լ�
	// �õ������ ��ġ��Ų ���ڼ��� ���� �� ���̰� �õ������� ���̿� ������ ����
	// �� �˰��򿡼��� ���������� passwd�迭�� ��ȸ�ϸ� üũ�ص� ��������Ƿ�, ��� passwd�� ��ȸ�������� ������ʿ� �߰��Ͽ���.
    public static boolean makePW(String attempt, String[] passwd, boolean[] usedPassword,
		boolean[] usedAttempt, int countPutAttempt, int countCheckedPassword)
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
			int countPutPWToAttempt = usePW(attempt, passwd[i], usedAttempt, PUT);
			
			// ��Ī�� ���ڼ��� 0�̸� ��Ī���� �ʾ����Ƿ� �����ϰ� �����н����� �Ѿ.
			// ��Ī�� ���ڰ� �ִٸ�, �ش��ϴ� passwd�� ����ߴٰ� ǥ���ϰ�, ���� ��ȸ�� �Ѿ.
			if(countPutPWToAttempt > 0)
			{
				usedPassword[i] = true;
				if(makePW(attempt, passwd, usedPassword,
					usedAttempt, countPutAttempt+countPutPWToAttempt, countCheckedPassword+1))
				{
					return true;
				}

				// ��Ī���״� ���ڸ� ����
				usePW(attempt, passwd[i], usedAttempt, PICK);

				// passwd�� ����ߴٴ� ǥ�õ� ����
				usedPassword[i] = false;
			}
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
			boolean[] usedAttempt = new boolean[attempt.length()];





			if(makePW(attempt, passwd, usedPassword,usedAttempt,0,0))
			{
				for(int j=0; j<N; ++j)
				{
					// ����� passwd����Ʈ�� ��ȸ�ϸ鼭 ����� �༮�� ���
					if(usedPassword[j])
					{
					System.out.print(passwd[j] + " ");
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