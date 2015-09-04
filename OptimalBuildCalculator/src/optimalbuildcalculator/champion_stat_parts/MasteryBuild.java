/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimalbuildcalculator.champion_stat_parts;

import java.util.LinkedList;

/**
 *
 * @author Paris
 */
public class MasteryBuild {

    public LinkedList<Mastery> masteries = new LinkedList< Mastery>();
    public Stats total_mastery_stats;

    public MasteryBuild() {
        total_mastery_stats = new Stats();
    }

    public void addmastery(Mastery m) {
        if (masteries.size() < 30) {
            masteries.add(m);
            
        }
    }

    public void calculatestats() {// sum the stats of all items
        Stats sumstats = new Stats();
        for (Mastery m : masteries) {
            sumstats = sumstats.add(m.mastery_stats);
        }
        total_mastery_stats = sumstats;
    }
}
