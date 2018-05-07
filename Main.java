import java.util.*;

public class Main {
    private static final String CRIA_CARRINHO = "CRIA CARRINHO";
    private static final String CRIA_ARTIGO = "CRIA ARTIGO";

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

    private enum Command {
        CARRINHO, ARTIGO, DEPOSITA, REMOVE, LISTA, PAGA, SAIR, DESCONHECIDO;
    }

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
        Command input = getCommand(in);
        while (!input.equals(Command.SAIR)) {
            switch (input) {
                case CARRINHO:
                    break;
                case ARTIGO:
                    break;
                case DEPOSITA:
                    break;
                case REMOVE:
                    break;
                case LISTA:
                    break;
                case PAGA:
                    break;
                default:
                    break;

            }
            input = getCommand(in);
        }
        System.out.println("Volte sempre.");
    }

}