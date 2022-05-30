import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] arr; // 부품 존재 배열
    static int M;
    static int[] findArr; // 찾을 부품 배열

    public static void main(String[] args) {
        // write your code here
        Main main = new Main();
        main.solution();
    }

    public void solution() {
        input();

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int target : findArr) {
            int startIndex = lowerBound(target);
            int endIndex = upperBound(startIndex, target);
            sb.append((endIndex - startIndex + 1)).append(" ");
        }

        System.out.println(sb);
    }

    private void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];

        /* 부품 존재 배열 */
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        M = sc.nextInt();
        findArr = new int[M];

        /* 찾을 부품 배열 */
        for (int i = 0; i < M; i++) {
            findArr[i] = sc.nextInt();
        }
    }

    private static int lowerBound(int target) {
        int start = 0;
        int end = arr.length; // start 가 마지막 인덱스 직전까지 체크되어야한다.

        while (start < end) {
            int mid = (start + end) / 2;

            /* target 이 중간값보다 작거나 같다면, 끝을 중간값으로 */
            if (target <= arr[mid]) {
                end = mid;
            } else { /* target 이 중간값보다 크다면 시작을 중간값 다음으로 */
                start = mid + 1;
            }
        }

        return start;
    }

    private static int upperBound(int startIndex, int target) {
        int start = startIndex;
        int end = arr.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (target >= arr[mid]) { /* target 이 중간값보다 크거나 같다면, 시작을 중간값 다음으로 */
                start = mid + 1;
            } else { /* target 이 중간값보다 작다면 끝을 중간값으로 */
                end = mid;
            }
        }

        return start - 1;
    }
}
