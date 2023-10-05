#include <iostream>
using namespace std;
// single inharitance and using visibility mode is public
/* class Base
{
    int data1; // default private variable and not inharitable this.
public:
    int data2;
    void setData();
    int getData1();
    int getData2();
};
void Base ::setData()
{
    data1 = 8;
    data2 = 7;
}
int Base ::getData1()
{
    return data1;
}
int Base ::getData2()
{
    return data2;
}

class Derived : public Base
{
    int data3;

public:
    void Prosess();
    void Display();
};
void Derived ::Prosess()
{
    data3 = data2 * getData1();
}
void Derived ::Display()
{
    cout << "Value Of Data 1 is " << getData1() << endl;
    cout << "Value Of Data 2 is " << data2 << endl;
    cout << "Value Of Data 3 is " << data3 << endl;
}
int main()
{
    Derived der;
    der.setData();
    der.Prosess();
    der.Display();
    return 0;
} */

// single inharitance and using visibility mode is Private
class Base
{
    int data1; // default private variable and not inharitable this.
public:
    int data2;
    void setData();
    int getData1();
    int getData2();
};
void Base ::setData()
{
    data1 = 8;
    data2 = 7;
}
int Base ::getData1()
{
    return data1;
}
int Base ::getData2()
{
    return data2;
}

class Derived : private Base
{
    int data3;

public:
    void Prosess();
    void Display();
};
void Derived ::Prosess()
{
    setData();
    data3 = data2 * getData1();
}
void Derived ::Display()
{
    cout << "Value Of Data 1 is " << getData1() << endl;
    cout << "Value Of Data 2 is " << data2 << endl;
    cout << "Value Of Data 3 is " << data3 << endl;
}
int main()
{
    Derived der;
    // der.setData(); //setData() in derived class private member becose base class visibility is private, then not posible to using derived class object to calling
    der.Prosess();
    der.Display();
    return 0;
}