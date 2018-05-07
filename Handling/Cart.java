package Handling;

import Iterable.Iterator;

public interface Cart {

    /**
     * Devolve o volume restante de um carrinho
     * @return volume restante do carrinho
     */
    int getVolume();

    /**
     * Adiciona um artigo ao carrinho
     * @param item artigo a adicionar
     * @pre: item!=null && volume-item.getVolume()>0
     */
    void addItem(Item item);

    /**
     * Remove um artigo do carrinho
     * @param itemName nome do artigo
     * @pre: itemName corresponde a um item
     */
    void removeItem(String itemName);

    /**
     * Devolve o iterador dos artigos
     * @return objeto Iterator do Array de artigos
     */
    Iterator<Item> getItems();

    /**
     * Devolve o indice de um artigo no Array
     * @param name nome do artigo
     * @return indice do artigo. -1 se nao existir
     */
    int getItemIndex(String name);

    /**
     * Apaga todos os artigos e faz reset ao volume restante
     * @return o valor de todos os artigos
     */
    int pay();


}
