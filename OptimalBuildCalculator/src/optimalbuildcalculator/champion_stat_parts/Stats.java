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
public class Stats {
    float ad=0;
    float ad_level=0;
    float as=0;
    float as_level=0;
    float crit=0;
    float crit_level=0;
    float cdr=0;
    float cdr_level=0;
    float armor=0;
    float armor_level=0;
    float mr=0;
    float mr_level=0;
    
    public Stats add(Stats s){
        Stats toreturn=new Stats();
        toreturn.ad=ad+s.ad;
        toreturn.ad_level=ad_level+s.ad_level;
        toreturn.as=as+s.as;
        toreturn.as_level=as_level+s.as_level;
        toreturn.crit=crit+crit;
        toreturn.crit_level=crit_level+s.crit_level;
        toreturn.cdr=cdr+s.cdr;
        toreturn.cdr_level=cdr_level+s.cdr_level;
        toreturn.armor=armor+s.armor;
        toreturn.armor_level=armor_level+s.armor_level;
        toreturn.mr=mr+s.mr;
        toreturn.mr_level=mr_level+s.mr_level;
    return(toreturn);
    }
    public Stats subtract(Stats s){
        Stats toreturn=new Stats();
        toreturn.ad=ad-s.ad;
        toreturn.ad_level=ad_level-s.ad_level;
        toreturn.as=as-s.as;
        toreturn.as_level=as_level-s.as_level;
        toreturn.crit=crit-crit;
        toreturn.crit_level=crit_level-s.crit_level;
        toreturn.cdr=cdr-s.cdr;
        toreturn.cdr_level=cdr_level-s.cdr_level;
        toreturn.armor=armor-s.armor;
        toreturn.armor_level=armor_level-s.armor_level;
        toreturn.mr=mr-s.mr;
        toreturn.mr_level=mr_level-s.mr_level;
    return(toreturn);
    }
}
