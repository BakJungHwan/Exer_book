import java.io.*;
import java.util.*;
/*
프로그램 명 : SuperSum
설명 : 10의 1000000승인 숫자를 받아서 각 자리수의 합을 더한다. 그 수가 1자리수가 아니면
		반복해서 1자리수로 만드는 SuperSum이라는 연산을 만든다

		주요 논리
			!! 잘 생각해보면 1의 자리 이외에 올라가는 모든 자리수를 1의자리에 더하는 것과 같다.
			!! 그래서 10이 넘어갈 때마다 10으로 나눈 나머지에 Carry를 더해주는 형태이다.
			!! 만약에 3자리 수라면 일의 자리를 제외한 십의자리와 백의자리는 Carry가 누적된 값과 같다고 볼 수 있다.
			!! Carry값의 누적이라는 개념이 가장 중요하다.
			!! 그러므로, 여러자리 수일 때 각 자리수를 1의자리수로 인식하고 더한 후 그 수를 다시 자리수로 분해해서 더하는 것이나
			!! 1자리수를 더하다가 자리수가 넘어갈 때마다 1의자리에 1을 더해주는 것이나 같은 결과가 나오는 것이다.

방법 : 긴자리의 수를 String객체로 받고, char배열로 만든 후 각 자리 숫자를 하나씩 불러서 계산했다.
	자리수의 여유를 갖기 위해서 합이 10보다 같거나 커질 때마다 넘어가는 Carry를 10으로 나눈 나머지와 더했다.
*/

import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SuperSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String S = scan.next();
        int k = scan.nextInt();

		System.out.println(k);

        char[] C = S.toCharArray();
        
        int sum = 0;
        
        for(char c : C)
        {
            sum+=c-0x30;
            if(sum>=10)
            {
                sum = sum%10 + 1;
            }
        }
        
        System.out.println("Sum : " + sum);
        
        int temp = sum*k;
        sum = 0;
        
		System.out.println("temp : " + temp);

        do
        {
            sum += temp%10;
            temp /=10;

        System.out.println("Sum : " + sum);
		System.out.println("temp : " + temp);
        }while(temp != 0);
            
        
        System.out.println(sum);
        
    }
}