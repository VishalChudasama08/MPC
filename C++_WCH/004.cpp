//variable type global and local
#include<iostream>
using namespace std;
int g = 8; //g is global variable
int vishal(){
    cout << "\nGlobal variable g is " << g; //g = 10
}
int main(){
    int g = 10, a = 5, b = 8;
    float pi = 3.14;
    bool t = true, f = false;
    char v = 'V'; //save only one character if ensert more charecter then values is last character
    cout << "This is Tutorial 004.cpp";
    cout << "\nHere Intiger Value of a is " << a << " And Value of b is " << b;
    cout << "\nFloting Point Value of pi is " << pi;
    cout << "\nCharacter Value of v is " << v;
    cout << "\nboolian Value of t is " << t; //1
    cout << "\nboolian Value of f is " << f; //0
    cout << "\nGlobal variable g is " << g; // g = 8 
    vishal();
    return 0;
}
/*
    max variables name characters is 255 characters.
    first later is not number. you can use underscore(_).
    not use wightpase, and variable is case sensitive.
*/