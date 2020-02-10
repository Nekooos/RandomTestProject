package aos.service;

import aos.model.Unit;
import aos.model.Weapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

public class UnitServiceTest {

    private UnitService unitService;
    private Unit unit;

    @BeforeEach
    public void setUp() {
        unitService = new UnitService();
        unit = buildUnit();
    }

    @Test
    public void calculateDamageTest() {
        double unitDamage = unitService.calculateDamageOutput(unit);
        System.out.println(unitDamage);
        //assertEquals(5, unitDamage);
    }

    @Test
    public void calculatePointsTest() {
        int unitPoints = unitService.calculatePoints(unit);
        Assertions.assertEquals(100, unitPoints);
    }

    private Unit buildUnit() {
        Unit unit = new Unit();
        unit.setName("Dryads");
        unit.setBravery(6);
        unit.setKeywords(Arrays.asList("order", "sylvaneth", "forest folk", "dryads"));
        unit.setMove(7);
        unit.setSave(5);
        unit.setUnitSize(10);
        unit.setWeapons(Collections.singletonList(buildWeapon()));
        unit.setWounds(1);
        unit.setPoints(10);
        return unit;
    }

    private Weapon buildWeapon() {
        Weapon weapon = new Weapon();
        weapon.setName("talons");
        weapon.setAttacks(2);
        weapon.setRange(2);
        weapon.setToHit(4);
        weapon.setToWound(4);
        weapon.setRend(0);
        weapon.setDamage(1);
        return weapon;
    }
}
