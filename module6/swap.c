#include <stdio.h>

/* Swaps two ints using pointers (addresses), so the change is visible
   back in main. */
void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

/* Does NOT swap anything real. This function receives COPIES of the
   values (pass-by-value), not the addresses of x and y. Whatever it
   does to a and b only changes its own local copies; main's x and y
   are untouched. */
void broken_swap(int a, int b) {
    int temp = a;
    a = b;
    b = temp;
}

/* --- Optional "go further" section --------------------------------
   Same swap logic, different types. Notice the body is identical to
   swap() above except for the type name -- this is exactly the kind
   of repetition that C++ templates / Java generics exist to remove. */
void swap_doubles(double *a, double *b) {
    double temp = *a;
    *a = *b;
    *b = temp;
}

void swap_chars(char *a, char *b) {
    char temp = *a;
    *a = *b;
    *b = temp;
}
/* -------------------------------------------------------------------- */

int main(void) {
    int x = 10, y = 20;

    printf("Before swap: x = %d, y = %d\n", x, y);
    swap(&x, &y);
    printf("After swap:  x = %d, y = %d\n", x, y);

    printf("\n--- Now the broken version (no pointers) ---\n");
    int p = 10, q = 20;
    printf("Before broken_swap: p = %d, q = %d\n", p, q);
    broken_swap(p, q);
    printf("After broken_swap:  p = %d, q = %d  (unchanged!)\n", p, q);

    /* Optional bonus demo */
    printf("\n--- Optional: swap_doubles and swap_chars ---\n");
    double d1 = 1.5, d2 = 2.5;
    printf("Before swap_doubles: d1 = %.1f, d2 = %.1f\n", d1, d2);
    swap_doubles(&d1, &d2);
    printf("After swap_doubles:  d1 = %.1f, d2 = %.1f\n", d1, d2);

    char c1 = 'A', c2 = 'B';
    printf("Before swap_chars: c1 = %c, c2 = %c\n", c1, c2);
    swap_chars(&c1, &c2);
    printf("After swap_chars:  c1 = %c, c2 = %c\n", c1, c2);

    return 0;
}
