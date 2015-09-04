/*
 * This software is ment to be used only by skilled players.
 * It wont work for noobs, such as these who main Karma or so.
 */
package get.rekt.noob;

import get.rekt.noob.storage.DataCenter;
import get.rekt.noob.storage.DataManagementMode;
import static java.util.Collections.list;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.UnaryOperator;
import java.util.logging.Level;
import java.util.logging.Logger;
import optimalbuildcalculator.Champion;
import optimalbuildcalculator.ChampionEditGui;
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
                if (i.getRequiredChampion() != null) {
                    continue;
                }
                dto.Static.BasicDataStats is = i.getStats();

                allitems.add(new Item(i.getName(), new ItemStats(is.getFlatHPPoolMod(), is.getFlatMPPoolMod(), is.getFlatPhysicalDamageMod(), is.getFlatMagicDamageMod(),
                        is.getPercentAttackSpeedMod(), is.getFlatCritChanceMod(),
                        is.getFlatArmorMod(), is.getFlatSpellBlockMod(), is.getrPercentCooldownMod()),
                        null, i.getGold().getTotal(), null));
            }

            allitems.replaceAll((Item t) -> {
                return ((t.item_value / t.item_cost) == 0 || t.item_cost == 0) ? null : t;
            });

            for (int i = 0; i < allitems.size(); i++) {
                allitems.remove(null);
            }

            allitems.sort((Item o1, Item o2) -> {
                if ((o1.item_value / o1.item_cost) > (o2.item_value / o2.item_cost)) {
                    return 1;
                }
                if ((o1.item_value / o1.item_cost) == (o2.item_value / o2.item_cost)) {
                    return 0;
                }
                return -1;
            });

            for (Iterator<Item> it = allitems.iterator(); it.hasNext();) {
                Item allitem = it.next();
                allitem.print();
                System.out.println("");
            }

            ChampionEditGui gui = new ChampionEditGui(allchampions.getLast());
            gui.setVisible(true);

        } catch (Exception ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
