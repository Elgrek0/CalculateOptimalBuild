/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimalbuildcalculator.damagecalculator;

/**
 *
 * @author Paris
 */
public class Result {

    final float time_to_kill;
    final float burst_damage;
    final float sustained_dps;

    public Result(float time_to_kill, float burst_damage, float sustained_dps) {
        this.time_to_kill = time_to_kill;
        this.burst_damage = burst_damage;
        this.sustained_dps = sustained_dps;
    }

    public void print() {
        System.out.println("Time taken to kill : " + time_to_kill);
        System.out.println("Burst damage : " + burst_damage);
        System.out.println("Sustained dps : " + sustained_dps);
    }

}
