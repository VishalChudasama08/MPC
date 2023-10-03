#include <iostream>
using namespace std;
// Destructor never takes an argumrnt and it not return any value
int count = 0;
class num
{
public:
    num()
    {
        count++;
        cout << "The is the time when costructor is called for object number " << count << endl;
    }

    ~num() // this is destructor declare to usinf ~ this sign , auto maticlly call afthe class all work is complit
    {
        cout << "This is the time when my destructor is called for object number " << count << endl;
        count--;
    }
};
int main()
{
    cout << "We are inside our main function" << endl;
    cout << "Creating first object n1" << endl;
    num n1;

    { // ha!! aarite block bamavi sakay chhe, jya block puro thay tya teni aandar nu badhu distroy thay jay chhe, tethi ahi n2, n3 block no scop aa block puruthay tya thay jay chhe, jyare n1 to sav last main block puro thay tya thay chhe
        cout << "Entering this block" << endl;
        cout << "Creating two more objects" << endl;
        num n2, n3;
        cout << "Exiting this block" << endl;
    }
    return 0;
}