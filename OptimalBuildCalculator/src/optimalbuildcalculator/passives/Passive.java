/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimalbuildcalculator.passives;

import optimalbuildcalculator.Champion;

/**
 *
 * @author Paris
 */
public abstract class Passive {
   public abstract float damage(Champion attacker,Champion defender);
}
