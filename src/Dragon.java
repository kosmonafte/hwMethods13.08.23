public class Dragon extends Unit{
    Dragon() {
        this.hp = 500;
        this.damage = 55;
    }
    Dragon(int hp) {
        this.hp = hp;
        this.damage = 55;
    }
    Dragon(int hp, int damage) {
        super(hp, damage);
    }
    @Override
    public String protect(int damage) {
        String str = new String();
        if (damage < this.hp) {
            this.hp -= damage;
            str = String.format("Дракон получает %d урона, у него остается %d hp %s", damage, this.hp, getGraphHp());
        } else {
            str = String.format("Дракон получает %d урона, и погибает", this.hp);
            this.hp = 0;
            liveStatus = false;
        }
        return str;
    }
}
