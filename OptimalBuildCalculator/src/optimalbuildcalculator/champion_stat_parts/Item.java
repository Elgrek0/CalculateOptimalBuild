/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimalbuildcalculator.champion_stat_parts;

import optimalbuildcalculator.errors.NotEnoughGoldError;
import optimalbuildcalculator.errors.CouldntBuyError;
import optimalbuildcalculator.errors.InventoryFullError;
import java.util.LinkedList;
import optimalbuildcalculator.passives.Passive;

/**
 *
 * @author Paris
 */
public class Item {

    public final String name;
    public final Stats item_stats;
    public final Passive item_passive;
    public final int item_cost;
    public final LinkedList<Item> components;

    public Item(String name, Stats item_stats, Passive item_passive, int item_cost, LinkedList<Item> components) {
        this.name = name;
        this.item_stats = item_stats;
        this.item_passive = item_passive;
        this.item_cost = item_cost;
        this.components = components;
    }

    ItemBuild make_test_ItemBuild(ItemBuild items) throws NotEnoughGoldError, InventoryFullError {
        ItemBuild itemscopy = new ItemBuild();

        for (int i = 0; i < items.items.size(); i++) {//copy old inventory
            itemscopy.items.push(items.items.get(i));
        }

        int costcopy = item_cost;
        for (int i = 0; i < components.size(); i++) {//if components match use them up first and reduce the cost
            if (itemscopy.items.contains(components.get(i))) {
                costcopy -= components.get(i).item_cost;
                itemscopy.items.remove(components.get(i));
            }
        }

        if (itemscopy.items.size() < 6) {
            itemscopy.items.add(this);
            if (costcopy <= items.gold) {
                itemscopy.gold = items.gold - costcopy;
                return (itemscopy);
            } else {
                throw new NotEnoughGoldError();
            }
        } else {
            throw new InventoryFullError();

        }
    }
}
