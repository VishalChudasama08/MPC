#include <iostream>
using namespace std;
// Base Class
class Employee
{
public:
    int id;
    float salary;
    Employee() {} // on inheritance time run this defalt constructor
    Employee(int ids)
    {
        id = ids;
        salary = 34;
    }
};
// Derived Class syntax
/*
class {{derived-class-name}} : {{visibility-mode}} {{base-class-name}}
{
    class members/methods/etc.....
}

Notes :-
1. Default visibility mode is private.
2. If visibility is Public Mode, Then Base Class Public Members it is Derived Class Public Members.
3. If visibility is Private Mode, Then Base Class Public Member it is Derived class Private Members.
4. Base Class Private Menbers Are Never Inherited In Derived Class.
*/

// Creating a programmer derived class from employee base class
class Programmer : Employee
{
public:
    int languageCode = 3;
    Programmer(int ids)
    {
        id = ids;
    }
    void getData()
    {
        cout << "Programmer ID is :- " << id << endl;
    }
};

int main()
{
    Employee vishal(8), nitin(9);
    cout << "Fisrt Employee ID is :- " << vishal.salary << endl;
    cout << "Second Employee ID is :- " << nitin.salary << endl;

    Programmer skiiF(5);
    // cout<<skiiF.id; // this id is Base Class public variable then this is derived class private variable, and any private member is not dyrecy calling using there object, if base class visibility is set public then this line run.
    cout << "languageCode is :- " << skiiF.languageCode << endl;
    skiiF.getData();
    return 0;
}