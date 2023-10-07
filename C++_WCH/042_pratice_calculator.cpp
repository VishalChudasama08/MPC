#include <iostream>
using namespace std;
class simplecalculator
{
protected:
    float a, b;

public:
    int set_number(float x, float y, char z)
    {
        a = x;
        b = y;
        if (z == '+')
        {
            return a + b;
        }
        else if (z == '-')
        {
            return a - b;
        }
        else if (z == '*')
        {
            return a * b;
        }
        else if (z == '/')
        {
            return a / b;
        }
        else
        {
            cout << "Error :- You not set perfect sing ";
        }
    }
};
int main()
{
    float x, y, answer;
    char z;
    cout << "Note :- on Number Enter time first Enter 1st any Number then sing(like +,-,* and / only) then 2nd any number then Enter key" << endl;
    cout << "Enetr Numbers :- ";
    cin >> x >> z >> y;
    simplecalculator calc;
    answer = calc.set_number(x, y, z);
    cout << "Your Answer is :- " << x << " " << z << " " << y << " = " << answer;
    return 0;
}