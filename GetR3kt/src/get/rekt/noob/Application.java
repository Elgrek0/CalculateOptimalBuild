/*
 * This software is ment to be used only by skilled players.
 * It wont work for noobs, such as these who main Karma or so.
 */
package get.rekt.noob;

import get.rekt.noob.storage.DataCenter;
import get.rekt.noob.storage.DataManagementMode;
import java.util.logging.Level;
import java.util.logging.Logger;
import optimalbuildcalculator.Champion;
import optimalbuildcalculator.champion_stat_parts.Stats;
import optimalbuildcalculator.damagecalculator.DamageCalculator;

/**
 *
 * @author Robert
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            while (!DataCenter.getInstance().isLoaded()) {
                if (!DataCenter.getInstance().isRunning()) {
                    DataCenter.getInstance().Start(DataManagementMode.DOWNLOAD_AND_LOAD);
                }
                Thread.sleep(100);
            }
            for (dto.Static.Champion c : DataCenter.getInstance().getChampionList().getData().values()) {
                System.out.println(c.getName()+" "+c.getSpells().get(0).getName());
                System.out.println(c.getSpells().get(0).getCost() + " " + c.getSpells().get(0).getResource());
                System.out.println("");
            }
            System.exit(0);

        } catch (Exception ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
