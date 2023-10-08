#include <iostream>
using namespace std;

class Test
{
    int a;
    int b;

public:
    // set argumrnt to this class variable value
    //  Test(int i, int j) : a(i), b(j) //[Done]
    //  Test(int i, int j) : a(i), b(i+j) //[Done]
    //  Test(int i, int j) : a(i), b(2*j) //[Done]
    //  Test(int i, int j) : a(i), b(a+j) //[Done] becose a pela initializa karel chhe, on line 6, not line 14
    Test(int i, int j) : b(j), a(i + b) //[Wrong] becose b not set, je pela initializa karel hoy tej lakhi sakay, kay fer nathi padto aahi aa line na kon pela chhe (a ke b), a showing garbej value
    {
        cout << "Constructor  Executed" << endl;
        cout << "Value of a is " << a << endl;
        cout << "Value of b is " << b << endl;
    }
};

int main()
{
    Test t(2, 4);
    return 0;
}