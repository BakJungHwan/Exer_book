#include <stdio.h>
#include <string.h>
#define STR_LEN 50
#define BOOK_INFO_NUM 3

typedef struct __bookinfo
{
	char bookTitle[STR_LEN];
	char bookPub[STR_LEN];
	int bookPrice;
	
}bookinfo;

void printArr(bookinfo** arr)
{
	printf("\n\n");
	for(int i=0; i<BOOK_INFO_NUM; ++i)
	{
		printf("Title[%d] : %s\n", i, arr[i]->bookTitle);
		printf("Publisher[%d] : %s\n", i, arr[i]->bookPub);
		printf("Price[%d] : %d\n", i, arr[i]->bookPrice);
	}
	printf("\n");
}

void sortTitle(bookinfo** arr)
{
	bookinfo* temp;
	for(int i=0; i<BOOK_INFO_NUM-1; ++i)
	{
		for(int j=0; j<BOOK_INFO_NUM-i-1; ++j)
		{
			if(strcmp(arr[j]->bookTitle,arr[j+1]->bookTitle) > 0)
			{
				temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
			}
		}
	}
}

void sortPub(bookinfo** arr)
{
	bookinfo* temp;
	for(int i=0; i<BOOK_INFO_NUM-1; ++i)
	{
		for(int j=0; j<BOOK_INFO_NUM-i-1; ++j)
		{
			if(strcmp(arr[j]->bookPub,arr[j+1]->bookPub) > 0)
			{
				temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
			}
		}
	}
}

void sortPrice(bookinfo** arr)
{
	bookinfo* temp;
	for(int i=0; i<BOOK_INFO_NUM-1; ++i)
	{
		for(int j=0; j<BOOK_INFO_NUM-i-1; ++j)
		{
			if(arr[j]->bookPrice > arr[j+1]->bookPrice)
			{
				temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
			}
		}
	}
}



int main(void)
{
	bookinfo infoArr[BOOK_INFO_NUM];
	bookinfo* sortedArr[BOOK_INFO_NUM];
	
	char temp[STR_LEN];
	int inputP;
	int chooseSort;
		
	for(int i=0; i<BOOK_INFO_NUM;++i)
	{
		inputP=i;
		fputs("Title? : ", stdout);
		gets(temp);
		for(int j=0; j<i; j++)
		{
			if(strcmp(infoArr[j].bookTitle,temp) > 0)
			{
				for(int k=i-1; k>=j; --k)
				{
					infoArr[k+1] = infoArr[k];
				}
				inputP = j;
				break;
			}
		}
		
		strcpy(infoArr[inputP].bookTitle,temp);
						
		fputs("Publisher? : ", stdout);
		gets(infoArr[inputP].bookPub);
		
		printf("!! %s\n", infoArr[inputP].bookTitle);
		
		fputs("Price? : ", stdout);
		scanf("%d", &infoArr[inputP].bookPrice);
		while(getchar()!='\n');
		
		sortedArr[inputP] = &infoArr[inputP];
	}
	
	
	printArr(sortedArr);
	
	
	while(1)	
	{
		fputs("1, Titles  2, Publisher  3, Price  4, Quit : ", stdout);
		scanf("%d", &chooseSort);
		
		switch(chooseSort)
		{
			case 1 :
				sortTitle(sortedArr);
				printArr(sortedArr);
				continue;
			case 2 :
				sortPub(sortedArr);
				printArr(sortedArr);
				continue;
			case 3 :
				sortPrice(sortedArr);
				printArr(sortedArr);
				continue;
			case 4 :
				return 0;
			default :
				continue;
		}
	}
	
	
	
	
	return 0;
}
