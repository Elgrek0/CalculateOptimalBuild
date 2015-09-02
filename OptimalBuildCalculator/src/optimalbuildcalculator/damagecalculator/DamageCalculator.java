/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimalbuildcalculator.damagecalculator;

import java.util.LinkedList;
import optimalbuildcalculator.Champion;

/**
 *
 * @author Paris
 */
public class DamageCalculator {

    static final boolean debug = true;

    public static LinkedList<Result> calculate_auto_attack_damage(Champion attacker, Champion defender) {
        LinkedList<Result> results = new LinkedList<>();

        for (int i = 1; i <= 18; i++) {
            results.add(calculate_auto_attack_damage(attacker, defender, i));
        }
        return (results);
    }

    public static Result calculate_auto_attack_damage(Champion attacker, Champion defender, int level) {

        if (debug) {
            System.out.println("------level " + level + " -------");
        }
        float enemyarmor = defender.get_total_stat(Champion.armor, level);
        float armor_damage_multiplier = (float) (100.0 / (100 + enemyarmor));
        float dps = attacker.get_total_stat(Champion.attack_speed, level)
                * attacker.get_total_stat(Champion.attack_damage, level)
                * armor_damage_multiplier
                * (1 + attacker.get_total_stat(Champion.critical_chance, level));
        float burst = attacker.get_total_stat(Champion.attack_damage, level);
        float time_to_kill = defender.get_total_stat(Champion.health, level) / dps;

        Result toreturn = new Result(time_to_kill, burst, dps);
        if (debug) {
            System.out.println("enemy hp " + defender.get_total_stat(Champion.health, level));
            System.out.println("enemy armor " + enemyarmor);
            toreturn.print();
        }

        return (toreturn);
    }
}
