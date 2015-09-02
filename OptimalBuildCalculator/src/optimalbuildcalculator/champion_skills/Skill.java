/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimalbuildcalculator.champion_skills;

import java.util.LinkedList;
import optimalbuildcalculator.passives.Passive;

/**
 *
 * @author Paris
 */
public class Skill {

    public final LinkedList<Float> base_ad_damage;
    public final LinkedList<Float> base_ad_ratio;
    public final LinkedList<Float> bonus_ad_ratio;

    public final LinkedList<Float> base_ap_damage;
    public final LinkedList<Float> bonus_ap_ratio;

    public final LinkedList<Float> cooldown;

    public final LinkedList<Passive> passives_onuse;
    public final LinkedList<Passive> passives_permanent;

    public Skill(LinkedList<Float> base_ad_damage, LinkedList<Float> base_ad_ratio, LinkedList<Float> bonus_ad_ratio, LinkedList<Float> base_ap_damage, LinkedList<Float> bonus_ap_ratio, LinkedList<Float> cooldown, LinkedList<Passive> passives_onuse, LinkedList<Passive> passives_permanent) {
        this.base_ad_damage = base_ad_damage;
        this.base_ad_ratio = base_ad_ratio;
        this.bonus_ad_ratio = bonus_ad_ratio;
        this.base_ap_damage = base_ap_damage;
        this.bonus_ap_ratio = bonus_ap_ratio;
        this.cooldown = cooldown;
        this.passives_onuse = passives_onuse;
        this.passives_permanent = passives_permanent;
    }

}
