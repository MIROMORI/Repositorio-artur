public class FaseResultados {

    // Função que executa a fase de resultados após o combate
    public static void executarFaseResultados(Time time1, Time time2) {
        int scoreTime1 = calcularScore(CombateAtivo.cemiterio1);  // Calcula o score do Time 1
        int scoreTime2 = calcularScore(CombateAtivo.cemiterio2);  // Calcula o score do Time 2

        boolean time1ComLutadorVivo = verificarLutadoresVivos(time1);
        boolean time2ComLutadorVivo = verificarLutadoresVivos(time2);

        // Condição 1: Se um time tiver ao menos um lutador vivo e o adversário não
        if (time1ComLutadorVivo && !time2ComLutadorVivo) {
            System.out.println("O Time 1 venceu!");
            return;
        } else if (!time1ComLutadorVivo && time2ComLutadorVivo) {
            System.out.println("O Time 2 venceu!");
            return;
        }

        // Condição 2: Se ambos os times tiverem lutadores vivos e um time alcançar score >= 20
        if (time1ComLutadorVivo && time2ComLutadorVivo) {
            if (scoreTime1 >= 20 && scoreTime2 < 20) {
                System.out.println("O Time 1 venceu por score maior que 20!");
                return;
            } else if (scoreTime2 >= 20 && scoreTime1 < 20) {
                System.out.println("O Time 2 venceu por score maior que 20!");
                return;
            }

            // Condição 3: Se ambos os times tiverem score > 20, o time com maior score vence
            if (scoreTime1 > scoreTime2) {
                System.out.println("O Time 1 venceu por maior score!");
                return;
            } else if (scoreTime2 > scoreTime1) {
                System.out.println("O Time 2 venceu por maior score!");
                return;
            }

            // Condição 4: Se ambos os times ficaram vazios e o score for igual, empate
            if (!time1ComLutadorVivo && !time2ComLutadorVivo) {
                if (scoreTime1 == scoreTime2) {
                    System.out.println("Empate!");
                } else {
                    System.out.println("O time com maior score venceu!");
                }
                return;
            }
        }

        // Se nenhuma condição de término for atendida, o jogo continua
    }

    // Função que verifica se há lutadores vivos em um time
    private static boolean verificarLutadoresVivos(Time time) {
        for (Lutador lutador : time.getLutadores()) {
            if (lutador != null && lutador.getLutadorVida() > 0) {
                return true; // Encontrou um lutador vivo
            }
        }
        return false; // Nenhum lutador vivo encontrado
    }

    // Função que calcula o score do time, baseado na quantidade de lutadores no cemitério adversário
    private static int calcularScore(Lutador[] cemiterio) {
        int score = 0;
        for (Lutador lutador : cemiterio) {
            if (lutador != null) {
                score++;
            }
        }
        return score;
    }

    // Função que verifica se o jogo deve continuar
    public static boolean continuarJogo(Time time1, Time time2) {
        // Se ambos os times tiverem lutadores vivos, o jogo continua
        boolean time1ComLutadorVivo = verificarLutadoresVivos(time1);
        boolean time2ComLutadorVivo = verificarLutadoresVivos(time2);

        // O jogo só continuará se ambos os times tiverem lutadores vivos
        return time1ComLutadorVivo && time2ComLutadorVivo;
    }
}