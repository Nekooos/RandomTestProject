package aos.model;

public class Weapon {
    private String name;
    private int range;
    private int attacks;
    private int toHit;
    private int toWound;
    private int rend;
    private int damage;

    public Weapon() {

    }

    public Weapon(int range, int attacks, int toHit, int toWound, int rend, int damage) {
        this.range = range;
        this.attacks = attacks;
        this.toHit = toHit;
        this.toWound = toWound;
        this.rend = rend;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getAttacks() {
        return attacks;
    }

    public void setAttacks(int attacks) {
        this.attacks = attacks;
    }

    public int getToHit() {
        return toHit;
    }

    public void setToHit(int toHit) {
        this.toHit = toHit;
    }

    public int getToWound() {
        return toWound;
    }

    public void setToWound(int toWound) {
        this.toWound = toWound;
    }

    public int getRend() {
        return rend;
    }

    public void setRend(int rend) {
        this.rend = rend;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
