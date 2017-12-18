/*
프로그램 명 : PasswordCracker1
설 명 : PasswordCracker의 업그레이드 버전으로, 문제에서 요구한 출력을 내기 위한 개선


문제점 : 시간초과가 크게 발생, 특히 a aa aaa aaaa aaaaa 같은 입력값같은 경우. 시간이 너무 오래 걸린다.
		패스워드끼리 서로 겹치는 경우일 때를 집합으로 만들어서 접근해야하는지. 쉽지않다.
		겹치는 경우, 가장 긴 패스워드부터 인덱스를 잡아보는게 효율적일 것 같기는 하다.
		걸어놓고 차차 푸는 걸로.

링 크 : https://www.hackerrank.com/challenges/password-cracker?h_r=internal-search
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