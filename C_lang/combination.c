#include <stdio.h>


int main()
{
    int a = 10;
    int arr[a];

    for (int i = 0; i < 10; i++) {
        arr[i] = i*i;
    }



    for (int i = 0; i < 10; i++) {
        printf("%d\n",arr[i]);
    }

    return 0;

}