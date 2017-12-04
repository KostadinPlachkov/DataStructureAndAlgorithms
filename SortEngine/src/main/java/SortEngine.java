import java.util.ArrayList;
import java.util.List;

public class SortEngine<T extends Number & Comprable<T>> extends Algorithms {

    private ArrayList<T> unsortedArrayList = new ArrayList<>();
    private ArrayList<Number> sortedArrayList = new ArrayList<>();

    public int length() {
        return unsortedArrayList.size();
    }

    public void add(T number){
        unsortedArrayList.add(number);
    }

    public List quickSort() throws Exception {
        Object[] array = this.unsortedArrayList.toArray();
        quickSortAlgorithm(array, 0, array.length);
        try {
            for (Object num : array) {
                sortedArrayList.add((Number) num);
            }
        }
        catch (Exception e) {
            throw new Exception("Invalid input, use SortEngine<T> with numbers only! Exception: " + e);
        }
        return sortedArrayList;
    }


    public List bubbleSort() throws Exception {
        Object[] array = this.unsortedArrayList.toArray();
        bubbleSortAlgorithm(array);
        try {
            for (Object num : array) {
                sortedArrayList.add((Number) num);
            }
        }
        catch (Exception e) {
            throw new Exception("Invalid input, use SortEngine<T> with numbers only! Exception: " + e);
        }
        return sortedArrayList;
    }

}
