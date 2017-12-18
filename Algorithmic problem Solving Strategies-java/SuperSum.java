import java.io.*;
import java.util.*;
/*
���α׷� �� : SuperSum
���� : 10�� 1000000���� ���ڸ� �޾Ƽ� �� �ڸ����� ���� ���Ѵ�. �� ���� 1�ڸ����� �ƴϸ�
		�ݺ��ؼ� 1�ڸ����� ����� SuperSum�̶�� ������ �����

		�ֿ� ��
			!! �� �����غ��� 1�� �ڸ� �̿ܿ� �ö󰡴� ��� �ڸ����� 1���ڸ��� ���ϴ� �Ͱ� ����.
			!! �׷��� 10�� �Ѿ ������ 10���� ���� �������� Carry�� �����ִ� �����̴�.
			!! ���࿡ 3�ڸ� ����� ���� �ڸ��� ������ �����ڸ��� �����ڸ��� Carry�� ������ ���� ���ٰ� �� �� �ִ�.
			!! Carry���� �����̶�� ������ ���� �߿��ϴ�.
			!! �׷��Ƿ�, �����ڸ� ���� �� �� �ڸ����� 1���ڸ����� �ν��ϰ� ���� �� �� ���� �ٽ� �ڸ����� �����ؼ� ���ϴ� ���̳�
			!! 1�ڸ����� ���ϴٰ� �ڸ����� �Ѿ ������ 1���ڸ��� 1�� �����ִ� ���̳� ���� ����� ������ ���̴�.

��� : ���ڸ��� ���� String��ü�� �ް�, char�迭�� ���� �� �� �ڸ� ���ڸ� �ϳ��� �ҷ��� ����ߴ�.
	�ڸ����� ������ ���� ���ؼ� ���� 10���� ���ų� Ŀ�� ������ �Ѿ�� Carry�� 10���� ���� �������� ���ߴ�.
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