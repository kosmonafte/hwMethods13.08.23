import java.util.Scanner;

public class Task05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество копейщиков");
        int numbers = scanner.nextInt();
        System.out.println("Введите количество здоровья копейщиков");
        int hp = scanner.nextInt();
        System.out.println("Введите силу атаки копейщиков");
        int damage = scanner.nextInt();
        Squad sq = new Squad(numbers, hp, damage);
        System.out.println("Введите количество здоровья дракона");
        hp = scanner.nextInt();
        System.out.println("Введите силу атаки дракона");
        damage = scanner.nextInt();
        Dragon drg = new Dragon(hp, damage);
        while (sq.getLiveStatus() && drg.getLiveStatus()) {
            if (sq.getLiveStatus()) {
                System.out.println(sq.showSquadHp());
                System.out.println("Отряд копейщиков наносит удар!");
                System.out.println(drg.protect(sq.attack()) + "\n");
            }
            if (drg.liveStatus) {
                System.out.println("Дракон наносит удар!");
                System.out.println(sq.protectV2(drg.attack()) + "\n");
            }
        }
        if (sq.getLiveStatus() && !drg.getLiveStatus()) {
            System.out.println("На этот раз копейщики одержали победу!");
        } else {
            System.out.println("На этот раз дракон победил!");
        }
    }
}
