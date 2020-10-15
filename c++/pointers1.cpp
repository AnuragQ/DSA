#include<iostream>

using namespace std;



int main(int argc, char const *argv[])
{
    int x=1;
    int *y=&x;
    int &i=x;
    i=*y;
    
    cout<<i<<" "<<&i<<" "<<y<<" "<<*y<<endl;

    return 0;
}
