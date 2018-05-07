package Handling;

import Iterable.*;

public class CartClass implements Cart, Named {
    /**
     * nome do carrinho
     */
    private String name;

    /**
     * volume-> Volume inicial
     * volumeLeft-> Volume restante que vai sendo decrementado a medida que se adiciona artigos
     */
    private int volume, volumeLeft;

    /**
     * Array de artigos que foram depositados no carrinho
     */
    private Array<Item> items;

    /**
     * Construtor
     * @param name nome do carrinho
     * @param volume volume do carrinho
     */
    public CartClass(String name, int volume) {
        items = new ArrayClass<Item>();
        this.name = name;
        this.volume = volume;
        this.volumeLeft = volume;
    }

    @Override
    public void addItem(Item item) {
        items.insertLast(item);
        this.volumeLeft -= item.getVolume();
    }

    @Override
    public void removeItem(String itemName) {
        int itemIndex = getItemIndex(itemName);
        volumeLeft += items.get(itemIndex).getVolume();
        items.removeAt(itemIndex);
    }

    @Override
    public Iterator<Item> getItems() {
        return items.iterator();
    }

    @Override
    public int getItemIndex(String name) {
        return items.getIndex(name);
    }


    @Override
    public int pay() {
        int stacker = 0;
        Iterator<Item> itera = getItems();
        while (itera.hasNext()) {
            stacker += itera.next().getCost();
        }
        items = new ArrayClass<Item>();
        volumeLeft = volume;
        return stacker;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getVolume() {
        return volumeLeft;
    }

}
