/*
���α׷� �� : PasswordCracker1
�� �� : PasswordCracker�� ���׷��̵� ��������, �������� �䱸�� ����� ���� ���� ����


������ : �ð��ʰ��� ũ�� �߻�, Ư�� a aa aaa aaaa aaaaa ���� �Է°����� ���. �ð��� �ʹ� ���� �ɸ���.
		�н����峢�� ���� ��ġ�� ����� ���� �������� ���� �����ؾ��ϴ���. �����ʴ�.
		��ġ�� ���, ���� �� �н�������� �ε����� ��ƺ��°� ȿ������ �� ����� �ϴ�.
		�ɾ���� ���� Ǫ�� �ɷ�.

�� ũ : https://www.hackerrank.com/challenges/password-cracker?h_r=internal-search
*/


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PasswordCracker1 {

    public static final int PUT = 1;
    public static final int PICK = 0;
    
    public static void usePW(String attempt, String passwd, boolean[] usedAttempt, int option, int currentIndex)
    {
		boolean check;
		
		if(option == PUT)
		{
			check = true;
		}
		else
		{
			check =false;
		}
		for(int i=0; i<passwd.length(); ++i)
			{
				usedAttempt[currentIndex+i] = check;
			}
    }
    
    public static boolean makePW(String attempt, String[] passwd, boolean[] usedAttempt, int[] passwordSet, int usedPasswordIndex)
    {
		int currentIndex=0;

		while(currentIndex < attempt.length() && usedAttempt[currentIndex]!=false) ++currentIndex;

		if(currentIndex == attempt.length())
		{
			return true;
		}
		
		for(int i=0; i<passwd.length; ++i)
		{
			if(attempt.indexOf(passwd[i],currentIndex) == currentIndex)
			{
				usePW(attempt, passwd[i], usedAttempt, PUT, currentIndex);
				passwordSet[usedPasswordIndex] = i;
				if(makePW(attempt, passwd, usedAttempt, passwordSet, usedPasswordIndex+1))
				{
					return true;
				}
				usePW(attempt, passwd[i], usedAttempt, PICK, currentIndex);
			}
		}

		return false;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
		int N;
		int[] passwordSet;

		
        for(int i=0; i<T; ++i)
        {
            N = scan.nextInt();
            String[] passwd = new String[N];
			passwordSet = new int[1000];
			Arrays.fill(passwordSet,-1);
        
            for(int j=0; j<N; ++j)
            {
                passwd[j] = scan.next();
            }

			String attempt = scan.next();            
			boolean[] usedAttempt = new boolean[attempt.length()];

			if(makePW(attempt, passwd, usedAttempt,passwordSet,0))
			{
				int j=0;
				while(passwordSet[j]!=-1)
				{
					System.out.print(passwd[passwordSet[j]] + " ");
					++j;
				}
				System.out.println();
			}
			else
			{
				System.out.println("WRONG PASSWORD");
			}
        }
        
        scan.close();
    }
}