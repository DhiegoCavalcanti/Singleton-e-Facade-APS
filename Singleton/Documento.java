public class Documento {
    private String nome;
    private int qtdePaginas;

    public Documento(String nome, int qtdePaginas) {
        this.nome = nome;
        this.qtdePaginas = qtdePaginas;
    }

    public String getNome() {
        return nome;
    }

    public int getQtdePaginas() {
        return qtdePaginas;
    }
}
