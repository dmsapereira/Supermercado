package Handling;

import Iterable.*;

public class HandlerClass implements Handler {
    /**
     * Array de todos os carrinhos
     */
    private Array<Cart> carts;
    /**
     * Array de todos os artigos
     */
    private Array<Item> items;

    /**
     * Construtor
     */
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

    @Override
    public int depositItem(String itemName, String cartName) {
        int cartIndex = searchCartIndex(cartName);
        int itemIndex = searchItemIndex(itemName);
        int error = 0;
        if (cartIndex == -1)
            error = 1;
        else if (itemIndex == -1)
            error = 2;
        else if ((carts.get(cartIndex).getVolume() - items.get(itemIndex).getVolume()) < 0)
            error = 3;
        else
            carts.get(cartIndex).addItem(items.get(itemIndex));
        return error;
    }

    @Override
    public int removeItem(String itemName, String cartName) {
        int cartIndex = searchCartIndex(cartName);
        int error = 0;
        if (cartIndex == -1)
            error = 1;
        else if (carts.get(cartIndex).getItemIndex(itemName) == -1)
            error = 2;
        else
            carts.get(cartIndex).removeItem(itemName);
        return error;
    }

    @Override
    public Iterator<Item> itemIterator(String cartName) {
        if (searchCartIndex(cartName) == -1)
            return null;
        else
            return carts.get(searchCartIndex(cartName)).getItems();
    }

    @Override
    public int pay(String cartName) {
        int error;
        int cartIndex = carts.getIndex(cartName);
        if (cartIndex == -1)
            error = -1;
        else
            error = carts.get(cartIndex).pay();
        return error;

    }

    /**
     * Devolve o indice do carrinho com o nome indicado
     *
     * @param name nome do carrinho a procurar
     * @return indice do carrinho. -1 se nao existe
     */
    private int searchCartIndex(String name) {
        return carts.getIndex(name);
    }

    /**
     * Devolve o indice do artigo com o nome indicado
     *
     * @param name nome do artigo a procurar
     * @return indice do artigo. -1 se nao existe
     */
    private int searchItemIndex(String name) {
        return items.getIndex(name);
    }

}
