//Input-Output values cout & cin 
#include<iostream>
using namespace std;

int main()
{
    int num1, num2;
    cout << "Enter the value of num1 : "; // '<<' is colled Insertion opration ( '<<' using to give value) 
    cin >> num1; // '>>' is colled extraction opration ('>>' using to get value)

    cout << "\nEnter the value of num2 : ";
    cin >> num2;

    cout << "\nThis sum is " << num1 + num2;
    return 0;
}