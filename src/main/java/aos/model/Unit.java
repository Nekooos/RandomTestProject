package aos.model;

import java.util.List;

public class Unit {
    private String name;
    private int unitSize;
    private List<Weapon> weapons;
    private DamageTable damageTable;
    private int move;
    private int wounds;
    private int save;
    private int bravery;
    private List<String> keywords;
    private int points;

    public Unit() {

    }

    public Unit(String name, int unitSize, List<Weapon> weapons, DamageTable damageTable, int move, int wounds, int save, int bravery, List<String> keywords, int points) {
        this.name = name;
        this.unitSize = unitSize;
        this.weapons = weapons;
        this.damageTable = damageTable;
        this.move = move;
        this.wounds = wounds;
        this.save = save;
        this.bravery = bravery;
        this.keywords = keywords;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnitSize() {
        return unitSize;
    }

    public void setUnitSize(int unitSize) {
        this.unitSize = unitSize;
    }

    public DamageTable getDamageTable() {
        return damageTable;
    }

    public void setDamageTable(DamageTable damageTable) {
        this.damageTable = damageTable;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public int getWounds() {
        return wounds;
    }

    public void setWounds(int wounds) {
        this.wounds = wounds;
    }

    public int getSave() {
        return save;
    }

    public void setSave(int save) {
        this.save = save;
    }

    public int getBravery() {
        return bravery;
    }

    public void setBravery(int bravery) {
        this.bravery = bravery;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
