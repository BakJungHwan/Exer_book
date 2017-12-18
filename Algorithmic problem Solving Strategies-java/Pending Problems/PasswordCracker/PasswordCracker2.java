/*
프로그램 명 : PasswordCracker2
설명 : PasswordCracker의 3번째 버전. 첫번째 버전을 개량하여 속도를 개선시켰다. 
변명 : HackerRank의 PasswordCracker문제를 푼 것. 문제를 잘못봐서 다소 다른 답이 나왔다.

*/


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PasswordCracker2 {

	// PUT은 시도하는 문장에 매치시킬 패스워드 자리를 '사용했다'고 표시하기 위한 옵션키
	// PICK은 시도하는 문장에 매치시킨 패스워드의 위치를 '사용하지 않았다'고 다시 표시하기 위한 옵션키
    public static final int PUT = 1;
    public static final int PICK = 0;
    

	// 시도하는 문장에 해당하는 패스워드를 매치시키거나 매치취소시키는 함수.
    public static int usePW(String attempt, String[] passwd, int[] usedAttempt, int option, int passNum)
    {
		// 옵션에 따라 입력할 값을 check변수에 지정
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

		// passwd의 인덱스로부터 passwd에 해당하는 문자가 있는 시도문장의 위치까지 체크
		// 이 버전에서는 겹치는 모든 단어들의 위치에 표시하는 형식을 취했다.
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
    


	// 조건에 맞는 패스워드를 만드는 함수
	// 시도문장과 매치시킨 글자수를 세서 그 길이가 시도문장의 길이와 같으면 성공
	// 이 알고리즘에서는 순차적으로 passwd배열을 순회하며 체크해도 상관없으므로, 모든 passwd를 순회했을때를 기저사례에 추가하였다.
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

		// 순회
		for(int i=0; i<passwd.length; ++i)
		{
			// 현재 순회하는 패스워드를 이미 검사했다면 다음 녀석으로 이동
			if(usedPassword[i]) continue;
			
			// 매칭시킬 passwd의 위치를 체크함.
			// 함수는 매칭된 글자 갯수를 반환함.
			usedPassword[i] = true;
			int countPutPWToAttempt = usePW(attempt, passwd, usedAttempt, PUT, i);
			// 매칭된 글자수가 0이면 매칭되지 않았으므로 무시하고 다음패스워드 넘어감.
			// 매칭된 글자가 있다면, 해당하는 passwd를 사용했다고 표시하고, 다음 순회로 넘어감.
			if(countPutPWToAttempt > 0)
			{
				if(makePW(attempt, passwd, usedAttempt,
					countPutAttempt+countPutPWToAttempt, countCheckedPassword+1, usedPassword))
				{
						return true;
				}

				// 매칭시켰던 글자를 해제
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
				// password를 만드는데 실패하면, WRONG PASSWORD를 반환
				System.out.println("WRONG PASSWORD");
			}
        }
        
        scan.close();
    }
}