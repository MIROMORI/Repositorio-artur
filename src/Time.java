class Time {

    private String nomeTime;
    private Lutador[] lutadores;
    private static final int CAPACIDADE = 10;
    public static int maximo1 = 5;
    public static int maximo2 = 5;

    public Time(String nomeTime) {
        this.nomeTime = nomeTime;
        this.lutadores = new Lutador[CAPACIDADE];
    }

    public boolean inserirLutador(Lutador lutador) {
        for (int i = 0; i < lutadores.length; i++) {
            if (lutadores[i] == null) {
                lutadores[i] = lutador;
                System.out.println("Lutador " + lutador.getLutadorNome() + " adicionado ao time " + nomeTime);
                return true; // Lutador adicionado com sucesso
            }
        }
        return false; // Time cheio
    }

    public static void inserirCemiterio(Lutador[] cemiterio, Lutador lutador) {
        for (int i = 0; i < cemiterio.length; i++) {
            if (cemiterio[i] == null) {
                cemiterio[i] = lutador;
                System.out.println("Lutador " + lutador.getLutadorNome() + " adicionado ao cemitério.");
                return;
            }
        }
        System.out.println("O cemitério está cheio!");
    }

    // Getters e setters
    public String getNomeTime() {
        return nomeTime;
    }

    public Lutador[] getLutadores() {
        return lutadores;
    }
    //funções diversas
    public static int retirarDeMax(int maximo){
        return maximo--;
    }
    public static int adicionarDeMax(int maximo){
        return maximo++;
    }
}