package Handling;

import Iterable.*;

public class HandlerClass implements Handler {
    private ArrayClass<Cart> carts;
    private ArrayClass<Item> items;

    public HandlerClass() {
        this.carts = new ArrayClass<Cart>();
        this.items = new ArrayClass<Item>();
    }

    @Override
    public int addCart(String name, int volume) {
        int error = 0;
        if (searchCartIndex(name) != -1)
            error = 1;
        else
            carts.insertLast(new CartClass(name, volume));
        return error;
    }

    @Override
    public int addItem(String name, int cost, int volume) {
        int error = 0;
        if (searchItemIndex(name) != -1)
            error = 1;
        else
            items.insertLast(new ItemClass(name, cost, volume));

        return error;
    }

    private int searchCartIndex(String name) {
        int i = 0;
        Iterator<Cart> itera = carts.iterator();
        while (itera.hasNext()) {
            if (itera.next().getName().equals(name)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private int searchItemIndex(String name) {
        int i = 0;
        Iterator<Item> itera = items.iterator();
        while (itera.hasNext()) {
            if (itera.next().getName().equals(name)) {
                return i;
            }
            i++;
        }
        return -1;
    }

}
