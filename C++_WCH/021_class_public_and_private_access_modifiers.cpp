#include <iostream>
using namespace std;

class Emp
{
private:
    int a = 1, b = 2, c = 3;

public:
    int d = 4, e = 5;
    void setData(int a, int b, int c); // funtion declaration
    void getData()
    {
        cout << "The value of a is " << a << endl;
        cout << "The value of b is " << b << endl;
        cout << "The value of c is " << c << endl;
        cout << "The value of d is " << d << endl;
        cout << "The value of e is " << e << endl;
    }
};

void Emp::setData(int a1, int b1, int c1)
{ // funtion code
    a = a1;
    b = b1;
    c = c1;
}

int main()
{
    Emp vishal;
    // vishal.a = 8; //a is not public it is private then you not change and modify
    vishal.d = 143;  // d is public then you change and modifiy
    vishal.e = 1432; // e is public then you change and modifiy
    vishal.setData(1, 2, 4);
    vishal.getData();
    return 0;
}