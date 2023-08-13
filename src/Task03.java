import sun.security.util.ArrayUtil;
public class Task03 {
    public static void main(String[] args) {
        String[] arrStr = new String[5];
        fillArr(arrStr);
        System.out.println(showArray(arrStr));
        srtChr(arrStr);
        System.out.println(showArray(arrStr));
        srtLgth(arrStr);
        System.out.println(showArray(arrStr));
    }

    public static void fillArr(String[] arr) {
        for (int k = 0; k < arr.length; k++) {
            arr[k] = "";
            int words = (int)(Math.random()*15 + 3);
            for (int i = 0; i < words; i++) {
                int letters = (int)(Math.random()*9 + 1);
                for (int j = 0; j < letters; j++) {
                    arr[k] += String.valueOf((char)(Math.random()*26 + 97));
                }
                arr[k] += " ";
            }
        }
    }

    public static String showArray(String[] arr) {
        String str = new String();
        for (int i = 0; i < arr.length; i++) {
            str += arr[i] + "\n";
        }
        return str;
    }

    public static void srtChr(String[] arr) {
        boolean isSorted = false;
        String buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length-1; i++) {
                if(arr[i].charAt(0) < arr[i+1].charAt(0)){
                    isSorted = false;
                    buf = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = buf;
                }
            }
        }
    }

    public static void srtLgth(String[] arr) {
        boolean isSorted = false;
        String buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length-1; i++) {
                int count = 0;
                int countTwo = 0;
                for (int j = 0; j < arr[i].length(); j++) {
                    if (arr[i].charAt(j) == ' ') {
                        count++;
                    }
                }
                for (int j = 0; j < arr[i+1].length(); j++) {
                    if (arr[i+1].charAt(j) == ' ') {
                        countTwo++;
                    }
                }
                if(count > countTwo){
                    isSorted = false;
                    buf = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = buf;
                }
            }
        }
    }
}
