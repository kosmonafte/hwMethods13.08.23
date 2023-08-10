public class Matrix {
    public static int[][] create(int sizeA, int sizeB, int version) {
        int mtrx[][] = new int[sizeA][sizeB];
        if (version == 0) {
            for (int i = 0; i < sizeA; i++) {
                for (int j = 0; j < sizeB; j++) {
                    mtrx[i][j] = 0;
                }
            }
        } else if (version == 1) {
            for (int i = 0; i < sizeA; i++) {
                for (int j = 0; j < sizeB; j++) {
                    if (i == j) {
                        mtrx[i][j] = 1;
                    } else {
                        mtrx[i][j] = 0;
                    }
                }
            }
        } else if (version == 8) {
            for (int i = 0; i < sizeA; i++) {
                for (int j = 0; j < sizeB; j++) {
                    mtrx[i][j] = (int)(Math.random()*10);
                }
            }
        } else {
            for (int i = 0; i < sizeA; i++) {
                for (int j = 0; j < sizeB; j++) {
                    mtrx[i][j] = 0;
                }
            }
        }
        return mtrx;
    }

//    public static int determinant(int arr[][]) {
//
//    }

    public static int[][] addition(int a[][], int b[][]) {
        int c[][];
        if (a.length == b.length && a[0].length == b[0].length) {
            c = new int[a.length][a[0].length];
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    c[i][j] = a[i][j] + b[i][j];
                }
            }
        } else {
            c = new int[2][2];
        }

        return c;
    }

    public static int[][] multiplay(int a[][], int b[][]) {
        int c[][];
        if (a[0].length == b.length) {
            c = new int[a.length][b[0].length];
            for (int i = 0; i < c.length; i++) {
                for(int j = 0; j < c[0].length; j++) {
                    for(int k = 0; k < a[0].length; k++) {
                        c[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
        } else {
            c = new int[2][2];
        }
        return c;
    }

    public static int[][] multiplayScalar(int array[][], int x) {
        int arr[][] = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                arr[i][j] = array[i][j] * x;
            }
        }
        return arr;
    }

    public static String show(int arr[]) {
        String str = new String();
        for (int i = 0; i < arr.length; i++) {
            str += arr[i] + " ";
        }
        return str;
    }

    public static String show(String arr[]) {
        String str = new String();
        for (int i = 0; i < arr.length; i++) {
            str += arr[i] + " ";
        }
        return str;
    }

    public static String show(int arr[][]) {
        String str = new String();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                str += arr[i][j] + " ";
            }
            str += "\n";
        }
        return str;
    }

    public static String show(float arr[][]) {
        String str = new String();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                str += arr[i][j] + " ";
            }
            str += "\n";
        }
        return str;
    }
}
