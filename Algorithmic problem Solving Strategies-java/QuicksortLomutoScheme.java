/*
���α׷� �� : QuicksortLomutoScheme
���� : Lomuto ����� partition�� ������ quicksort�̴�. Hoare�� quicksort�� ���� ���� ������ �� ���̴�.
	Lomuto�� ����� �ǵڸ� �Ǻ����� �ϰ�, �� �����Ͱ� '�տ���'���� ����Ѵ�. �� �����Ͱ� ū�༮�� ������ �����ϰ��ٰ� �����༮�� ������ �����.
	�� ��, �ٸ� �����Ͱ� �����Ŀ� ū �� �� ù��° ���� ����Ű�� �����༮�� swap�Ѵ�.
	�׷��� ������ swap�� �س�����, ���������� �ι�° �����Ϳ��� ��ĭ �� �̵��� �ڸ�(�Ǻ����� ū���� ����ִ�.)�� �Ǻ��� swap�Ѵ�.
��� : Wiki�� �ִ� pseudo �ڵ带 ���� �ۼ�. pseudo�ڵ��� �߿伺�� �˰Ե�.

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
