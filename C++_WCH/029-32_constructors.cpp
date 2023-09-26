#include <iostream>
using namespace std;
class complex
{
private:
    int a, b, c = NULL, d = NULL;

public:
    complex(void); // constructoor like a function and this is deffen in this line, not write rutern values
    complex(int x) // This is parameterized constructor
    {
        a = x;
        b = 3;
        cout << "The is parameterized constructor. one parameter and two as it is" << endl;
    }
    complex(int x, int y) // This is parameterized constructor
    {
        a = x;
        b = y;
        cout << "The is parameterized constructor. two parameter" << endl;
    }
    complex(int x, int y, int z, int v = 8) // This is Default parameterized constructor
    {
        a = x;
        b = y;
        c = z;
        d = v;
        cout << "The is Default parameterized constructor. three parameter and fourth default set parameter" << endl;
    }
    void display()
    {
        cout << "a = " << a << endl;
        cout << "b = " << b << endl;
        if (c != NULL)
        {
            cout << "c = " << c << endl;
        }
        if (d != NULL)
        {
            cout << "d = " << d << endl;
        }
    }
};

complex::complex() // this is constructor (function name sem as class name it is constructor) and you set class object then this is run automaticklly, this type constructor colled default constructor
{
    a = 2;
    b = 3;
    cout << "The is simple constructor." << endl;
}

int main()
{
    complex a; // simple constructor
    a.display();

    complex b(10); // one parameterized constructor
    b.display();

    complex c(10, 20); // two parameterized constructor
    c.display();

    complex d(10, 20, 30); // Default parameterized constructor
    d.display();
    return 0;
}
