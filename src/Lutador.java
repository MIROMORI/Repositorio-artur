class Lutador {

    private String lutadorNome;
    private int lutadorDano;
    private int lutadorVida;
    private int lutadorIniciativa;

    public Lutador(String lutadorNome, int lutadorDano, int lutadorVida, int lutadorIniciativa) {
        this.lutadorNome = lutadorNome;
        this.lutadorDano = lutadorDano;
        this.lutadorVida = lutadorVida;
        this.lutadorIniciativa = lutadorIniciativa;
    }

    // Getters e Setters
    public String getLutadorNome() {
        return lutadorNome;
    }

    public int getLutadorDano() {
        return lutadorDano;
    }

    public int getLutadorVida() {
        return lutadorVida;
    }

    public int getLutadorIniciativa() {
        return lutadorIniciativa;
    }

    public static void checarStatus(Lutador[] timeEstaticoStatus, int maximo) {
        // Verificar status de cada lutador
        for (int i = 0; i < maximo; i++) {
            if (timeEstaticoStatus[i] != null) {
                System.out.printf("Status de %s: Vida = %d | Iniciativa = %d\n",
                        timeEstaticoStatus[i].getLutadorNome(),
                        timeEstaticoStatus[i].getLutadorVida(),
                        timeEstaticoStatus[i].getLutadorIniciativa());
            }
        }
    }

    public static Lutador checarRemoverLutador(Lutador[] timeEstaticoRemover, String lutadorNome, int maximo) {
        for (int i = 0; i < maximo; i++) {
            if (timeEstaticoRemover[i] != null && timeEstaticoRemover[i].getLutadorNome().equals(lutadorNome)) {
                Lutador lutadorRemovido = timeEstaticoRemover[i];
                timeEstaticoRemover[i] = null;
                return lutadorRemovido;
            }
        }
        return null;
    }
    public void sofrerDano(int danoRecebido) {
        this.lutadorVida -= danoRecebido;
        if (this.lutadorVida < 0) {
            this.lutadorVida = 0;  // Garantir que a vida não fique negativa
        }
        System.out.printf("O lutador %s sofreu %d de dano e agora tem %d de vida.\n", lutadorNome, danoRecebido, lutadorVida);
    }
}