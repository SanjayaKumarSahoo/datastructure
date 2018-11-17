package payground;

public class Play {

    public static void main(String[] args) {
        int[] A = {4, 6, 1, 2};
        play(A);

        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }

    private static void play(int A[]) {
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                if (A[i] > A[j]) {
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }
            }
        }
    }
}
