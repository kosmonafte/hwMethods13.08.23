public class Squad {
    private Spearman[] sqd;
    Squad(){
        sqd = new Spearman[]{new Spearman(), new Spearman()};
    }
    Squad(int numbers){
        sqd = new Spearman[numbers];
        for (int i = 0; i < this.sqd.length; i++) {
            sqd[i] = new Spearman();
        }
    }
    Squad(int numbers, int hp, int damage){
        sqd = new Spearman[numbers];
        for (int i = 0; i < this.sqd.length; i++) {
            sqd[i] = new Spearman(hp, damage);
        }
    }
    public int attack() {
        int resAtk = 0;
        for (int i = 0; i < this.sqd.length; i++) {
            resAtk += this.sqd[i].damage;
        }
        return resAtk;
    }
    public void protect(int damage) {
        if (damage < this.sqd[this.sqd.length - 1].hp) {
            this.sqd[this.sqd.length - 1].hp -= damage;
        } else if (damage == this.sqd[this.sqd.length - 1].hp) {
            Spearman[] tmp = new Spearman[this.sqd.length - 1];
            System.arraycopy(this.sqd, 0, tmp, 0, this.sqd.length - 1);
            this.sqd = tmp;
        } else {
            if (this.sqd.length == 1) {
                Spearman[] tmp = new Spearman[this.sqd.length - 1];
                System.arraycopy(this.sqd, 0, tmp, 0, this.sqd.length - 1);
                this.sqd = tmp;
            } else {
                damage -= this.sqd[this.sqd.length - 1].hp;
                Spearman[] tmp = new Spearman[this.sqd.length - 1];
                System.arraycopy(this.sqd, 0, tmp, 0, this.sqd.length - 1);
                this.sqd = tmp;
                this.protect(damage);
            }
        }
    }
    public String showSquadHp() {
        String str = new String();
        if (this.sqd.length == 0) {
            str = "Отряд погиб";
        } else {
            for (int i = 0; i < this.sqd.length; i++) {
                str += String.format("Копейщик №%2d. Количество HP - %2d\n", i+1, this.sqd[i].hp);
            }
        }
        return str;
    }
}
