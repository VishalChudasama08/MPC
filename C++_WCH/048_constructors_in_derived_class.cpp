#include <iostream>
using namespace std;
class Base1
{
    int data1;

public:
    Base1(int a)
    {
        data1 = a;
        cout << "Base1 class constrcntor called" << endl;
    }
    void print_data1()
    {
        cout << "The value of Data1 is " << data1 << endl;
    }
};
class Base2
{
    int data2;

public:
    Base2(int a)
    {
        data2 = a;
        cout << "Base2 class constructor called" << endl;
    }
    void print_data2()
    {
        cout << "The value of Data2 is " << data2 << endl;
    }
};

class Derived : public Base2, public Base1
{ // ahi first base2 then second base1 and then thired derived class na constructor call thay chhe
    int derived1, derived2;

public:
    Derived(int a, int b, int c, int d) : Base1(a), Base2(b)
    { // ahi Derived constructor ni 4 argument mathi a Base1 and b Base2 constructor ne made chhe, ahi aenathi kay ferpad to nathi ke kyo constructor (ahi base1, base2) pahela lakhel chhe, call to inheritance ma je pela inherit thay chhe tenej thay chhe, ahi public Base2 pela chhe tethi pela call base2 na constructor nej lage chhe, jo virtual class hoy to pela virtual class call thay chhe, tema pela hoy ke chhe le virtual j na constructor pela call thay, jo badha virtual hoy to pela lakhel no pelaj call thay chhe
        derived1 = c;
        derived2 = d;
        cout << "Derived class constructor called" << endl;
    }
    void print_derived()
    {
        cout << "The value of derived1 is " << derived1 << endl;
        cout << "The value of derived2 is " << derived2 << endl;
    }
};

int main()
{
    Derived d(1, 2, 3, 4);
    d.print_data1();
    d.print_data2();
    d.print_derived();
    return 0;
}