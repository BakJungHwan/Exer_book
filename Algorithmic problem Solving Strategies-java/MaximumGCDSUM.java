/*
���α׷��� : MaximumGCDSUM
�� �� : n���� ���Ҹ� ���� A��� ���հ� B��� ������ �ִ�. x�� A�� ����, y�� B�� ���Ҷ�� �� ��,
	¦���� �� �ִ� ��� (x,y)�� �ֿ� ���ؼ�, ���� ū �ִ������� ���� ���� ã��,
	�ش��ϴ� ���� x+y�� �� �� ���� ū ���� ����ϴ� ���α׷�
�� �� : ��� (x,y)�� ����� ���� ���ؼ� gcd�� ���ϰ� �ش��ϴ� ���� HashMap�� �����ص� ��,
	����� ���� �ʿ�� �ϸ� ��ȯ�ϰ�, �׷��� ������, gcd�� ���ϱ� ���� ������ �Ѵ�.

�� �� : ����ӵ��� ������ �����ߴ�.

�ٸ� ���̵�� : ó������ 2�����迭�� �޸������̼� �õ��غ������� �ʹ� Ŀ�� �����ߴ�. �ؽ��� �ذ��Ϸ� ������ ������ �̾���.

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