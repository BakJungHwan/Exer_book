/*
프로그램 명 : karatsuba 곱셈 알고리즘
설 명 : karatsuba 알고리즘에 따라 곱셈하는 프로그램
		큰 수의 곱셈을 하기 위한 프로그램이기 때문에, 10진수의 자리 옮김
		수의 string처리 등이 포함되어 있다.
 */


#include <iostream>
#include <vector>
#include <string>
#include <algorithm>


using namespace std;

// 10진수 자리수를 올리는 함수
void normalize(vector<int>& a)
{

	// 전달인자 벡터에 대한 반복자 선언
	std::vector<int>::iterator it = a.begin();

	// 끝의 자리수에 닿을 때까지 반복한다.
	// 참고로 i는 i자리수를 의미한다.
	for (it; it != a.end(); ++it)
	{
		// 만약에 절대값이 10이 넘는 경우
		if (abs(*it) > 9)
		{
			// it+1이 마지막 자리수인 경우, vector의 overflow를 방지하기 위해
			// 0을 추가하여 해당 자리를 새로운 자리수로 활용한다.
			// overflow는 각 연산에서 해결하는 것이 더 좋을 것 같다.
			// 그것이 각 연산의 신뢰도를 높이며, 중복되는 코드를 줄여준다.
			/*
			if (it + 1 == a.end())
			{
				a.push_back(0);
			}
			*/
			// 음수인 경우 carry 처리 : 뺄셈을 염두에 둔것.
			if (*it < 0)
			{
				int borrow = (abs(*it) + 9) / 10;
				*(it + 1) -= borrow;
				*it += borrow * 10;
			}
			// 양수인 경우 carry 처리
			else
			{
				*(it + 1) += *it / 10;
				*it %= 10;
			}
		}
	}

	// 유효숫자보다 윗자리에 있는 0을 제거한다.
	while (a.size() > 0 && a.back() == 0) a.pop_back();
}

// 일반 곱셈 알고리즘
vector<int> multiply(const vector<int>& a, const vector<int>& b)
{
	// 넘어올 수 있는 자리수는 a와 b의 자리수만큼이다.
	// 코딩 및 문제 풀이 팁에 증명해둠.
	vector<int> ret = vector<int>(a.size()+b.size(),0);

	for (int i = 0; i < a.size(); ++i)
	{
		for (int j = 0; j < b.size(); ++j)
		{
			ret[i + j] += a[i] * b[j];
		}
	}

	// 자리수를 해결한다. 여분 1자리가 ret vector에 함께 하므로 overflow를 걱정할 필요가 없다.
	normalize(ret);

	return ret;
}


// 큰 수를 더하는 함수, a+=b*10^k를 구현한다.
void addTo(vector<int>& a, vector<int>& b, int k)
{
	for (int i = 0; i < b.size(); ++i)
	{
		// a의 자리수가 부족하면 자리수를 추가한다.
		while (i + k >= a.size())
		{
			a.push_back(0);
		}
		a[i + k] += b[i];
	}
	normalize(a);
}

// 큰수를 빼는 함수
// 자리수를 걱정할 필요는 없다.
// a에 항상 더 큰 수를 배치하므로 음수도 걱정할 필요가 없다.
void subFrom(vector<int>& a, vector<int>& b)
{
	for (int i = 0; i < b.size(); ++i)
	{
		a[i] -= b[i];
	}
	// 자리수 정리
	normalize(a);
}


// 본격적인 곱셈 알고리즘
vector<int> karatsuba(const vector<int>& a, const vector<int>& b)
{

	// a가 자리수가 더 큰 경우에만 연산하도록 한다.
	if (a.size() < b.size())
	{
		return karatsuba(b, a);
	}

	// 둘 중 하나가 빈 vector인 경우에는 빈 벡터를 리턴한다.
	// karatsuba는 곱셈 알고리즘이므로, 둘 중 하나가 0이 들어왔을 때, 0을 반환하는 것이 당연한 것이다.
	if (a.size() == 0 || b.size() == 0)
	{
		return vector<int>();
	}

	// 어느 정도 사이즈이하가 되면, 연산을 위해서 multiply함수를 호출한다.
	// 한자리 수의 곱셈까지 문제를 분할하면, karatsuba알고리즘으로 해결할 수 없다.
	if (a.size() <= 10)
	{
		return multiply(a, b);
	}

	int half = a.size() / 2;
	int bn = b.size();

	// a가 1일 경우, 결국 multiply로 계산하거나, 둘 중 하나가 0으로 계산된다.
	// 분할 정복의 계획법에 익숙해져야한다. 학습중 디테일은 조금 무시해도 될 것 같다.
	// 큰 시점으로 보고, 이 함수가 '작동한다'라는 확신을 가지면 재귀호출을 설계하는데 도움이 된다.

	// 카라추바 알고리즘의 개념 구현
	vector<int> a0 = vector<int>(a.begin(), a.begin() + half);
	vector<int> a1 = vector<int>(a.begin() + half, a.end());
	vector<int> b0 = vector<int>(b.begin(), b.begin() + min(bn,half));
	vector<int> b1 = vector<int>(b.begin() + min(bn, half), b.end());

	vector<int> z0 = karatsuba(a0, b0);
	vector<int> z2 = karatsuba(a1, b1);

	addTo(a0, a1, 0);
	addTo(b0, b1, 0);

	vector<int> z1 = karatsuba(a0, b0);

	subFrom(z1, z0);
	subFrom(z1, z2);

	addTo(z0, z1, half);
	addTo(z0, z2, half * 2);

	return z0;
}




int main(int argc, char* argv[])
{
	string input1;
	string input2;

	vector<int> a;
	vector<int> b;

	cin >> input1 >> input2;

	for (std::string::reverse_iterator it = input1.rbegin(); it != input1.rend(); ++it)
	{
		a.push_back(*it - 0x30);
	}

	for (std::string::reverse_iterator it = input2.rbegin(); it != input2.rend(); ++it)
	{
		b.push_back(*it - 0x30);
	}

	vector<int> ret = multiply(a, b);

	for (std::vector<int>::reverse_iterator it = ret.rbegin(); it < ret.rend(); ++it)
	{
		cout << *it;
	}
	cout << endl;

	return 0;
}