#include <stdio.h>
#include <stdlib.h>
#include <math.h>


int compare(const void* a, const void* b)
{
	return (*(int*)b) - (*(int *)a);
}


int main(){
	
	int input;
	int min=1234567;
	int max=-1234567;
	int sum=0;
		
	for(int i=0; i<7; ++i)
	{
		printf("Input integer : ");
		scanf("%d", &input);
		
		sum += input;
		
		if(input < min)
		{
			min = input;
		}
		else if(input > max)
		{
			max = input;
		}
		
		
	}

	printf("Max : %d\n", max);
	printf("Min : %d\n", min);
	printf("Sum : %d\n", sum);
	printf("Avg : %lf\n", sum/7.0);
	
}
