public class Unit {
    protected int hp;
    protected int damage;
    Unit() {
        this.hp = 1;
        this.damage = 1;
    }
    Unit(int hp) {
        this.hp = hp;
        this.damage = 1;
    }
    Unit(int hp, int damage) {
        this.hp = hp;
        this.damage = damage;
    }
    public int attack() {
        return this.damage;
    }

    public void protect(int attack) {
        this.hp -= attack;
    }
}
