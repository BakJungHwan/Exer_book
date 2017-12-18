#include <iostream>
using namespace std;

class FruitSeller
{
	private:
		int APPLE_PRICE;
		int numOfApples;
		int myMoney;
		
	public:
		void InitMembers(int price, int num, int money)
		{
			APPLE_PRICE = price;
			numOfApples = num;
			myMoney = money;
		}
		
		int SaleApples(int money)
		{
			int num=money/APPLE_PRICE;
			numOfApples-=num;
			myMoney+=money;
			return num;
		}
		
		void ShowSalesResult()
		{
			cout << "Current Apple : " << numOfApples << endl;
			cout << "Revenue : " << myMoney << endl << endl;
		}
};


class FruitBuyer
{
	int myMoney;
	int numOfApples;
	
	public:
		void InitMembers(int money)
		{
			
		myMoney=money;
		numOfApples=0;
		}
		
		void BuyApples(FruitSeller &seller, int money)
		{
			numOfApples+=seller.SaleApples(money);
			myMoney-=money;
		}
		
		void ShowBuyResult()
		{
			cout << "Current money : " << myMoney << endl;
			cout << "Num of Apples : " << numOfApples << endl << endl;
		}
};

int main(void)
{
	FruitSeller seller;
	seller.InitMembers(1000,20,0);
	FruitBuyer buyer;
	buyer.InitMembers(5000);
	buyer.BuyApples(seller,2000);
	
	cout << " Current FruitSeller" << endl;
	seller.ShowSalesResult();
	
	cout << " Current FruitBuyer" << endl;
	buyer.ShowBuyResult();
	return 0;
	
}
