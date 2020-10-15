#include<iostream>

using namespace std;

void fun(int x){
    cout<<"int function ran"<<endl;
}
void fun(double x){
    cout<<"float function ran"<<endl;
}

int main(int argc, char const *argv[])
{


    fun(1);
    fun(1.0);

    return 0;
}
