/*
 * This software is ment to be used only by skilled players.
 * It wont work for noobs, such as these who main Karma or so.
 */
package get.rekt.noob;

import get.rekt.noob.storage.DataCenter;
import get.rekt.noob.storage.DataManagementMode;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import optimalbuildcalculator.Champion;
import optimalbuildcalculator.OptimalBuildCalculator;
import optimalbuildcalculator.champion_stat_parts.ChampionStats;
import optimalbuildcalculator.champion_stat_parts.Item;
import optimalbuildcalculator.champion_stat_parts.ItemStats;
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
            LinkedList<Item> allitems = new LinkedList<Item>();
            LinkedList<Champion> allchampions = new LinkedList<Champion>();
            for (dto.Static.Champion c : DataCenter.getInstance().getChampionList().getData().values()) {
                dto.Static.Stats cs = c.getStats();

                allchampions.add(new Champion(c.getName(), new ChampionStats(cs.getHp(), cs.getHpPerLevel(), cs.getMp(), cs.getMpPerLevel(), cs.getAttackDamage(),
                        cs.getAttackDamagePerLevel(), cs.getAttackSpeedPerLevel(), cs.getAttackSpeedOffset(), cs.getArmor(), cs.getArmorPerLevel(), cs.getSpellBlock(), cs.getSpellBlockPerLevel()),
                        null, null));

                allchampions.getLast().print();
                System.out.println("");
            }

            for (dto.Static.Item i : DataCenter.getInstance().getItemList().getData().values()) {
                dto.Static.BasicDataStats is = i.getStats();

                allitems.add(new Item(i.getName(), new ItemStats(is.getFlatHPPoolMod(), is.getFlatMPPoolMod(), is.getFlatPhysicalDamageMod(), is.getFlatMagicDamageMod(),
                        is.getPercentAttackSpeedMod(), is.getFlatCritChanceMod(),
                        is.getFlatArmorMod(), is.getFlatSpellBlockMod(), is.getrPercentCooldownMod()),
                        null, i.getGold().getTotal(), null));

                allitems.getLast().print();
                System.out.println("");
            }
            System.exit(0);

        } catch (Exception ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
