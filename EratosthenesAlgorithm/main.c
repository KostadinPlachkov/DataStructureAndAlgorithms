#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

/*
 N is a natural number.
 Find the quantity of natural numbers (they must be less than N),
 which can be evaluated from the multiplication of two prime numbers.
*/


unsigned int numbersRepresentedByTheMultOfTwoPrimesLessThan(unsigned int N);



int main()
{
    int answer, startTimer, stopTimer;
    unsigned int N;
    do
    {
        printf("Enter a natural number (N)[N > 0]: ");
        scanf("%d", &N);
    } while(N < 1);
    startTimer = GetTickCount();
    answer = numbersRepresentedByTheMultOfTwoPrimesLessThan(N);
    stopTimer = GetTickCount();
    printf("Answer: %d\nExecuted in: %d ms", answer, stopTimer - startTimer);

}

unsigned int numbersRepresentedByTheMultOfTwoPrimesLessThan(unsigned int N)
{
    unsigned int i, j,nextNotPrimeNumberIndex, numberOfElements, counter = 0;
    char *naturalNumbersDict; // The type is char because we are using only 1 or 0 (char is 1 byte, int is 2 or 4 bytes)
    if (N <= 4)
    {
        // No need to continue the function. For N [1-4] the answer is 0
        return counter;
    }
    else
    {
        numberOfElements = ((N - 1) / 2) + 2; // Number of elements for the array
        naturalNumbersDict = (char *) calloc(numberOfElements, sizeof(char)); // Using calloc() to set all of the indexes to 0

        if (naturalNumbersDict == NULL) {
            // Checking if there is an error
            printf("Dynamic memory error!");
            return -1;
        }

        for(i = 2; i < numberOfElements; i++)
        {
            // Sets the not prime numbers to 1
            if(naturalNumbersDict[i] == 0)
            {
                nextNotPrimeNumberIndex = i * i;
                while(nextNotPrimeNumberIndex < numberOfElements)
                {
                    naturalNumbersDict[nextNotPrimeNumberIndex] = 1;
                    nextNotPrimeNumberIndex += i;
                }
            }
        }
        /*
        // Uncomment to print all of the numbers in the array
        for (i = 2; i < numberOfElements; i++)
        {
            printf("%d ", i);
            printf("%d ", naturalNumbersDict[i]);
        }
        */
        for(i = 2; i < numberOfElements; i++)
        {
            // Adds 1 to counter every time when the multiplication of 2 prime numbers is less than N
            for (j = i; i * j < N; j++) {
                if (!naturalNumbersDict[i] && !naturalNumbersDict[j]) {
                    counter++;
                }
            }
        }
        return counter;
    }
}

