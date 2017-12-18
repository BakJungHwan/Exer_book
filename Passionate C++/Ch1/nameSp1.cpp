#include <iostream>

namespace BestComImpl
{
	void SimpleFunc(void)
	{
		std::cout<<"BestCom이 정의한 함수" << std::endl;
	}
}

namespace ProgComImpl
{
	void SimpleFunc(void)
	{
		std::cout<<"The function is defined by ProgCom" << std::endl;
	}

}


int main(void)
{
	BestComImpl::SimpleFunc();
	ProgComImpl::SimpleFunc();
	return 0;
}
