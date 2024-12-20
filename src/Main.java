import java.util.Scanner;

import java.util.Scanner;

class Main { public static void main(String[] args) {

    // Instanciando lutadores
    Lutador lutador1 = new Lutador("GeraltDeRivia", 90, 28, 45);
    Lutador lutador2 = new Lutador("Ciri", (int) (Math.random() * 101), (int) (Math.random() * 101), 60);
    Lutador lutador3 = new Lutador("Lambert", (int) (Math.random() * 101), (int) (Math.random() * 101), 18);
    Lutador lutador4 = new Lutador("Yennefer", (int) (Math.random() * 101), (int) (Math.random() * 101), 30);
    Lutador lutador5 = new Lutador("Vesemir", (int) (Math.random() * 101), (int) (Math.random() * 101), 57);
    Lutador lutador6 = new Lutador("Cocatriz", (int) (Math.random() * 101), (int) (Math.random() * 101), 23);
    Lutador lutador7 = new Lutador("Moira1", (int) (Math.random() * 101), (int) (Math.random() * 101), 41);
    Lutador lutador8 = new Lutador("Moira2", (int) (Math.random() * 101), (int) (Math.random() * 101), 47);
    Lutador lutador9 = new Lutador("Grifo", (int) (Math.random() * 101), (int) (Math.random() * 101), 39);
    Lutador lutador10 = new Lutador("Lobisomem", (int) (Math.random() * 101), (int) (Math.random() * 101), 21);

    Time time1 = new Time("nome time1");
    Time time2 = new Time("nome time2");

    time1.inserirLutador(lutador1);
    time1.inserirLutador(lutador2);
    time1.inserirLutador(lutador3);
    time1.inserirLutador(lutador4);
    time1.inserirLutador(lutador5);
    time2.inserirLutador(lutador6);
    time2.inserirLutador(lutador7);
    time2.inserirLutador(lutador8);
    time2.inserirLutador(lutador9);
    time2.inserirLutador(lutador10);

    System.out.println("Bem vindo ao RPG Tucano !!!!!");
    System.out.println("\nVamos ao jogo:\n\nTime 1:\n");

    // Imprimindo os nomes dos lutadores do time 1
    System.out.println("Time 1:");
    for (int i = 0; i < Time.maximo1; i++) {
        System.out.printf("%s", time1.getLutadores()[i].getLutadorNome());
        if ((i + 1) % 2 == 0) {
            System.out.println(); // Quebra de linha após cada par de nomes
        }
    }
    if (Time.maximo1 % 2 != 0) {
        System.out.println(); // Adiciona uma linha extra caso o número de lutadores seja ímpar
    }

    // Imprimindo os nomes dos lutadores do time 2
    System.out.println("Time 2:");
    for (int i = 0; i < Time.maximo2; i++) {
        System.out.printf("%s", time2.getLutadores()[i].getLutadorNome());
        if ((i + 1) % 2 == 0) {
            System.out.println(); // Quebra de linha após cada par de nomes
        }
    }
    if (Time.maximo2 % 2 != 0) {
        System.out.println(); // Adiciona uma linha extra caso o número de lutadores seja ímpar
    }

    System.out.println("Vamos começar? (s/n)");
    Scanner scanner = new Scanner(System.in);
    String opcao = scanner.nextLine();
    if (opcao.equals("s")) {
        do{
            System.out.println("\nDeseja dar um trato na sua equipe?");
            System.out.println("1 - Checar status de um time");
            System.out.println("2 - Remover lutador de um time");
            System.out.println("3 - Adicionar um novo lutador");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("Checar status de qual time? (1 ou 2): ");
                    int timeEscolhido = scanner.nextInt();
                    if (timeEscolhido == 1) {
                        Lutador.checarStatus(time1.getLutadores(), Time.maximo1);  // Checa o status do Time 1
                    } else if (timeEscolhido == 2) {
                        Lutador.checarStatus(time2.getLutadores(), Time.maximo2);  // Checa o status do Time 2
                    }
                    break;
                case "2":
                    System.out.println("Digite o nome do lutador para remover: ");
                    scanner.nextLine(); // Consumir quebra de linha
                    String nomeParaRemover = scanner.nextLine();
                    System.out.println("Remover de qual time? (1 ou 2): ");
                    int timeRemover = scanner.nextInt();
                    if (timeRemover == 1) {
                        Lutador.checarRemoverLutador(time1.getLutadores(), nomeParaRemover, Time.maximo1);
                        Time.retirarDeMax(Time.maximo1);
                    } else if (timeRemover == 2) {
                        Lutador.checarRemoverLutador(time2.getLutadores(), nomeParaRemover, Time.maximo2);
                        Time.retirarDeMax(Time.maximo2);
                    }
                    break;
                case "3": // Adicionar um novo lutador a um time
                    System.out.print("Digite o nome do lutador: ");
                    scanner.nextLine(); // Consumir quebra de linha
                    String nomeLutador = scanner.nextLine();

                    System.out.print("Digite o dano causado pelo lutador (0-100): ");
                    int lutadorDano = scanner.nextInt();

                    System.out.print("Digite a vida inicial do lutador (0-100): ");
                    int lutadorVida = scanner.nextInt();

                    System.out.print("Digite a iniciativa do lutador: ");
                    int lutadorIniciativa = scanner.nextInt();

                    // Criação do novo lutador com os dados fornecidos
                    Lutador novoLutador = new Lutador(nomeLutador, lutadorDano, lutadorVida, lutadorIniciativa);

                    // Perguntar em qual time adicionar o lutador
                    System.out.print("Adicionar o lutador ao Time 1 ou Time 2? (1 ou 2): ");
                    int timeAdicionar = scanner.nextInt();

                    boolean adicionado = false;

                    if (timeAdicionar == 1) {
                        // Adicionar ao Time 1
                        adicionado = time1.inserirLutador(novoLutador);
                        if (adicionado) {
                            Time.adicionarDeMax(Time.maximo1);
                        }
                    } else if (timeAdicionar == 2) {
                        // Adicionar ao Time 2
                        adicionado = time2.inserirLutador(novoLutador);
                        if (adicionado) {
                            Time.adicionarDeMax(Time.maximo2);
                        }
                    } else {
                        System.out.println("Time inválido! Escolha 1 ou 2.");
                    }
                    break;
                case "0":
                    System.out.println("\n\n------------------\nCombate iniciado:\n-----------------\n\n");
                    CombateAtivo.realizarCombate(time1.getLutadores(), time2.getLutadores(), Time.maximo1, Time.maximo2);
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
            scanner.close();
            // Após o combate, chame a fase de resultados
            FaseResultados.executarFaseResultados(time1, time2);

        }while(!FaseResultados.continuarJogo(time1, time2));
    }
}
}