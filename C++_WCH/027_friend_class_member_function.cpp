#include <iostream>
using namespace std;

class complex;

class calculater
{
public:
    int add(int a, int b)
    {
        return (a + b);
    }

    int sumrealcomplex(complex, complex);
    int sumcompcomplex(complex, complex);
};

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

    // Individually declaring function as friends
    // friend int calculater ::sumrealcomplex(complex, complex);
    // friend int calculater ::sumcompcomplex(complex, complex);

    // class declaring function as friends
    friend class calculater;

    friend complex sumcomplex(complex, complex); // this line is deffine friend funtoin, writte any-ver on class (private, public,...)
    void printnumber()
    {
        cout << "You Number Is " << a << " + " << b << "i" << endl;
    }
};

int calculater ::sumrealcomplex(complex o1, complex o2)
{
    return (o1.a + o2.a);
}

int calculater ::sumcompcomplex(complex o1, complex o2)
{
    return (o1.b + o2.b);
}

int main()
{
    complex c1, c2;
    c1.setNumber(5, 8);
    c2.setNumber(4, 6);

    calculater calc;
    int res = calc.sumrealcomplex(c1, c2);
    cout << "The sum of real part of c1 and c2 is " << res << endl;

    int comp = calc.sumcompcomplex(c1, c2);
    cout << "The sum of comp part of c1 and c2 is " << comp << endl;

    return 0;
}