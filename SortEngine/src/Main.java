import java.util.List;

/**
 * Write a program  having generic functionality for sorting objects,
 all are instance of  java.lang.Number and Comparable java classes
 by two different ways – bubble and (quick) sortExample

 SortEngine<Float> sortEngine;
 sortEngine.add(num1)..
 List<Float> sorted = sortEngine.bubbleSort()/(quickSort())


 http://dox.bg/files/dw?a=6c9482fc31
 */



public class Main {
    public static void main(String[] args) throws Exception {
        SortEngine<String> sortEngine = new SortEngine<>();
        sortEngine.add(5.3);
        sortEngine.add(7.6);
        sortEngine.add(1.8);
        sortEngine.add(2.7);
        sortEngine.add(60.9);
        List sorted = sortEngine.bubbleSort();
        System.out.println(sorted);

    }
}
