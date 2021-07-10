#include <stdio.h>

int main() {

    int e = 1,s = 1,m = 1;
    int new_e = 1, new_s = 1, new_m = 1;
    int result = 1;// 최종답으로 도출될 결과.....
    
    scanf("%d %d %d",&e,&s,&m);

    while(1) {

        
        if (e == new_e && s == new_s && m == new_m) {
            break;
        } else {
            
            new_e++,new_s++,new_m++;
            result++;

            if (new_e > 15 ) new_e = 1;
            if (new_s > 28 ) new_s = 1;
            if (new_m > 19 ) new_m = 1;

        
        }
    }

    printf("%d", result);

    return 0;
}