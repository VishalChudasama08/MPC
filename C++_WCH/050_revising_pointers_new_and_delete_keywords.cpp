#include <iostream>
using namespace std;
int main()
{
    // basic example
    int a = 4;
    int *ptr = &a;
    *ptr = 8; // change value using pointer
    cout << "The Value of a is " << *ptr << endl;
    cout << "The Address of a is " << ptr << endl;

    // new keyword
    int *p = new int(40); // using new keyword to set daynamcly value, pointer p no je address hoy tya navi value set kare chhe, ahi te intijer data type and value is 40 chhe
    cout << "The value of p is " << *p << endl;
    cout << "The Address of p is " << p << endl;

    *p = 80; // change value using pointer
    cout << "The value of p is " << *p << endl;
    cout << "The Address of p is " << p << endl;

    float *f = new float(10.12); // daynemicly set float variable value
    cout << "The value of f is " << *f << endl;
    cout << "The Address of f is " << f << endl;

    int *arr = new int[3];
    arr[0] = 10;
    arr[1] = 20;
    *(arr + 2) = 30; // aaritey array index ma value save kari sakay chhe, ahi arr no je address chhe tya 2 plish kari je address aave chhe tya aa (ahi 30) value save kare chhe.

    cout << "The value of arr[0] is " << arr[0] << endl;
    cout << "The value of arr[1] is " << arr[1] << endl;
    cout << "The value of arr[2] is " << arr[2] << endl;
    cout << "The Address of arr is " << arr << endl;

    // delete operator/keyword
    int *v = new int(8);
    cout << "The value of v is " << *v << endl;
    delete v; // delete keyword using to free variable, ahi v variable delete jay chhe, te space free thay jay chhe, have tya koy pan value hoy sake
    cout << "after delete v intizer" << endl;
    cout << "The value of v is " << *v << endl;

    int *vv = new int[5];
    vv[0] = 1;
    vv[1] = 2;
    vv[2] = 3;
    vv[3] = 4;
    vv[4] = 5;
    cout << "The value of vv[0] is " << vv[0] << endl;
    cout << "The value of vv[1] is " << vv[1] << endl;
    cout << "The value of vv[2] is " << vv[2] << endl;
    cout << "The value of vv[3] is " << vv[3] << endl;
    cout << "The value of vv[4] is " << vv[4] << endl;
    cout << "The Address of v is " << v << endl;

    delete[] vv; // ahi array aakho delete karva mate [] lagadvu
    cout << "after delete vv array " << endl;
    cout << "The value of vv[0] is " << vv[0] << endl;
    cout << "The value of vv[1] is " << vv[1] << endl;
    cout << "The value of vv[2] is " << vv[2] << endl;
    cout << "The value of vv[3] is " << vv[3] << endl;
    cout << "The value of vv[4] is " << vv[4] << endl;
    cout << "The Address of v is " << v << endl;

    return 0;
}