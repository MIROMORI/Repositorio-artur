public class CombateAtivo {
    static Lutador[] cemiterio1 = new Lutador[30];
    static Lutador[] cemiterio2 = new Lutador[30];

    // Método para simular o combate entre dois times
    public static void realizarCombate(Lutador[] time1, Lutador[] time2, int maximo1, int maximo2) {
        // Lógica quando Time1 tem mais ou igual lutadores do que Time2
        if (maximo1 >= maximo2) {
            for (int i = 0; i < maximo2; i++) {
                combateIndividual(time1[i], time2[i]);
            }

            // Se Time1 tem mais lutadores, o último lutador do Time1 sofre dano de todos os lutadores restantes do Time2
            if (maximo1 > maximo2) {
                for (int i = maximo2; i < maximo1; i++) {
                    for (int j = 0; j < maximo2; j++) {
                        time1[i].sofrerDano(time2[j].getLutadorDano());
                    }
                    verificarMorte(time1[i], cemiterio1);
                }
            }
        } else { // Caso Time2 tenha mais lutadores do que Time1
            for (int i = 0; i < maximo1; i++) {
                combateIndividual(time1[i], time2[i]);
            }

            // Se Time2 tem mais lutadores, o último lutador do Time2 sofre dano de todos os lutadores restantes do Time1
            if (maximo2 > maximo1) {
                for (int i = maximo1; i < maximo2; i++) {
                    for (int j = 0; j < maximo1; j++) {
                        time2[i].sofrerDano(time1[j].getLutadorDano());
                    }
                    verificarMorte(time2[i], cemiterio2);
                }
            }
        }
    }

    // Método para realizar o combate entre dois lutadores
    private static void combateIndividual(Lutador lutador1, Lutador lutador2) {
        int dano1 = lutador1.getLutadorDano();
        int dano2 = lutador2.getLutadorDano();

        // Ataque simultâneo: ambos os lutadores sofrem dano ao mesmo tempo
        lutador1.sofrerDano(dano2);  // Lutador 1 sofre dano do Lutador 2
        lutador2.sofrerDano(dano1);  // Lutador 2 sofre dano do Lutador 1

        // Verificar a morte de cada lutador após os ataques simultâneos
        verificarMorte(lutador1, cemiterio1);
        verificarMorte(lutador2, cemiterio2);
    }

    // Método para verificar se um lutador morreu e, se sim, mover para o cemitério
    private static void verificarMorte(Lutador lutador, Lutador[] cemiterio1) {
        if (lutador.getLutadorVida() <= 0) {
            System.out.printf("O lutador %s morreu!!\n", lutador.getLutadorNome());
            Time.inserirCemiterio(cemiterio1, lutador);
        }
    }
}