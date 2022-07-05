import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Date 2022/07/05
 * @URL https://www.acmicpc.net/problem/18406
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.solution());
    }

    public String solution() {
        Scanner sc = new Scanner(System.in);
        String point = sc.next();

        int size = point.length();

        /* 왼쪽 합 */
        int leftSum = IntStream.range(0, size / 2)
                .map(i -> (int) point.charAt(i)).sum();

        /* 오른쪽 합 */
        int rightSum = IntStream.range(size / 2, size)
                .map(i -> (int) point.charAt(i)).sum();

        return leftSum == rightSum ? "LUCKY" : "READY";
    }
}
