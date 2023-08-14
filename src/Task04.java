public class Task04 {
    public static void main(String[] args) {
        int[][] triangle = createTriangle(5);
        System.out.println(showTriangle(triangle));
        System.out.println(maxWay(triangle, 0, 0));
    }
    public static String showTriangle(int[][] arr) {
        String str = new String();
        int steps = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < steps; k++) {
                str += "  ";
            }
            for (int j = 0; j < arr[i].length; j++) {
                str += String.format("%2d  ", arr[i][j]);//arr[i][j] + "  ";
            }
            str += "\n";
            steps--;
        }
        return str;
    }
    public static int[][] createTriangle(int rows) {
        int[][] arr = new int[rows][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i+1];
            for (int j = 0; j < i+1; j++) {
                arr[i][j] = (int)(Math.random()*10);
            }
        }
        return arr;
    }
    public static int maxWay(int[][] arr, int i, int j) {
        int result = arr[i][j];
        if (i != arr.length -1) {
            int leftNum = maxWay(arr, i + 1, j);
            int rightNum = maxWay(arr, i + 1, j + 1);
            if (leftNum > rightNum) {
                result += leftNum;
            } else {
                result += rightNum;
            }
        }
        return result;
    }
}
