#include<iostream>
using namespace std;

//inline funtion 
//it is recvest compiler to convert inline funtion 
//using only sort funtion
/* not using if using recursun, any static (executes only once time it is static) variable, loops, switch, .... */
inline int sum(int x, int y){ //sum is inline function and in compiler time this function is copy from calling spase (jyathi function call thay tya copy thay chhe tethi program run time fast thay jay chhe)
    return(x+y);
}

//default agruments
//you set argument values , if in calling time agumrnt not pase then use it, and if calling time agument pased then use pased agruments 
//default agrumetns set only all argument (right side, not left side)
float rupeeswyaj(float jma, float wyaj_on_all=1.8){ 
    return jma*wyaj_on_all;
}

//canstant argument
int v(const int d, int n){ //in funtion run time int d value is not change
    return d+n;
}

/* char vishal(char c, char v, char s){
    return c + v + s;
} */
int main(){
    int a,b;
    cout<<"Enter the value of a and b"<<endl;
    cin>>a>>b;
    cout<<"Sum of a and b is "<<sum(a,b)<<endl; 
    cout<<"Sum of a and b is "<<sum(a,b)<<endl;
    cout<<"Sum of a and b is "<<sum(a,b)<<endl;

    float rupees = 1500000, wyaj_on_vip = 1.05;
    cout<<"Normal custumer wyaj in this month is "<<rupeeswyaj(rupees)<<endl;
    cout<<"VIP custumer wyaj in this month is "<<rupeeswyaj(rupees, wyaj_on_vip)<<endl;
    
    int v1=10, n1=15;
    cout<<v(v1,n1);
    /* char c1[]="0123456789", v2[]="0123456789", s3[]="0123456789";
    cout<<vishal(c1[3], v2[2], s3[2]); */ // I dant no this function how run but it's output is ASCII any numbers 

    return 0;
}