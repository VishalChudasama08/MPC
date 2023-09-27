#include <iostream>
using namespace std;
class BankDeposit
{
    int principal, years;
    float interestRate, returnValue;

public:
    BankDeposit() {}
    BankDeposit(int p, int y, float r); // r value like 0.04
    BankDeposit(int p, int y, int r);   // r value like 18
    void show();
};

BankDeposit::BankDeposit(int p, int y, float r)
{
    principal = p;
    years = y;
    interestRate = r;
    returnValue = principal;
    for (int i = 0; i < y; i++)
    {
        returnValue *= (1 + interestRate);
    }
}

BankDeposit::BankDeposit(int p, int y, int r)
{
    principal = p;
    years = y;
    interestRate = float(r) / 100;
    returnValue = principal;
    for (int i = 0; i < y; i++)
    {
        returnValue *= (1 + interestRate);
    }
}
void BankDeposit::show()
{
    cout << endl
         << "Principal amount was " << principal << ". Return value after " << years << " is " << returnValue << endl;
}

int main()
{
    BankDeposit v1, v2, v3;
    int p, y, R;
    float r;

    cout << "Enter the value of p, y and r" << endl;
    cin >> p >> y >> r;
    v1 = BankDeposit(p, y, r);
    v1.show();

    cout << "Enter the value of p, y and R" << endl;
    cin >> p >> y >> r;
    v2 = BankDeposit(p, y, R);
    v2.show();
    return 0;
}