// header file, all operators

/* two type of header file
1. system header file : it is comes with the compiler */
#include<iostream>
/*
2. user defined header files: it is written by the the programmer
examples => #include "this.h" //this.h is definde header file, if it is not present then produse an error
*/

using namespace std;

int main(){
    //Assignment operators (=)
    int a = 2, b = 3;

    cout << "Following are the types of operators in c++" << endl << endl; //endl using like (\n) new line
    //Arithemetic operators (+,-,*,/,%)
    cout << "The Value of a + b is " << a + b << endl;
    cout << "The Value of a - b is " << a - b << endl;
    cout << "The Value of a * b is " << a * b << endl;
    cout << "The Value of a / b is " << a / b << endl;
    cout << "The Value of a % b is " << a % b << endl << endl;

    //Increment and Decrement operators (++,--)
    cout << "This Value of a++ is " << a++ << endl; 
    cout << "This Value of a-- is " << a-- << endl; 
    cout << "This Value of ++a is " << ++a << endl; 
    cout << "This Value of --a is " << --a << endl << endl; 

    //Comparison operators (==, <, >, <=, >=, !=)
    cout << "The Value of a == b is " << (a == b) << endl;
    cout << "The Value of a > b is " << (a > b) << endl;
    cout << "The Value of a < b is " << (a < b) << endl;
    cout << "The Value of a <= b is " << (a <= b) << endl;
    cout << "The Value of a >= b is " << (a >= b) << endl;
    cout << "The Value of a != b is " << (a != b) << endl;

    //Logical operators (&&{and}, ||{or}, !{not})
    cout << "The value of the logical and(&&) operator ((a==b) && (a<b)) is : " << ((a==b) && (a<b)) << endl;
    cout << "The value of the logical or(||) operator ((a==b) || (a<b)) is : " << ((a==b) || (a<b)) << endl;
    cout << "The value of the logical not(!) operator (!(a==b)) is : " << (!(a==b)) << endl;
    return 0;
}
