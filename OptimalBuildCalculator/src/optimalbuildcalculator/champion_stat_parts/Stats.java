/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimalbuildcalculator.champion_stat_parts;

import java.util.logging.Level;
import java.util.logging.Logger;
import optimalbuildcalculator.exceptions.WrongStatsNumberException;

/**
 *
 * @author Paris
 */
public class Stats {

    public static final int health = 0;
    public static final int health_per_level = 1;
    public static final int attack_damage = 2;
    public static final int attack_damage_per_level = 3;
    public static final int attack_speed = 4;
    public static final int attack_speed_per_level = 5;
    public static final int critical_chance = 6;
    public static final int critical_chance_per_level = 7;
    public static final int cooldown_reduction = 8;
    public static final int cooldown_reduction_per_level = 9;
    public static final int armor = 10;
    public static final int armor_per_level = 11;
    public static final int magic_resistance = 12;
    public static final int magic_resistance_per_level = 13;

    public static final int statcount = 14;

    float[] stats;

    public Stats(float[] stats) throws WrongStatsNumberException {
        if (stats.length != statcount) {
            throw new WrongStatsNumberException();
        }
    }

    public Stats() {
        stats = new float[statcount];
        for (int i = 0; i < statcount; i++) {
            stats[i] = 0;
        }
    }

    public Stats add(Stats s) {
        float[] finalstats = new float[statcount];

        for (int i = 0; i < statcount; i++) {
            finalstats[i] = stats[i] + s.stats[i];
        }
        try {
            return (new Stats(finalstats));
        } catch (WrongStatsNumberException ex) {
            System.out.println("shouldt happen");
            System.exit(-1);
            return (null);
        }

    }

    public Stats subtract(Stats s) {
        float[] finalstats = new float[statcount];

        for (int i = 0; i < statcount; i++) {
            finalstats[i] = stats[i] - s.stats[i];
        }
        try {
            return (new Stats(finalstats));
        } catch (WrongStatsNumberException ex) {
            System.out.println("shouldt happen");
            System.exit(-1);
            return (null);
        }
    }

    public float getstat(int stat) {
        return (stats[stat]);
    }

    public void setstat(int stat, float value) {
        stats[stat] = value;
    }

    public static float growth(float base, float growth, int level) {
        return (float) (base + growth * (7.0 / 400 * (level * level - 1) + 267.0 / 400 * (level - 1)));
    }
}
