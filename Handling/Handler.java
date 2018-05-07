package Handling;

import Iterable.*;

public interface Handler {

    /**
     * Adiciona um carrinho
     *
     * @param name   nome do carrinho
     * @param volume volume do carrinho
     * @return 0-> Sem erros
     * 1-> Nome ja utilizado
     */
    int addCart(String name, int volume);

    /**
     * Adiciona um artigo ao repositorio dos artigos
     *
     * @param name   nome do artigo
     * @param cost   custo do artigo
     * @param volume volume do artigo
     * @return 0-> Sem erros
     * 1-> Nome ja utilizado
     */
    int addItem(String name, int cost, int volume);

    /**
     * Adiciona um artigo ao repositorio de artigos de um carrinho
     *
     * @param itemName nome do artigo
     * @param cartName nome do carrinho
     * @return 0-> Se, erros
     * 1-> Carrinho nao existe
     * 2-> Artigo nao existe
     * 3-> Nao ha espaco no carrinho
     */
    int depositItem(String itemName, String cartName);

    /**
     * Remove um artigo do repositorio de um carrinho
     *
     * @param itemName nome do artigo
     * @param cartName nome do carrinho
     * @return 0-> Sem erros
     * 1-> Carrinho nao existe
     * 2-> Artigo nao existe no repositorio do carrinho ou nao existe mesmo
     */
    int removeItem(String itemName, String cartName);

    /**
     * Devolve o iterador dos artigos de um carrinho
     *
     * @param cartName nome do carrinho
     * @return <code>null</code> se o carrinho nao existir
     */
    Iterator<Item> itemIterator(String cartName);

    /**
     * Limpa os artigos de um carrinho e faz reset ao seu volume
     *
     * @param cartName nome do carrinho
     * @return -1-> Carrinho nao existe
     * 0-> Carrinho vazio
     * >0-> Valor total dos artigos do carrinho
     */
    int pay(String cartName);


}
