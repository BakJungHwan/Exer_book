/*
프로그램 명 : QuicksortLomutoScheme
설명 : Lomuto 방식의 partition을 가미한 quicksort이다. Hoare의 quicksort가 내가 많이 구현해 본 것이다.
	Lomuto의 방식은 맨뒤를 피봇으로 하고, 두 포인터가 '앞에서'부터 출발한다. 한 포인터가 큰녀석이 있으면 무시하고가다가 작은녀석이 나오면 멈춘다.
	그 때, 다른 포인터가 지나쳐온 큰 수 중 첫번째 수를 가리키고 작은녀석과 swap한다.
	그렇게 끝까지 swap을 해나가고, 최종적으로 두번째 포인터에서 한칸 더 이동한 자리(피봇보다 큰수가 들어있다.)로 피봇을 swap한다.
방법 : Wiki에 있는 pseudo 코드를 보고 작성. pseudo코드의 중요성을 알게됨.

*/


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class QuicksortLomutoScheme
{
    public static void quicksort(int[] array, int lo, int hi)
    {
        if(lo < hi)
        {
            int p = partition(array, lo, hi);
            quicksort(array, lo, p-1);
            quicksort(array, p+1, hi);
        }
    }
    
    public static int partition(int[] array, int lo, int hi)
    {
        int pivot = array[hi];
        int i = lo-1;
        
        for(int j=lo;j<=(hi-1);++j)
        {
            if(array[j] <= pivot)
            {
                ++i;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i+1];
        array[i+1] = array[hi];
        return i+1;
    }
    
    public static void printArray(int[] array)
    {
        for(int a : array)
        {
            System.out.print(a + " ");
        }
        System.out.println();
    }
    
    
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();

        int[] array = new int[n];
        
        for(int i=0; i<n; ++i)
        {
            array[i] = scan.nextInt();
        }
        
		quicksort(array,0,array.length-1);
	}
}
