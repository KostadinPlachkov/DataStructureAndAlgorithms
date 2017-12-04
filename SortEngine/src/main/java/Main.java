import java.util.List;


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
