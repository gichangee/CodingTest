#include <iostream>
using namespace std;
int main()
{
    double a,b,c;
    
    cin >> a >> b;
    cout<<fixed;
    cout.precision(9);
    c=a/b;
    cout << c;
    return 0;
}