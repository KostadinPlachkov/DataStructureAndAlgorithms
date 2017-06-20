import java.util.*;

public class SetsAndMaps {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();  // The elements are randomly ordered. Fast!
        TreeSet<Integer> treeSet = new TreeSet<>();  // The elements are ordered incrementally
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();  // The order of appearance is preserved
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();  // Ordered incrementally by keys

        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split("\\W+");
        for (String number: numbers) {
            hashSet.add(Integer.parseInt(number));
        }
        for (String number: numbers) {
            treeSet.add(Integer.parseInt(number));
        }
        for (String number: numbers) {
            linkedHashSet.add(Integer.parseInt(number));
        }
        Integer index = Integer.MAX_VALUE;
        for (String number: numbers) {
            hashMap.put(index--, Integer.parseInt(number));
        }
        for (String number: numbers) {
            treeMap.put(index--, Integer.parseInt(number));
        }
        System.out.println("HashSet:" + hashSet);
        System.out.println("TreeSet:" + treeSet);
        System.out.println("LinkedHashSet:" + linkedHashSet);
        System.out.println("HashMap:" + hashMap);
        System.out.println("TreeMap:" + treeMap);


    }
}
