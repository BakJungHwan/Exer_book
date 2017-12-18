/*
프로그램 명 : SameOccurrence
설 명 : 길이가 n인 배열이 주어지고, x, y로 이뤄진 쿼리값이 입력된다. 배열의 서브배열(배열의 조각)중
	x와 y가 같은 수만큼 등장하는 서브배열의 개수를 찾는 문제

방 법 : 각 배열에 x와 y가 각각 얼마 있는지 살피고, 둘 중 적은 녀석을 기준으로 삼아서
		모든 서브배열을 순회하면서 x와 y의 개수가 일치할 때 수를 센다.

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