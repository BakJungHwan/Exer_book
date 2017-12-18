#include <stdio.h>

int sum2Dimension1(int arr[][2], int arr_len)
{
	int sum=0;
	
	for(int i=0; i<arr_len; ++i)
	{
		for(int j=0; j<2; ++j)
		{
			sum += arr[i][j];
		}
	}
	
	return sum;
}

int sum2Dimension2(int arr[][3], int arr_len)
{
	int sum=0;
	
	for(int i=0; i<arr_len; ++i)
	{
		for(int j=0; j<3; ++j)
		{
			sum += arr[i][j];
		}
	}
	
	return sum;
}

int main()
{
	int arr3[2][2]={{1, 3}, {5, 7}};
	int arr4[2][3]={{1,2,3},{4,5,6}};
	
	printf("%d\n", sizeof(arr3)/sizeof(arr3[0]));
	
	printf("%d ", sum2Dimension1(arr3, sizeof(arr3)/sizeof(arr3[0])));
	printf("%d", sum2Dimension2(arr4, sizeof(arr4)/sizeof(arr4[0])));
	
	return 0;
}
