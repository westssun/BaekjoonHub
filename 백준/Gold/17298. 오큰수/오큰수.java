import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) {
        // write your code here
        Main main = new Main();
        main.solution();
    }

    public void solution() {
        input();

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);

        for (int i = 2; i < arr.length; i++) {
            while (!stack.isEmpty()) {
                if (arr[stack.peek()] < arr[i]) {
                    arr[stack.pop()] = arr[i];
                } else {
                    break;
                }
            }

            stack.push(i);
        }

        while(!stack.isEmpty()) {
            arr[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }

    private void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = sc.nextInt();
        }
    }
}
