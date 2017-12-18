/*
���α׷� �� : Equialize the Array(HackerRank)
���� : �Է¹޴� ���� �迭���� �ּ����� ���ڸ� �����Ͽ� �ϳ��� ���ڷθ� �̷��� �迭�� �����.
��� : ���ڸ� �Է¹��� ������ŭ�� �迭�� �̸� ����� �д�. �Է¹޴� ���ڸ��� ī��Ʈ�Ѵ�.
		�Է¹��� ������ �ִ밪�� ������ �д�.
		���� ���� �Է¹��� ���ڸ� ã�´�.
		�Է¹��� ������ �ִ밪��ŭ �ݺ����� �����Ͽ�, ���� ���� �Է¹��� ���� ���ڵ��� ������ ����.
	

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class A3 {

    public static int[] count = new int[101];
    
    public static void main(String[] args) {
                
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int num;
		int num_max = Integer.MIN_VALUE;

        for(int i=1; i<=n; ++i)
        {
			num = scan.nextInt();
            count[num] += 1;
			if(num_max < num)
			{
				num_max = num;
			}
        }
        
        int max=Integer.MIN_VALUE;
        int sum=0;
        int j=0;
        
        for(int i=1; i<=num_max; ++i)
        {
            if(max < count[i])
            {
                max = count[i];

                j = i;
            }
        }
        

		for(int i=1; i<=num_max; ++i)
        {
            if(i!=j)
            {
                sum+=count[i];
            }
        }
        
        System.out.println(sum);
        
    }
}