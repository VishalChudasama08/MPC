// build in data types, Literals, Reference variables, Typecastings

#include<iostream>
using namespace std;
int c = 45;
int main(){
    //*****build in data types*****
    int a, b, c;
    cout << "Enter the value of a : " << endl;
    cin >> a;
    cout << "Enter the value of b : " << endl;
    cin >> b;
    c = a + b;
    cout << "The sum c is " << c << endl;
    cout << "The global c is " << :: c << endl; // :: scop resolution operation use to use global variable values

    //*****float, double, long, long double Literals*****
    float d = 3.14f; // 3.14f f is specify to it is floating value ans 3.14l l is long double
    long double e = 3.14;

    cout << "The size of 3.14 is " << sizeof(3.14) << endl; //long -> 8
    cout << "The size of 3.14 is " << sizeof(3.14f) << endl; //float -> 4
    cout << "The size of 3.14 is " << sizeof(3.14F) << endl; //float -> 4
    cout << "The size of 3.14 is " << sizeof(3.14l) << endl; //long double -> 12
    cout << "The size of 3.14 is " << sizeof(3.14L) << endl; //long double -> 12
    cout << "The value of d is " << d << endl << "The value of e is " << e << endl;

    //*****Reference variables*****
    float x = 225;
    float & y = x; //& --> y ae x no reference chhe 
    cout<<x<<endl;
    cout<<y<<endl;

    //*****Typecastings*****
    int f = 45;
    float g = 22.45;
    cout << "The value of f is " << (float)f << endl; // f is intiger and typecasting to float
    cout << "The value of f is " << float(f) << endl; // sem as

    cout << "The value of g is " << (int)g << endl; //Typecasting float to int
    cout << "The value of g is " << int(g) << endl; //Typecasting float to int
    int h = int(g); // g is Typecasting float to int and save values on h

    cout << "The expression is " << f + g << endl;
    cout << "The expression is " << f + int(g) << endl;
    cout << "The expression is " << f + (int)g << endl;

    return 0;
}