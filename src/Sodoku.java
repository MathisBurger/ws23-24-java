public class Sodoku {

    public static void main(String... args) {
        String sudoku =
                "769150000" +
                "234897060" +
                "158036000" +
                "390010400" +
                "000360000" +
                "041080032" +
                "000671050" +
                "070043008" +
                "010028307";
        int[][] sod = string2Sodoku(sudoku);
        System.out.println(valiodateSodoku(sod));
    }

    static int[][] string2Sodoku(String s) {
        if (s.length() != 81) {
            System.exit(1);
        }
        int[][] so = new int[9][9];
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                so[i][j] = s.charAt(i*9+j) - '0';
            }
        }
        return so;
    }

    static boolean valiodateSodoku(int[][] sodoku) {
        for (int z=0; z<9; z++) {
            int[] buch = new int[10];
            for (int s = 0; s<9; s++) {
                if (sodoku[z][s] < 1 || sodoku[z][s] > 9) {
                    return false;
                }
                if (buch[sodoku[z][s]] >= 1) {
                    return false;
                }
                buch[sodoku[z][s]] += 1;
            }
        }
        for (int z=0; z<9; z++) {
            int[] buch = new int[10];
            for (int s = 0; s<9; s++) {
                if (sodoku[s][z] < 1 || sodoku[s][z] > 9) {
                    return false;
                }
                if (buch[sodoku[s][z]] >= 1) {
                    return false;
                }
                buch[sodoku[s][z]] += 1;
            }
        }
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                int[][] sub = new int[3][3];
                for (int c=0; c<3; c++) {
                    for (int c2=0; c2<3; c2++) {
                        sub[c][c2] = sodoku[i*3+c][j*3+c2];
                    }
                }
                if (!validateSmallSod(sub)) return false;
            }
        }
        return true;
    }

    static boolean validateSmallSod(int[][] sodoku) {
        for (int z=0; z<3; z++) {
            int[] buch = new int[10];
            for (int s = 0; s<3; s++) {
                if (sodoku[z][s] < 1 || sodoku[z][s] > 9) {
                    return false;
                }
                if (buch[sodoku[z][s]] >= 1) {
                    return false;
                }
                buch[sodoku[z][s]] += 1;
            }
        }
        for (int z=0; z<3; z++) {
            int[] buch = new int[10];
            for (int s = 0; s<3; s++) {
                if (buch[sodoku[s][z]] >= 1) {
                    return false;
                }
                buch[sodoku[s][z]] += 1;
            }
        }
        return true;
    }
}
