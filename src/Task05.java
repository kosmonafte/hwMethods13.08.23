public class Task05 {
    public static void main(String[] args) {
        Squad sq = new Squad(4, 100, 20);
        System.out.println(sq.showSquadHp());
        sq.protect(450);
        System.out.println(sq.showSquadHp());
    }
}
