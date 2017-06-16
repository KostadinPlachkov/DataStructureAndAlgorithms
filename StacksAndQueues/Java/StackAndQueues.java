import java.util.*;

/**
 * Created by Kostadin on 16-Jun-17.
 */
public class StackAndQueues {
    public static void main(String[] args) {
        ArrayDeque<String> deque = new ArrayDeque<>();  // Double ended queue, works like stack and queue.
        Scanner scanner = new Scanner(System.in);
        String[] numbers;
        numbers = scanner.nextLine().split("\\W+");
        Collections.addAll(deque, numbers);

        Stack<Integer> stack = new Stack<>();  // Traditional stack

    }
}
