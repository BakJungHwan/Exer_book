/*
���α׷� �� : karatsuba ���� �˰���
�� �� : karatsuba �˰��� ���� �����ϴ� ���α׷�
		ū ���� ������ �ϱ� ���� ���α׷��̱� ������, 10������ �ڸ� �ű�
		���� stringó�� ���� ���ԵǾ� �ִ�.
 */


#include <iostream>
#include <vector>
#include <string>
#include <algorithm>


using namespace std;

// 10���� �ڸ����� �ø��� �Լ�
void normalize(vector<int>& a)
{

	// �������� ���Ϳ� ���� �ݺ��� ����
	std::vector<int>::iterator it = a.begin();

	// ���� �ڸ����� ���� ������ �ݺ��Ѵ�.
	// ����� i�� i�ڸ����� �ǹ��Ѵ�.
	for (it; it != a.end(); ++it)
	{
		// ���࿡ ���밪�� 10�� �Ѵ� ���
		if (abs(*it) > 9)
		{
			// it+1�� ������ �ڸ����� ���, vector�� overflow�� �����ϱ� ����
			// 0�� �߰��Ͽ� �ش� �ڸ��� ���ο� �ڸ����� Ȱ���Ѵ�.
			// overflow�� �� ���꿡�� �ذ��ϴ� ���� �� ���� �� ����.
			// �װ��� �� ������ �ŷڵ��� ���̸�, �ߺ��Ǵ� �ڵ带 �ٿ��ش�.
			/*
			if (it + 1 == a.end())
			{
				a.push_back(0);
			}
			*/
			// ������ ��� carry ó�� : ������ ���ο� �а�.
			if (*it < 0)
			{
				int borrow = (abs(*it) + 9) / 10;
				*(it + 1) -= borrow;
				*it += borrow * 10;
			}
			// ����� ��� carry ó��
			else
			{
				*(it + 1) += *it / 10;
				*it %= 10;
			}
		}
	}

	// ��ȿ���ں��� ���ڸ��� �ִ� 0�� �����Ѵ�.
	while (a.size() > 0 && a.back() == 0) a.pop_back();
}

// �Ϲ� ���� �˰���
vector<int> multiply(const vector<int>& a, const vector<int>& b)
{
	// �Ѿ�� �� �ִ� �ڸ����� a�� b�� �ڸ�����ŭ�̴�.
	// �ڵ� �� ���� Ǯ�� ���� �����ص�.
	vector<int> ret = vector<int>(a.size()+b.size(),0);

	for (int i = 0; i < a.size(); ++i)
	{
		for (int j = 0; j < b.size(); ++j)
		{
			ret[i + j] += a[i] * b[j];
		}
	}

	// �ڸ����� �ذ��Ѵ�. ���� 1�ڸ��� ret vector�� �Բ� �ϹǷ� overflow�� ������ �ʿ䰡 ����.
	normalize(ret);

	return ret;
}


// ū ���� ���ϴ� �Լ�, a+=b*10^k�� �����Ѵ�.
void addTo(vector<int>& a, vector<int>& b, int k)
{
	for (int i = 0; i < b.size(); ++i)
	{
		// a�� �ڸ����� �����ϸ� �ڸ����� �߰��Ѵ�.
		while (i + k >= a.size())
		{
			a.push_back(0);
		}
		a[i + k] += b[i];
	}
	normalize(a);
}

// ū���� ���� �Լ�
// �ڸ����� ������ �ʿ�� ����.
// a�� �׻� �� ū ���� ��ġ�ϹǷ� ������ ������ �ʿ䰡 ����.
void subFrom(vector<int>& a, vector<int>& b)
{
	for (int i = 0; i < b.size(); ++i)
	{
		a[i] -= b[i];
	}
	// �ڸ��� ����
	normalize(a);
}


// �������� ���� �˰���
vector<int> karatsuba(const vector<int>& a, const vector<int>& b)
{

	// a�� �ڸ����� �� ū ��쿡�� �����ϵ��� �Ѵ�.
	if (a.size() < b.size())
	{
		return karatsuba(b, a);
	}

	// �� �� �ϳ��� �� vector�� ��쿡�� �� ���͸� �����Ѵ�.
	// karatsuba�� ���� �˰����̹Ƿ�, �� �� �ϳ��� 0�� ������ ��, 0�� ��ȯ�ϴ� ���� �翬�� ���̴�.
	if (a.size() == 0 || b.size() == 0)
	{
		return vector<int>();
	}

	// ��� ���� ���������ϰ� �Ǹ�, ������ ���ؼ� multiply�Լ��� ȣ���Ѵ�.
	// ���ڸ� ���� �������� ������ �����ϸ�, karatsuba�˰������� �ذ��� �� ����.
	if (a.size() <= 10)
	{
		return multiply(a, b);
	}

	int half = a.size() / 2;
	int bn = b.size();

	// a�� 1�� ���, �ᱹ multiply�� ����ϰų�, �� �� �ϳ��� 0���� ���ȴ�.
	// ���� ������ ��ȹ���� �ͼ��������Ѵ�. �н��� �������� ���� �����ص� �� �� ����.
	// ū �������� ����, �� �Լ��� '�۵��Ѵ�'��� Ȯ���� ������ ���ȣ���� �����ϴµ� ������ �ȴ�.

	// ī���߹� �˰����� ���� ����
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