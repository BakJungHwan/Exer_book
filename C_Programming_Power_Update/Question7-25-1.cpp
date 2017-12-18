#include <stdio.h>
#include <stdlib.h>

void SortArr(int *arr, int num);
void ReadAndSortPrint(int number);

int main(void)
{
	int num;
	fputs("The number of integers to input : " , stdout);
	scanf("%d", &num);
	
	ReadAndSortPrint(num);
	return 0;
}

void SortArr(int* arr, int num)
{
	int i, j, temp;
	
	for(i=0; i<num-1; i++)
	{
		for(j=0; j<num-i-1; j++)
		{
			if(arr[j]>arr[j+1])
			{
				temp=arr[j];
				arr[j] = arr[j+1];
				arr[j+1]=temp;
			}
		}
	}
}

void ReadAndSortPrint(int number)
{
	int* arr = (int*)malloc(sizeof(int)*number);
		
	int i;
	
	for(i=0; i<number; i++)
	{
		printf("%d th input : ", i+1);
		scanf("%d", &arr[i]);
	}
	
	SortArr(arr, number);
	
	puts("Printing Sorted arr");
	for(i=0; i<number; ++i)
	{
		printf("%d ", arr[i]);
	}
	free(arr);
	printf("\n");
}
