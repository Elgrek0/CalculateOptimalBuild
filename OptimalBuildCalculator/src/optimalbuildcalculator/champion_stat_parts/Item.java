/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimalbuildcalculator.champion_stat_parts;

import optimalbuildcalculator.exceptions.NotEnoughGoldException;
import optimalbuildcalculator.exceptions.CouldntBuyException;
import optimalbuildcalculator.exceptions.InventoryFullException;
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
    public final double item_value;
    public final LinkedList<Item> components;

    public static double armorcost = 300.0 / 15;
    public static double mrcost = 450.0 / 25;
    public static double apcost = 435.0 / 20;
    public static double adcost = 360.0 / 10;
    public static double ascost = 450.0 / 0.15;
    public static double critcost = 400.0 / 0.08;
    public static double hpscost = 400.0 / 150;

    public Item(String name, Stats item_stats, Passive item_passive, int item_cost, LinkedList<Item> components) {
        this.name = name;
        this.item_stats = item_stats;
        this.item_passive = item_passive;
        this.item_cost = item_cost;
        this.components = components;
        item_value = sum_item_value();
    }

    ItemBuild make_test_ItemBuild(ItemBuild itembuild) throws NotEnoughGoldException, InventoryFullException {
        ItemBuild itemscopy = new ItemBuild();
        if (itembuild.items.size() > 0) {
            for (int i = 0; i < itembuild.items.size(); i++) {//copy old inventory
                itemscopy.items.add(itembuild.items.get(i));
            }
        }

        int costcopy = item_cost;
        if (components != null) {
            for (int i = 0; i < components.size(); i++) {//if components match use them up first and reduce the cost
                if (itemscopy.items.contains(components.get(i))) {
                    costcopy -= components.get(i).item_cost;
                    itemscopy.items.remove(components.get(i));
                }
            }
        }

        if (itemscopy.items.size() < 6) {
            itemscopy.items.add(this);
            if (costcopy <= itembuild.gold) {
                itemscopy.gold = itembuild.gold - costcopy;
                return (itemscopy);
            } else {
                throw new NotEnoughGoldException();
            }
        } else {
            throw new InventoryFullException();

        }
    }

    public void print() {
        System.out.println("name : " + name);
        System.out.println("cost : " + item_cost);
        item_stats.print_item_stats();
        System.out.println("efficiency : " + item_value / item_cost * 100 + " %");
    }

    private double sum_item_value() {
        double sum = 0;
        sum += item_stats.getstat(Stats.health) * hpscost;
        sum += item_stats.getstat(Stats.ability_power) * apcost;
        sum += item_stats.getstat(Stats.attack_damage) * adcost;
        sum += item_stats.getstat(Stats.attack_speed) * ascost;
        sum += item_stats.getstat(Stats.critical_chance) * critcost;
        sum += item_stats.getstat(Stats.armor) * armorcost;
        sum += item_stats.getstat(Stats.magic_resistance) * mrcost;
        return (sum);
    }
}
