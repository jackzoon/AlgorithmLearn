package basic.class_01;

public class Code_08_NetherlandsFlag {

    public static int[] partition(int[] arr, int L, int R, int num) {
        int less = L - 1;
        int more = R + 1;
        int cur = L;
        while (cur < more) {
            if (arr[cur] < num) {
                ArrayUtils.swap(arr, ++less, cur++);
            } else if (arr[cur] > num) {
                ArrayUtils.swap(arr, --more, cur);
            } else {
                cur++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

}
