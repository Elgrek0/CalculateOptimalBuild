/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimalbuildcalculator.champion_stat_parts;

/**
 *
 * @author Paris
 */
public class Rune {

    final int type;
    final String name;
    final Stats rune_stats;

    public Rune(int type, String name, Stats rune_stats) {
        this.type = type;
        this.name = name;
        this.rune_stats = rune_stats;
    }

}
