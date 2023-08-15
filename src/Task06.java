import java.util.Scanner;
import java.lang.String;
class Task06 {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        String str = "[r(t[(u)i[o[]b(v)c]x]s)t([]f(g[x](x[c]b)r)e(q)e)r]s[a(t(f)w[d])d]";//scanner.nextLine();
        if (!checkEven(str)) {
            System.out.println("Неправильное количество скобок!");
        } else if (!checkFirstBrackets(str)) {
            System.out.println("Выражение не может начинаться с закрывающей скобки!");
        } else if (!checkLastBrackets(str)) {
            System.out.println("Выражение не может заканчиваться на открывающую скобку!");
        } else if (!openCircleBrackets(str)) {
            System.out.println("Неправильный порядок скобок!");
        } else if (!openSquareBrackets(str)) {
            System.out.println("Неправильный порядок скобок!");
        } else {
            System.out.println("Ошибок нет!");
        }
    }
    public static boolean checkFirstBrackets(String str) {
        boolean res = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ']' || str.charAt(i) == ')') {
                res = false;
                break;
            } else if (str.charAt(i) == '[' || str.charAt(i) == '(') {
                res = true;
                break;
            }
        }
        return res;
    }
    public static boolean checkLastBrackets(String str) {
        boolean res = true;
        for (int i = str.length() - 1; i > -1; i--) {
            if (str.charAt(i) == ']' || str.charAt(i) == ')') {
                res = true;
                break;
            } else if (str.charAt(i) == '[' || str.charAt(i) == '(') {
                res = false;
                break;
            }
        }
        return res;
    }
    public static boolean checkEven(String str) {
        boolean res = true;
        int circleOpenCount = 0;
        int circleCloseCount = 0;
        int squareOpenCount = 0;
        int squareCloseCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                circleOpenCount++;
            } else if (str.charAt(i) == ')') {
                circleCloseCount++;
            } else if (str.charAt(i) == '[') {
                squareOpenCount++;
            } else if (str.charAt(i) == ']') {
                squareCloseCount++;
            }
        }
        if (circleOpenCount == circleCloseCount && squareOpenCount == squareCloseCount) {
            res = true;
        } else {
            res = false;
        }
        return res;
    }

    public static boolean openCircleBrackets(String str) {
        String tmpStr = str;
        int bracketsCount = 0;
        for (int i = 0; i < tmpStr.length(); i++) {
            if (tmpStr.charAt(i) == ')' || tmpStr.charAt(i) == '(') {
                bracketsCount++;
            }
        }
        if (bracketsCount == 0) {
            return true;
        } else {
            int leftBracketIndex = 0;
            int rightBracketIndex = 0;
            for (int i = 0; i < tmpStr.length(); i++) {
                if (tmpStr.charAt(i) == '(') {
                    leftBracketIndex = i;
                } else if (tmpStr.charAt(i) == ')') {
                    rightBracketIndex = i;
                    break;
                }
            }
            if (checkLine(str.substring(leftBracketIndex + 1, rightBracketIndex))) {
                String nStr = new String();
                nStr = str.substring(0, leftBracketIndex) + str.substring(rightBracketIndex + 1, str.length());
                return openCircleBrackets(nStr);
            } else {
                return false;
            }
        }
    }

    public static boolean openSquareBrackets(String str) {
        String tmpStr = str;
        int bracketsCount = 0;
        for (int i = 0; i < tmpStr.length(); i++) {
            if (tmpStr.charAt(i) == ']' || tmpStr.charAt(i) == '[') {
                bracketsCount++;
            }
        }
        if (bracketsCount == 0) {
            return true;
        } else {
            int leftBracketIndex = 0;
            int rightBracketIndex = 0;
            for (int i = 0; i < tmpStr.length(); i++) {
                if (tmpStr.charAt(i) == '[') {
                    leftBracketIndex = i;
                } else if (tmpStr.charAt(i) == ']') {
                    rightBracketIndex = i;
                    break;
                }
            }
            if (checkLine(str.substring(leftBracketIndex + 1, rightBracketIndex))) {
                String nStr = new String();
                nStr = str.substring(0, leftBracketIndex) + str.substring(rightBracketIndex + 1, str.length());
                return openSquareBrackets(nStr);
            } else {
                return false;
            }
        }
    }

    public static boolean checkLine(String str) {
        return checkFirstBrackets(str) && checkEven(str) && checkLastBrackets(str);
    }

//    public static String search(String str) {
//        String nStr = str;
//        int openCircleCount = 0;
//
//        int openSquareCount = 0;
//        int leftCircleIndex = -1;
//        int leftSquareIndex = -1;
//        boolean circle = false;
//        boolean square = false;
//        for (int i = 0; i < nStr.length(); i++) {
//            if (nStr.charAt(i) == '(') {
//                circle = true;
//                leftCircleIndex = i;
//                openCircleCount++;
//            } else if (nStr.charAt(i) == '[') {
//                square = true;
//                leftSquareIndex = i;
//                openSquareCount++;
//            } else if (nStr.charAt(i) == ')') {
//                if (!circle && openCircleCount == 0) {
//                    System.out.println(i);
//                    return "Ошибка, нет (";
//                } else if (circle && !square) {
//                    circle = false;
//                    leftCircleIndex = -1;
//                    openCircleCount--;
//                } else if (circle && square && leftSquareIndex > leftCircleIndex) {
//                    return "Ошибка, нет ]";
//                } else if (circle && square && leftSquareIndex < leftCircleIndex) {
//                    circle = false;
//                    leftCircleIndex = -1;
//                    openCircleCount--;
//                }
//            } else if (nStr.charAt(i) == ']') {
//                if (!square && openSquareCount == 0) {
//                    return "Ошибка, нет [";
//                } else if (square && !circle) {
//                    square = false;
//                    leftSquareIndex = -1;
//                    openSquareCount--;
//                } else if (square && circle && leftCircleIndex > leftSquareIndex) {
//                    return "Ошибка, нет )";
//                } else if (square && circle && leftCircleIndex < leftSquareIndex) {
//                    square = false;
//                    leftSquareIndex = -1;
//                    openSquareCount--;
//                }
//            }
//        }
//        return "Ошибок нет";
//    }
}
