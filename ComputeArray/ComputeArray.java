// package ComputeArray;

public class ComputeArray {
    public static int[] computeArray(int[] array) {
        if (array == null) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {

            if (Math.abs(array[i]) % 3 == 0) {
                array[i] *= 5;
            } else if (array[i] != -1 && (array[i] == 1 || (Math.abs(array[i]) - 1) % 3 == 0)) {
                array[i] += 7;
            } else if (array[i] == 2 || (Math.abs(array[i]) - 2) % 3 == 0) {
                array[i] = array[i];
            }
        }
        return array;
    }
}