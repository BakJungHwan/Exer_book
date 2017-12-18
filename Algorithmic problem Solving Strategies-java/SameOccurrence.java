/*
���α׷� �� : SameOccurrence
�� �� : ���̰� n�� �迭�� �־�����, x, y�� �̷��� �������� �Էµȴ�. �迭�� ����迭(�迭�� ����)��
	x�� y�� ���� ����ŭ �����ϴ� ����迭�� ������ ã�� ����

�� �� : �� �迭�� x�� y�� ���� �� �ִ��� ���ǰ�, �� �� ���� �༮�� �������� ��Ƽ�
		��� ����迭�� ��ȸ�ϸ鼭 x�� y�� ������ ��ġ�� �� ���� ����.

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SameOccurrence {

	public static int countSubarrays(int[] arr, int maxCount, int x, int y)
	{
		int countX;
		int countY;
		int ret=0;

		for(int begin=0; begin<arr.length; ++begin)
		{
			countX = 0;
			countY = 0;

			if(arr[begin] == x)
			{
				++countX;
			}
			else if(arr[begin] == y)
			{
				++countY;
			}
			for(int end=begin+1; end<arr.length; ++end)
			{
				if(arr[end] == x)
				{
					++countX;
				}
				else if(arr[end] == y)
				{
					++countY;
				}

				if(countX > maxCount || countY > maxCount)
				{
					break;
				}
				
				if(countX == countY)
				{
					System.out.println("begin : " + begin + "     end : " + end);
					++ret;
				}
			}
		}

		return ret;

	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        for(int a0 = 0; a0 < q; a0++){
            int x = in.nextInt();
            int y = in.nextInt();
         
			int countX=0;
			int countY=0;
			int maxCount;
			int ret;

			for(int i=0; i<n; ++i)
			{
				if(arr[i] == x)
				{
					++countX;
				}
				else if(arr[i] == y)
				{
					++countY;
				}
			}

			if(countX < countY)
			{
				maxCount = countY;
			}
			else
			{
				maxCount = countX;
			}

			if(maxCount!=0)
			{
				ret = countSubarrays(arr, maxCount, x, y);
			}
			else
			{
				ret = n*(n+1)/2;
			}

			System.out.println(ret);

		}
        in.close();
	}
}