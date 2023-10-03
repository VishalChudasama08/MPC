#include <iostream>
using namespace std;
class Number
{
    int a;

public:
    Number()
    {
        a = 0;
    };
    Number(int num)
    {
        a = num;
    }
    // when no copy constructor is found, then copoller supplies its own copy consturctor
    Number(Number &obj)
    {
        cout << "cpoy constructor call" << endl;
        a = obj.a;
    }
    void display()
    {
        cout << "The number for this object is " << a << endl;
    }
};
int main()
{
    Number x, y, z(45), z2;
    x.display();
    y.display();
    z.display();

    Number z1(z); // copy constructor invoked // call copy constructor
    z1.display();

    z2 = z; // copy constructor not called
    z2.display();

    Number z3 = z; // copy constructor called
    z3.display();
    return 0;
}