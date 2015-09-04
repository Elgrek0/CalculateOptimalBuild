/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimalbuildcalculator.champion_stat_parts;

import java.util.logging.Level;
import java.util.logging.Logger;
import optimalbuildcalculator.exceptions.WrongStatsNumberException;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author Paris
 */
public class Stats {

    static {
        int i = 0;
        health = i++;
        health_per_level = i++;
        mana = i++;
        mana_per_level = i++;
        ability_power = i++;
        ability_power_per_level = i++;
        attack_damage = i++;
        attack_damage_per_level = i++;
        attack_speed = i++;
        attack_speed_per_level = i++;
        critical_chance = i++;
        critical_chance_per_level = i++;
        cooldown_reduction = i++;
        cooldown_reduction_per_level = i++;
        armor = i++;
        armor_per_level = i++;
        magic_resistance = i++;
        magic_resistance_per_level = i++;
        statcount = i;
    }
    public static final int health;
    public static final int health_per_level;
    public static final int mana;
    public static final int mana_per_level;
    public static final int ability_power;
    public static final int ability_power_per_level;
    public static final int attack_damage;
    public static final int attack_damage_per_level;
    public static final int attack_speed;
    public static final int attack_speed_per_level;
    public static final int critical_chance;
    public static final int critical_chance_per_level;
    public static final int cooldown_reduction;
    public static final int cooldown_reduction_per_level;
    public static final int armor;
    public static final int armor_per_level;
    public static final int magic_resistance;
    public static final int magic_resistance_per_level;

    public static final int statcount;

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

    public void setstat(int stat, double value) {
        stats[stat] = (float) value;
    }

    public static float growth(float base, float growth, int level) {

        //System.out.println("base : " + base);
        //System.out.println("growth : " + growth);
        return (float) (base + growth * (7.0 / 400 * (level * level - 1) + 267.0 / 400 * (level - 1)));
    }

    public void print_champion_stats() {
        System.out.println("hp : " + stats[health]);
        System.out.println("hp/lv : " + stats[health_per_level]);
        System.out.println("mana : " + stats[mana]);
        System.out.println("mana/lv : " + stats[mana_per_level]);
        System.out.println("ad : " + stats[attack_damage]);
        System.out.println("ad/lv : " + stats[attack_damage_per_level]);
        System.out.println("armor : " + stats[armor]);
        System.out.println("armor/lv : " + stats[armor_per_level]);
    }

    void print_item_stats() {
        print(health, "hp");
        print(mana, "mp");
        print(attack_damage, "ad");
        print(attack_speed, "as");
        print(critical_chance, "crit");
        print(ability_power, "ap");
        print(armor, "armor");
        print(magic_resistance, "mr");
        print(cooldown_reduction, "cdr");
    }

    void print(int value, String name) {
        if (stats[value] != 0) {
            System.out.println(name + " : " + stats[value]);
        }
    }

}
