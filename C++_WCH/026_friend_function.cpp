#include <iostream>
using namespace std;
class complex
{
private:
    int a, b;

public:
    void setNumber(int n1, int n2)
    {
        a = n1;
        b = n2;
    }
    friend complex sumcomplex(complex, complex); // this line is deffine friend funtoin, writte any-ver on class (private, public,...)
    void printnumber()
    {
        cout << "You Number Is " << a << " + " << b << "i" << endl;
    }
};

complex sumcomplex(complex o1, complex o2) // this funtion is not member of complex class but it is use complex class private varible becose complex class is deffine as friend function. it is deffine friend funtion then this funtion use complex class private varible
{
    complex o3;
    o3.setNumber((o1.a + o2.a), (o2.b + o2.b));
    return o3;
}

int main()
{
    complex c1, c2, c3;
    c1.setNumber(5, 8);
    c1.printnumber();

    c2.setNumber(4, 6);
    c2.printnumber();

    cout << "             --------" << endl;

    c3 = sumcomplex(c1, c2); // this funtion not use derectly like c3.sumcomplex becouse this funtion is no member of complex class
    c3.printnumber();
    return 0;
}