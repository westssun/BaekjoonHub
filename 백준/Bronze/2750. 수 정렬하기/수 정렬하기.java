import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main= new Main();

        /** 1. 배열 개수 입력 */
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        // 배열 선언
        int[] arr = new int[num];

        /** 2. 배열 요소 입력 */
        for (int i = 0; i < num; i++) {
            arr[i] = scan.nextInt();
        }

        scan.close();

        /** 3. MAX 요소를 마지막 index 로 이동 */
        main.changeMaxNumIndex(arr);

        /** 4. 결과 출력 */
        for (int n : arr) {
            System.out.println(n);
        }
    }

    /**
     * MAX 요소를 마지막 index 로 이동
     * @param arr
     */
    private void changeMaxNumIndex(int[] arr) {
        int maxNum = Integer.MIN_VALUE; // 최대 숫자를 담을 변수
        int maxIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i; j++) {
                if (maxNum < arr[j]) {
                    maxNum = arr[j];
                    maxIndex = j;
                }
            }

            // 마지막 인덱스 숫자 저장
            int changeNum = arr[arr.length-(i+1)];

            // 마지막 인덱스에 maxNum 넣기
            arr[arr.length-(i+1)] = maxNum;
            arr[maxIndex] = changeNum;
            maxNum = Integer.MIN_VALUE;
        }
    }
}