/*
프로그램 명 : PasswordCracker
설명 : 주어진 문장이 주어진 여러 단문의 조합으로 나타낼 수 있는지 없는지 확인하는 문제.
변명 : HackerRank의 PasswordCracker문제를 푼 것. 문제를 잘못봐서 다소 다른 답이 나왔다.

*/


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PasswordCracker {

	// PUT은 시도하는 문장에 매치시킬 패스워드 자리를 '사용했다'고 표시하기 위한 옵션키
	// PICK은 시도하는 문장에 매치시킨 패스워드의 위치를 '사용하지 않았다'고 다시 표시하기 위한 옵션키
    public static final int PUT = 1;
    public static final int PICK = 0;
    

	// 시도하는 문장에 해당하는 패스워드를 매치시키거나 매치취소시키는 함수.
    public static int usePW(String attempt, String passwd, boolean[] usedAttempt, int option)
    {
		// 옵션에 따라 입력할 값을 check변수에 지정
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

		// passwd의 인덱스로부터 passwd에 해당하는 문자가 있는 시도문장의 위치까지 체크
		// 이 버전에서는 겹치는 모든 단어들의 위치에 표시하는 형식을 취했다.
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
    


	// 조건에 맞는 패스워드를 만드는 함수
	// 시도문장과 매치시킨 글자수를 세서 그 길이가 시도문장의 길이와 같으면 성공
	// 이 알고리즘에서는 순차적으로 passwd배열을 순회하며 체크해도 상관없으므로, 모든 passwd를 순회했을때를 기저사례에 추가하였다.
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

		// 순회
		for(int i=0; i<passwd.length; ++i)
		{
			// 현재 순회하는 패스워드를 이미 검사했다면 다음 녀석으로 이동
			if(usedPassword[i]) continue;
			
			// 매칭시킬 passwd의 위치를 체크함.
			// 함수는 매칭된 글자 갯수를 반환함.
			int countPutPWToAttempt = usePW(attempt, passwd[i], usedAttempt, PUT);
			
			// 매칭된 글자수가 0이면 매칭되지 않았으므로 무시하고 다음패스워드 넘어감.
			// 매칭된 글자가 있다면, 해당하는 passwd를 사용했다고 표시하고, 다음 순회로 넘어감.
			if(countPutPWToAttempt > 0)
			{
				usedPassword[i] = true;
				if(makePW(attempt, passwd, usedPassword,
					usedAttempt, countPutAttempt+countPutPWToAttempt, countCheckedPassword+1))
				{
					return true;
				}

				// 매칭시켰던 글자를 해제
				usePW(attempt, passwd[i], usedAttempt, PICK);

				// passwd를 사용했다는 표시도 해제
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
					// 사용한 passwd리스트를 순회하면서 사용한 녀석만 출력
					if(usedPassword[j])
					{
					System.out.print(passwd[j] + " ");
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