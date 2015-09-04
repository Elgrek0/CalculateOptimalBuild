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
public class ItemStats extends Stats {

    public ItemStats(double health, double mana, double attack_damage, double ability_power, double attack_speed, double critical_chance, double armor, double magic_resistance, double cooldown_reduction) {
        super();
        stats[this.health] = (float) health;
        stats[this.mana] = (float) mana;
        stats[this.ability_power] = (float) ability_power;
        stats[this.attack_damage] = (float) attack_damage;
        stats[this.attack_speed] = (float) attack_speed;
        stats[this.critical_chance] = (float) critical_chance;
        stats[this.armor] = (float) armor;
        stats[this.magic_resistance] = (float) magic_resistance;
        stats[this.cooldown_reduction] = (float) cooldown_reduction;

    }
}
