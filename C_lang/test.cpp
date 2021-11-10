#include <iostream>
#include <stdio.h>
using namespace std;

class Node {
    int x;
    int y;
    public :
    Node(int x,int y) {
        this->x = x;
        this->y = y;
        
    }
};

int main(void) {

    int a = 10;

    cout << a << endl;

    return 0;
}