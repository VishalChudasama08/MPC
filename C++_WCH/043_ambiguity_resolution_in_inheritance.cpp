#include <iostream>
using namespace std;
/* inheritance ma koy 2 ke tethi vadhare class ma semm name na functoin hoy tyare ambiguity create thay chhe, derived class ne kya base class nu function run kar vu te*/
class base1
{
public:
    void hey()
    {
        cout << "Heyyy... Man...!" << endl;
    }
};
class base2
{
public:
    void hey()
    {
        cout << "Hey There!" << endl;
    }
};
class derived : public base1, public base2
{
    int a;

public:
    void hey()
    {
        base1 ::hey(); // sholwed ambiguity to using this line, then this line run base1 hey() function
    }
};

class b
{
public:
    void v()
    {
        cout << "This v() function is b class member function";
    }
};
class de : public b
{
    int a;

public:
    void v()
    {
        cout << "This v() Function is d class member function";
    }
};
int main()
{
    base1 b1;
    b1.hey();
    base2 b2;
    b2.hey();
    derived d;
    d.hey(); // this line showing ambiguity if not set line number 27 or this line 25 function

    b B;
    B.v();
    de d1;
    d1.v();

    return 0;
}