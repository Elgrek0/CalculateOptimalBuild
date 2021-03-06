/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimalbuildcalculator.champion_stat_parts;

import optimalbuildcalculator.exceptions.NoItemFoundException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import optimalbuildcalculator.exceptions.InventoryFullException;
import optimalbuildcalculator.exceptions.NotEnoughGoldException;

/**
 *
 * @author Paris
 */
public class ItemBuild {

    public LinkedList<Item> items = new LinkedList<Item>();
    public Stats total_item_stats;
    public int gold;
    private int pointer = 0;

    public ItemBuild() {
        total_item_stats = new Stats();
    }

    // get the next item in the list and return a temporary itembuild
    public ItemBuild getnextitem(int gold, LinkedList<Item> allitems) throws NoItemFoundException {
        this.gold = gold;
        while (pointer < allitems.size()) {

            try {
                ItemBuild i = allitems.get(pointer).make_test_ItemBuild(this);
                return (i);
            } catch (NotEnoughGoldException | InventoryFullException ex) {
                pointer++;
            }

        }
        pointer = 0;
        throw new NoItemFoundException();

    }

    public void calculatestats() {// sum the stats of all items
        Stats sumstats = new Stats();
        for (Item i : items) {
            sumstats = sumstats.add(i.item_stats);
        }
        total_item_stats = sumstats;
    }

    public void additem(Item item) throws InventoryFullException {
        if (items.size() < 6) {
            items.add(item);
            calculatestats();
        } else {
            throw new InventoryFullException();
        }

    }

    public void removeitem(Item item) {
        items.remove(item);
        calculatestats();

    }
}
