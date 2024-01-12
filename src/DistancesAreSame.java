public class DistancesAreSame {

    static boolean distancesAreSame(int[][] arr) {
        for (int[] row : arr) {
            int initDiff = row[0]-row[1];
            for (int i=0; i<(row.length-1); i++) {
                if (initDiff != (row[i]-row[i+1])) {
                    return false;
                }
            }
        }

        for (int j=0; j<arr.length; j++) {
            int initDiff = arr[0][j]-arr[1][j];
            for (int i=0; i<(arr[i].length-1); i++) {
                if (initDiff != (arr[j][i]-arr[j][i+1])) {
                    return false;
                }
            }
        }
        return true;
    }
}
