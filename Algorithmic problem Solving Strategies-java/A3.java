/*
프로그램 명 : Equialize the Array(HackerRank)
설명 : 입력받는 숫자 배열에서 최소한의 숫자를 제거하여 하나의 숫자로만 이뤄진 배열을 만든다.
방법 : 숫자를 입력받을 범위만큼의 배열을 미리 만들어 둔다. 입력받는 숫자마다 카운트한다.
		입력받은 숫자의 최대값을 저장해 둔다.
		가장 많이 입력받은 숫자를 찾는다.
		입력받은 숫자의 최대값만큼 반복문을 수행하여, 가장 많이 입력받지 않은 숫자들의 개수를 센다.
	

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