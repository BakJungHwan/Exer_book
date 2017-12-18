#include <stdio.h>

void sum1Dimension(int arr1[], int arr1_len, int arr2[], int arr2_len, int result[])
{
	result[0] = 0;
	result[1] = 0;
	
	
	
	for(int i=0; i<arr1_len; ++i)
	{
		result[0] += arr1[i];

	}
	
	for(int i=0; i<arr2_len; ++i)
	{
		result[1] += arr2[i];
	}
}

int main()
{
	int arr1[3] = {5, 10, 15};
	int arr2[5] = {1,2,3,4,5};
	int result[2];
	
	int arr1_len = sizeof(arr1)/sizeof(arr1[0]);
	int arr2_len = sizeof(arr2)/sizeof(arr2[0]);
	
	sum1Dimension(arr1, arr1_len, arr2, arr2_len, result);
	
	printf("%d %d", result[0], result[1]);
	
	
	return 0;
}
