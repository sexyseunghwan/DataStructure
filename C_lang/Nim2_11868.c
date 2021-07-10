#include <stdio.h>

int main(){

    int cycle,result=0,num;
    scanf("%d",&cycle);


    for (int i = 0; i < cycle; ++i){
        
        scanf("%d",&num);

        result ^= num;
    }

    if (result == 0) printf("cubelover");
    else printf("koosaga");


}