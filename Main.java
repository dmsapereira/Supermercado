import java.util.*;

import Handling.*;
import Iterable.Iterator;

/**
*@author 52890: David Pereira, 52886: Bruno Ramos
*/
public class Main {
    private static final String CARRINHO_ADD = "Carrinho criado com sucesso.";
    private static final String CARRINHO_FALHA = "Carrinho existente!";
    private static final String ARTIGO_ADD = "Artigo criado com sucesso.";
    private static final String ARTIGO_FALHA = "Artigo existente!";
    private static final String ARTIGO_DEPOSIT = "Artigo adicionado com sucesso.";
    private static final String CARRINHO_VOID = "Carrinho inexistente!";
    private static final String ARTIGO_VOID = "Artigo inexistente!";
    private static final String CARRINH_FULL = "Capacidade excedida!";
    private static final String REMOVE_DONE = "Artigo removido com sucesso.";
    private static final String ARTIGO_VOID_CARRINHO = "Artigo inexistente no carrinho!";
    private static final String CARRINHO_EMPTY = "Carrinho vazio!";

    /**
     * Os comandos disponiveis
     */
    private enum Command {
        CARRINHO, ARTIGO, DEPOSITA, REMOVE, LISTA, PAGA, SAIR, DESCONHECIDO;
    }

    /**
     * Le o comando a executar
     *
     * @param in scanner
     * @return Enum Command correspondente ao input
     */
    private static Command getCommand(Scanner in) {
        try {
            String input = in.next().toUpperCase();
            if (input.equals("CRIA"))
                input = in.next().toUpperCase();
            return Command.valueOf(input);
        } catch (IllegalArgumentException error) {
            return Command.DESCONHECIDO;
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Handler system = new HandlerClass();
        Command input = getCommand(in);
        while (!input.equals(Command.SAIR)) {
            switch (input) {
                case CARRINHO:
                    createCart(in, system);
                    break;
                case ARTIGO:
                    createItem(in, system);
                    break;
                case DEPOSITA:
                    deposit(in, system);
                    break;
                case REMOVE:
                    removeItem(in, system);
                    break;
                case LISTA:
                    listItems(in, system);
                    break;
                case PAGA:
                    payment(in, system);
                    break;
                default:
                    break;

            }
            System.out.println();
            input = getCommand(in);
        }
        System.out.println("Volte sempre.");
        System.out.println();
    }

    /**
     * Executa o comando PAGA
     */
    private static void payment(Scanner in, Handler system) {
        String cartName = in.next().trim();
        in.nextLine();
        int aux = system.pay(cartName);
        switch (aux) {
            case 0:
                System.out.println(CARRINHO_EMPTY);
                break;
            case -1:
                System.out.println(CARRINHO_VOID);
                break;
            default:
                System.out.println(aux);
        }
    }

    /**
     * Executa o comando LISTA
     */
    private static void listItems(Scanner in, Handler system) {
        Item current;
        String cartName = in.next().trim();
        in.nextLine();
        Iterator<Item> itera = system.itemIterator(cartName);
        if (itera == null)
            System.out.println(CARRINHO_VOID);
        else if (!itera.hasNext())
            System.out.println(CARRINHO_EMPTY);
        else {
            while (itera.hasNext()) {
                current = itera.next();
                System.out.println(((ItemClass) current).getName() + " " + current.getCost());
            }
        }
    }

    /**
     * Executa o comando REMOVE
     */
    private static void removeItem(Scanner in, Handler system) {
        String itemName = in.next().trim();
        String cartName = in.next().trim();
        in.nextLine();
        switch (system.removeItem(itemName, cartName)) {
            case 0:
                System.out.println(REMOVE_DONE);
                break;
            case 1:
                System.out.println(CARRINHO_VOID);
                break;
            case 2:
                System.out.println(ARTIGO_VOID_CARRINHO);
                break;
            default:
        }
    }

    /**
     * Executa o comando DEPOSITA
     */
    private static void deposit(Scanner in, Handler system) {
        String itemName = in.next().trim();
        String cartName = in.next().trim();
        in.nextLine();
        switch (system.depositItem(itemName, cartName)) {
            case 0:
                System.out.println(ARTIGO_DEPOSIT);
                break;
            case 1:
                System.out.println(CARRINHO_VOID);
                break;
            case 2:
                System.out.println(ARTIGO_VOID);
                break;
            case 3:
                System.out.println(CARRINH_FULL);
                break;
            default:
        }
    }

    /**
     * Executa o comando CRIA ARTIGO
     */
    private static void createItem(Scanner in, Handler system) {
        String name = in.next().trim();
        int cost = in.nextInt();
        int volume = in.nextInt();
        in.nextLine();
        switch (system.addItem(name, cost, volume)) {
            case 0:
                System.out.println(ARTIGO_ADD);
                break;
            case 1:
                System.out.println(ARTIGO_FALHA);
                break;
        }
    }

    /**
     * Executa o comando CRIA CARRINHO
     */
    private static void createCart(Scanner in, Handler system) {
        String name = in.next().trim();
        int volume = in.nextInt();
        in.nextLine();
        switch (system.addCart(name, volume)) {
            case 0:
                System.out.println(CARRINHO_ADD);
                break;
            case 1:
                System.out.println(CARRINHO_FALHA);
                break;
            default:
        }

    }

}