#include <iostream>
using namespace std;

// iterative
int bsearch(int a[], int sz, int x)
{
	int low = 0;
	int high = sz -1;
	while(low <= high) {
		int mid = (low+high)/2;
		if(x < a[mid]) 
			high = mid - 1;
		else if(x > a[mid]) 
			low = mid + 1;
		else 
			return a[mid];
	}
	return -1;
}

// recursive
int bsearch_recursive(int a[], int low, int high, int x)
{
	if(low > high) return -1;

	int mid = (low + high)/2;
	if(x < a[mid])
		bsearch_recursive(a, low, mid-1, x);
	else if(x > a[mid])
		bsearch_recursive(a, mid+1, high, x);
	else
		return a[mid];
}
 
void print(int n)
{
	if(n == -1) {
		cout << "not found" << endl;
		return;
	}
	cout << "found" << endl;

}
int main()
{        
	int a[]={3, 7, 9, 16, 23, 34, 67, 87, 92};
	int arraySize = sizeof(a)/sizeof(int);
	int result;

	result = bsearch(a, arraySize, 7); 
	print(result);
	result = bsearch(a, arraySize, 92); 
	print(result);
	result = bsearch(a, arraySize, 77); 
	print(result);

	result = bsearch_recursive(a, 0, arraySize-1, 7); 
	print(result);
	result = bsearch_recursive(a, 0, arraySize-1, 92); 
	print(result);
	result = bsearch_recursive(a, 0, arraySize-1, 77); 
	print(result);

	return 0;
}
