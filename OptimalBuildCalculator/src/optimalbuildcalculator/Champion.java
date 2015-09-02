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

}
