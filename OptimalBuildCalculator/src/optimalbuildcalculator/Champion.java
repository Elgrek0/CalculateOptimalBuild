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

    final public String name;
    public ItemBuild items;
    public MasteryBuild masteries;
    public RuneBuild runes;
    final public Stats champion_stats;
    final public LinkedList<Skill> skills;
    final public Passive champion_passive;

    public Champion(String name, Stats champion_stats, LinkedList<Skill> skills, Passive champion_passive) {
        this.name = name;
        this.champion_stats = champion_stats;
        this.skills = skills;
        this.champion_passive = champion_passive;
    }

    public float get_total_stat(int stat, int level) {
        float sumstat = 0;
        if (runes != null) {
            sumstat += runes.total_rune_stats.getstat(stat);
            sumstat += runes.total_rune_stats.getstat(stat + 1) * level;
        }
        if (masteries != null) {
            sumstat += masteries.total_mastery_stats.getstat(stat);
            sumstat += masteries.total_mastery_stats.getstat(stat + 1) * level;
        }
        if (items != null) {
            sumstat += items.total_item_stats.getstat(stat);
            sumstat += items.total_item_stats.getstat(stat + 1) * level;
        }
        sumstat += Stats.growth(champion_stats.getstat(stat), champion_stats.getstat(stat + 1), level);
        return (sumstat);
    }

    public void print() {
        System.out.println("name : " + name);
        champion_stats.print_champion_stats();
    }
}
