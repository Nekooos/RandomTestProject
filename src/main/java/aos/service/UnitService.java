package aos.service;

import aos.model.Unit;

import java.util.stream.Collectors;

public class UnitService {
    private final int dice = 6;

    public double calculateDamageOutput(final Unit unit) {
        return unit.getWeapons().stream()
                .map(weapon -> unit.getUnitSize() * weapon.getAttacks() * ((double)weapon.getToHit() / dice) * ((double)weapon.getToWound() / dice))
                .collect(Collectors.summarizingDouble(Double::doubleValue)).getSum();
    }

    public int calculatePoints(final Unit unit) {
        return unit.getPoints() * unit.getUnitSize();
    }
}
