

public class Algorithms {

    protected static <T> void bubbleSortAlgorithm(T[] unsorted) {
        for (int iter = 1; iter < unsorted.length; iter++) {
            for (int inner = 0; inner < (unsorted.length - iter); inner++) {
                if ((((Comparable) (unsorted[inner])).compareTo(unsorted[inner + 1])) > 0) {
                    T tmp = unsorted[inner];
                    unsorted[inner] = unsorted[inner + 1];
                    unsorted[inner + 1] = tmp;
                }
            }
        }
    }

    protected static <T> void quickSortAlgorithm(T[] arr, int startingIndex, int endingIndex) {
        if (startingIndex < endingIndex) {
            int i = startingIndex, j = endingIndex;
            T x = arr[(i + j) / 2];

            do {
                while (((Comparable) arr[i]).compareTo(x) < 0) i++;
                while (((Comparable) x).compareTo(arr[j]) < 0) j--;

                if ( i <= j) {
                    T tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    i++;
                    j--;
                }

            } while (i <= j);

            quickSortAlgorithm(arr, startingIndex, j);
            quickSortAlgorithm(arr, i, endingIndex);
        }
    }
}
