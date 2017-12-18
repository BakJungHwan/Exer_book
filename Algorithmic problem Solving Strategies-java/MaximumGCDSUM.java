/*
프로그램명 : MaximumGCDSUM
설 명 : n개의 원소를 가진 A라는 집합과 B라는 집합이 있다. x를 A의 원소, y를 B의 원소라고 할 때,
	짝지을 수 있는 모든 (x,y)의 쌍에 대해서, 가장 큰 최대공약수를 갖는 쌍을 찾고,
	해당하는 쌍의 x+y의 값 중 가장 큰 값을 출력하는 프로그램
방 법 : 모든 (x,y)의 경우의 수에 대해서 gcd를 구하고 해당하는 값을 HashMap에 저장해둔 후,
	저장된 값을 필요로 하면 반환하고, 그렇지 않으면, gcd를 구하기 위한 연산을 한다.

결 과 : 실행속도가 느려서 실패했다.

다른 아이디어 : 처음에는 2차원배열로 메모이제이션 시도해보았으나 너무 커서 실패했다. 해쉬로 해결하려 했지만 역부족 이었다.

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaximumGCDSUM {


	static HashMap<String,Integer> gcdMap = new HashMap();



	static int gcd(int a, int b)
	{
		if(b > a)
		{
			return gcd(b, a);
		}

		String str = a + ":" + b;
		
		System.out.println(str);

		if(gcdMap.containsKey(str))
		{
			return gcdMap.get(str);
		}

		if(b == 0)
		{
			return a;
		}

		gcdMap.put(str,gcd(b, a%b));

		return gcd(b, a%b);
	}

    static int maximumGcdAndSum(int[] A, int[] B) {
		int ret;
		int maxGCD=0;
		int maxSUM = 0;
		
		for(int i=0; i<A.length; ++i)
		{
			for(int j=i; j<B.length; ++j)
			{
				if(maxGCD <= gcd(A[i], B[j]))
				{
					maxGCD = gcd(A[i], B[j]);
					if(maxSUM < A[i] + B[j])
					{
						maxSUM = A[i] + B[j];
					}
				}
			}
		}

		return maxSUM;
    }

    public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        int[] B = new int[n];
        for(int B_i = 0; B_i < n; B_i++){
            B[B_i] = in.nextInt();
        }

        int res = maximumGcdAndSum(A, B);
        System.out.println(res);
    }
}