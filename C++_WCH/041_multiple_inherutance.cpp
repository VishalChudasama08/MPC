#include <iostream>
using namespace std;
class base1
{
protected:
    int base1int;

public:
    void set_base1int(int a)
    {
        base1int = a;
    }
};

class base2
{
protected:
    int base2int;

public:
    void set_base2int(int a)
    {
        base2int = a;
    }
};

class base3
{
protected:
    int base3int;

public:
    void set_base3int(int a)
    {
        base3int = a;
    }
};
class derived : public base1, public base2, public base3
{
public:
    void show()
    {
        cout << "The value of Base1 is " << base1int << endl;
        cout << "The value of Base2 is " << base2int << endl;
        cout << "The value of Base3 is " << base3int << endl;
        cout << "The sum of these values is " << base1int + base2int + base3int << endl;
    }
};
/*
The inherited derived class will look something like this :
Data members:
    base1int --> protected
    base2int --> protected
    base3int --> protected
Member function:
    set_base1int() --> public
    set_base2int() --> public
    set_base3int() --> public
    show() --> public
*/
int main()
{
    derived vishal;
    vishal.set_base1int(8);
    vishal.set_base2int(5);
    vishal.set_base3int(5);
    vishal.show();
    return 0;
}