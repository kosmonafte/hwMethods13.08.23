import java.util.AbstractQueue;

public class Unit {
    protected int startHp;
    protected int hp;
    protected int damage;
    protected boolean liveStatus;
    Unit() {
        this.hp = 1;
        this.startHp = this.hp;
        this.damage = 1;
        this.liveStatus = true;
    }
    Unit(int hp) {
        this.hp = hp;
        this.startHp = this.hp;
        this.damage = 1;
        this.liveStatus = true;
    }
    Unit(int hp, int damage) {
        this.hp = hp;
        this.startHp = this.hp;
        this.damage = damage;
        this.liveStatus = true;
    }

    public boolean getLiveStatus() {
        boolean status = this.liveStatus;
        return status;
    }
    public int attack() {
        int dmg = this.damage;
        return dmg;
    }

    public String protect(int damage) {
        String str = new String();
        if (damage < this.hp) {
            this.hp -= damage;
        } else {
            this.hp = 0;
            liveStatus = false;
        }
        return str;
    }

    public String getGraphHp() {
        String str = new String();
        for (int i = 0; i < 12; i++) {
            if (i == 0) {
                str += "[";
            } else if (i == 11) {
                str += "]";
            } else if (i < 1 + 10 * this.hp / this.startHp) {
                str += "=";
            } else {
                str += " ";
            }
        }
        return str;
    }
}
