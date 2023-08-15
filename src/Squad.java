public class Squad {
    private Spearman[] sqd;
    private boolean liveStatus;
    Squad(){
        sqd = new Spearman[]{new Spearman(), new Spearman()};
        liveStatus = true;
    }
    Squad(int numbers){
        sqd = new Spearman[numbers];
        for (int i = 0; i < this.sqd.length; i++) {
            sqd[i] = new Spearman();
        }
        liveStatus = true;
    }
    Squad(int numbers, int hp, int damage){
        sqd = new Spearman[numbers];
        for (int i = 0; i < this.sqd.length; i++) {
            sqd[i] = new Spearman(hp, damage);
        }
        liveStatus = true;
    }

    public boolean getLiveStatus() {
        boolean status = this.liveStatus;
        return status;
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
            if (this.sqd.length == 0) {
                liveStatus = false;
            }
        } else {
            if (this.sqd.length == 1) {
                Spearman[] tmp = new Spearman[this.sqd.length - 1];
                System.arraycopy(this.sqd, 0, tmp, 0, this.sqd.length - 1);
                this.sqd = tmp;
                liveStatus = false;
            } else {
                damage -= this.sqd[this.sqd.length - 1].hp;
                Spearman[] tmp = new Spearman[this.sqd.length - 1];
                System.arraycopy(this.sqd, 0, tmp, 0, this.sqd.length - 1);
                this.sqd = tmp;
                this.protect(damage);
            }
        }
    }
    public String protectV2(int damage) {
        String str = new String();
        if (damage < this.sqd[this.sqd.length - 1].hp) {
            str = String.format("Копейщик №%d, получает %d урона, но остается жив!\n", this.sqd.length, damage);
            this.sqd[this.sqd.length - 1].hp -= damage;
        } else if (damage == this.sqd[this.sqd.length - 1].hp) {
            str += String.format("Копейщик №%d, получает %d урона, и погибает!\n", this.sqd.length, damage);
            Spearman[] tmp = new Spearman[this.sqd.length - 1];
            System.arraycopy(this.sqd, 0, tmp, 0, this.sqd.length - 1);
            this.sqd = tmp;
            if (this.sqd.length == 0) {
                liveStatus = false;
            }
        } else {
            if (this.sqd.length == 1) {
                str += String.format("Копейщик №%d, получает %d урона, и погибает!\n",
                        this.sqd.length, this.sqd[this.sqd.length - 1].hp);
                Spearman[] tmp = new Spearman[this.sqd.length - 1];
                System.arraycopy(this.sqd, 0, tmp, 0, this.sqd.length - 1);
                this.sqd = tmp;
                liveStatus = false;
                str += String.format("Отряд полностью уничтожен!\n");
            } else {
                str += String.format("Копейщик №%d, получает %d урона, и погибает!\n",
                        this.sqd.length, this.sqd[this.sqd.length - 1].hp);
                damage -= this.sqd[this.sqd.length - 1].hp;
                Spearman[] tmp = new Spearman[this.sqd.length - 1];
                System.arraycopy(this.sqd, 0, tmp, 0, this.sqd.length - 1);
                this.sqd = tmp;
                str += this.protectV2(damage);
            }
        }
        return str;
    }
    public String showSquadHp() {
        String str = new String();
        if (this.sqd.length == 0) {
            str = "Отряд погиб";
        } else {
            for (int i = 0; i < this.sqd.length; i++) {
                str += String.format("Копейщик №%2d. Количество HP - %3d - %s\n", i+1, this.sqd[i].hp, this.sqd[i].getGraphHp());
            }
        }
        return str;
    }
}
