/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimalbuildcalculator;

import java.util.LinkedList;
import optimalbuildcalculator.champion_stat_parts.ItemBuild;
import optimalbuildcalculator.champion_stat_parts.MasteryBuild;
import optimalbuildcalculator.champion_stat_parts.RuneBuild;
import optimalbuildcalculator.champion_skills.Skill;
import optimalbuildcalculator.champion_stat_parts.Stats;
import optimalbuildcalculator.passives.Passive;

/**
 *
 * @author Paris
 */
public class Champion {

    public ItemBuild items;
    public MasteryBuild masteries;
    public RuneBuild runes;
    final public Stats champion_stats;
    final public LinkedList<Skill> skills;
    final public Passive champion_passive;

    public Champion(Stats champion_stats, LinkedList<Skill> skills, Passive champion_passive) {
        this.champion_stats = champion_stats;
        this.skills = skills;
        this.champion_passive = champion_passive;
    }

    public static final int health = 0;
    public static final int attack_damage = 2;
    public static final int attack_speed = 4;
    public static final int critical_chance = 6;
    public static final int cooldown_reduction = 8;
    public static final int armor = 10;
    public static final int magic_resistance = 12;

    public float get_total_stat(int stat, int level) {
        float sumad = 0;
        if (runes != null) {
            sumad += runes.total_rune_stats.getstat(stat);
            sumad += runes.total_rune_stats.getstat(stat + 1) * level;
        }
        if (masteries != null) {
            sumad += masteries.total_mastery_stats.getstat(stat);
            sumad += masteries.total_mastery_stats.getstat(stat + 1) * level;
        }
        if (items != null) {
            sumad += items.total_item_stats.getstat(stat);
            sumad += items.total_item_stats.getstat(stat + 1) * level;
        }
        sumad += Stats.growth(champion_stats.getstat(stat), champion_stats.getstat(stat + 1), level);
        return (sumad);
    }

}
