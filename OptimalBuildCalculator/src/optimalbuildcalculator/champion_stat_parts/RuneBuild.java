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
public class RuneBuild {

    public LinkedList<Rune> runes = new LinkedList<Rune>();
    public Stats total_rune_stats;
    int reds = 0;
    int yellows = 0;
    int blues = 0;
    int purple = 0;

   public void addrune(Rune r) {
        if (r.type == 0) {
            if (reds < 9) {
                runes.add(r);
                reds++;
            }
        }
        if (r.type == 1) {
            if (yellows < 9) {
                runes.add(r);
                yellows++;
            }
        }
        if (r.type == 2) {
            if (blues < 9) {
                runes.add(r);
                blues++;
            }
        }
        if (r.type == 3) {
            if (blues < 3) {
                runes.add(r);
                purple++;
            }
        }
    }

    public void calculatestats() {// sum the stats of all items
        Stats sumstats = new Stats();
        for (Rune r : runes) {
            sumstats = sumstats.add(r.rune_stats);
        }
        total_rune_stats = sumstats;
    }
}
