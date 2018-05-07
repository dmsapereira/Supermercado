package Handling;

import Iterable.*;

public class CartClass implements Cart {
    private String name;
    private int volume;
    private ArrayClass<Item> items;

    public CartClass(String name, int volume) {
        this.name = name;
        this.volume = volume;
    }

    @Override
    public void addItem(String itemName, int itemCost, int volume) {
        items.insertLast(new ItemClass(itemName, itemCost, volume));
    }

    @Override
    public int getVolumeLeft() {
        int stacker = 0;
        Iterator<Item> itera = items.iterator();
        while (itera.hasNext()) {
            stacker += itera.next().getCost();
        }
        return stacker;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getVolume() {
        return this.volume;
    }


}
