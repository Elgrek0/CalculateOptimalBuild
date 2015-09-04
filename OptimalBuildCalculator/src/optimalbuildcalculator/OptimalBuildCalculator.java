/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimalbuildcalculator;

import optimalbuildcalculator.champion_stat_parts.Stats;
import optimalbuildcalculator.damagecalculator.DamageCalculator;

/**
 *
 * @author Paris
 */
public class OptimalBuildCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stats dravenstats = new Stats();
        dravenstats.setstat(Stats.attack_damage, 50.38);
        dravenstats.setstat(Stats.attack_damage_per_level, 3.5);

        dravenstats.setstat(Stats.attack_speed, 0.679);
        dravenstats.setstat(Stats.attack_speed_per_level, 0.027 * 0.679);

        Champion draven = new Champion("Draven", dravenstats, null, null);

        Stats shyvanastats = new Stats();

        shyvanastats.setstat(Stats.health, 594.6);
        shyvanastats.setstat(Stats.health_per_level, 95);

        shyvanastats.setstat(Stats.armor, 27.628);
        shyvanastats.setstat(Stats.armor_per_level, 3.35);

        Champion shyvanna = new Champion("Shyvana", shyvanastats, null, null);

        DamageCalculator.calculate_auto_attack_damage(draven, shyvanna);
    }

}
