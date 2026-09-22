#include <stdio.h>

/* Takes two integer arguments and prints their sum and product. */
void print_math(int a, int b) {
    int sum = a + b;
    int product = a * b;
    printf("Sum:     %d\n", sum);
    printf("Product: %d\n", product);
}

int main(void) {
    int x, y;

    printf("Enter first number: ");
    scanf("%d", &x);

    printf("Enter second number: ");
    scanf("%d", &y);

    print_math(x, y);

    return 0;
}
