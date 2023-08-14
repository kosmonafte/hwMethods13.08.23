import javax.management.remote.SubjectDelegationPermission;

public class Spearman extends Unit{
    Spearman(){
        this.hp = 50;
        this.damage = 20;
    }
    Spearman(int hp) {
        this.hp = hp;
        this.damage = 15;
    }
    Spearman(int hp, int damage) {
        this.hp = hp;
        this.damage = damage;
    }
}
