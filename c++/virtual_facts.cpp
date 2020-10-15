#include<iostream>
using namespace std;

class A{
    int a;
    int b;
    // int d;
    // int c;
    // virtual void fun(){
    //     // cout<<"a is great";
    // }
    virtual void fun2(){
        // cout<<"a is great too";
    }
    //  void fun2(){
    //     cout<<"a is great too";
    //     int x=4;
    // }
};


int main(int argc, char const *argv[])
{
    // A* a=new A();
    A a;
    cout<<sizeof(a)<<endl;
    cout<<sizeof(A)<<endl;
    return 0;
}
