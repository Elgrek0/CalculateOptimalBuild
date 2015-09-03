/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimalbuildcalculator.champion_stat_parts;

import optimalbuildcalculator.exceptions.WrongStatsNumberException;

/**
 *
 * @author Paris
 */
public class ChampionStats extends Stats {

    public ChampionStats(double health, double health_per_level, double mana, double mana_per_level, double attack_damage, double attack_damage_per_level, double attack_speed, double attack_speed_per_level, double armor, double armor_per_level, double magic_resistance, double magic_resistance_per_level) {
        super();
        stats[this.health] = (float) health;
        stats[this.health_per_level] = (float) health_per_level;
        stats[this.mana] = (float) mana;
        stats[this.mana_per_level] = (float) mana_per_level;
        stats[this.attack_damage] = (float) attack_damage;
        stats[this.attack_damage_per_level] = (float) attack_damage_per_level;
        stats[this.attack_speed] = (float) attack_speed;
        stats[this.attack_speed_per_level] = (float) attack_speed_per_level;
        stats[this.armor] = (float) armor;
        stats[this.armor_per_level] = (float) armor_per_level;
        stats[this.magic_resistance] = (float) magic_resistance;
        stats[this.magic_resistance_per_level] = (float) magic_resistance_per_level;

    }

}
