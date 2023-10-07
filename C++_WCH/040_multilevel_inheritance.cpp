#include <iostream>
using namespace std;

class Student
{
protected:
    int roll_number;

public:
    void set_roll_number(int);
    void get_roll_number(void);
};
void Student::set_roll_number(int r)
{
    roll_number = r;
}
void Student::get_roll_number(void)
{
    cout << "The roll number is " << roll_number << endl;
}

class Exam : public Student
{
protected:
    float maths;
    float physics;

public:
    void set_marks(float, float);
    void get_marks(void);
};
void Exam ::set_marks(float m1, float m2)
{
    maths = m1;
    physics = m2;
}
void Exam ::get_marks(void)
{
    cout << "The marks obtained in maths are : " << maths << endl;
    cout << "The marks obtained in physics are : " << physics << endl;
}

class Result : public Exam
{
    float percentage;

public:
    void display_results()
    {
        get_roll_number();
        get_marks();
        cout << "Your percentage is " << (maths + physics) / 2 << "%" << endl;
    }
};

/*
The inherited derived (Result) class will look something like this :
Data members:
    roll_number --> protected
    maths --> protected
    physics --> protected
Member function:
    set_roll_number() --> public
    get_roll_number() --> public
    set_marks() --> public
    get_marks() --> public
    display_results() --> public
*/
int main()
{
    Result vishal;
    vishal.set_roll_number(176);
    vishal.set_marks(85, 75);
    vishal.display_results();
    return 0;
}