#include <stdio.h>

int plus(int a){
     printf("==> %d\n", a);

}
void print2(float f){
	printf("==> %f\n", f);
}

int main(int argc, char* argv[]) {

    printf("Hello\n");
    print(100);
    print2(3.14f);


}
// 이게 오버로딩
