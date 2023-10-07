#include <iostream>
using namespace std;
class Student
{
protected:
    int roll_number;

public:
    void set_number(int rn)
    {
        roll_number = rn;
    }
    void get_number()
    {
        cout << "Your Roll Number is :- " << roll_number << endl;
    }
};
class Test : virtual public Student
{
protected:
    float maths, physics;

public:
    void set_marks(float m, float p)
    {
        maths = m;
        physics = p;
    }
    void get_marks()
    {
        cout << "Your result is here: " << endl
             << "Maths : " << maths << endl
             << "Physics : " << physics << endl;
    }
};
class Sport : virtual public Student
{
protected:
    int score;

public:
    void set_score(int sc)
    {
        score = sc;
    }
    void get_score()
    {
        cout << "Your Sports Score: " << score << endl;
    }
};
class Result : public Test, public Sport
{
protected:
    float total, result;

public:
    void Display(void)
    {
        total = maths + physics + score;
        result = total / 3;
        cout << "Your total score is : " << total << endl
             << "Youe Result is : " << result << "%" << endl;
    }
};
int main()
{
    Result vishal;
    vishal.set_number(76);
    vishal.set_marks(95.45, 96.76);
    vishal.set_score(76);
    vishal.get_number();
    vishal.get_marks();
    vishal.get_score();
    vishal.Display();
    return 0;
}