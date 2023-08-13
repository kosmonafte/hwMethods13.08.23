public class Task01 {
    public static void main(String[] args) {
        int arr[][] = Matrix.create(3,2,8);
        int arr2[][] = Matrix.create(2,3,8);
        System.out.println(Matrix.show(arr));
        System.out.println(Matrix.show(arr2));
        int arr3[][] = Matrix.multiplay(arr, arr2);
        System.out.println(Matrix.show(arr3));
        int arr4[][] = Matrix.multiplayScalar(arr3, 2);
        System.out.println(Matrix.show(arr4));
    }
}

