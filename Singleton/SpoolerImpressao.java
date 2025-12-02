import java.util.LinkedList;
import java.util.Queue;

public class SpoolerImpressao {
    private static SpoolerImpressao instancia = null;
    private Queue<Documento> filaImpressao;
    private ImpressoraFisica impressora;

    private SpoolerImpressao() {
        this.filaImpressao = new LinkedList<>();
        this.impressora = new ImpressoraFisica();

        System.out.println("\nGerenciador de Impressão iniciado.");
    }

    public static SpoolerImpressao getInstancia() {
        if (instancia == null) {
            synchronized (SpoolerImpressao.class) {
                if (instancia == null) {
                    instancia = new SpoolerImpressao();
                }
            }
        }

        return instancia;
    }

    public void adicionarImpressao(Documento doc) {
        if (doc.getQtdePaginas() == 1) {
            System.out.println("\nAdicionando '" + doc.getNome() + "' (" + doc.getQtdePaginas() + " página)" + " à fila.");
        } else {
            System.out.println("\nAdicionando '" + doc.getNome() + "' (" + doc.getQtdePaginas() + " páginas)" + " à fila.");
        }

        this.filaImpressao.add(doc);
    }

    public void iniciarImpressao() {
        if (this.filaImpressao.isEmpty()) {
            System.out.println("\nA fila de impressão está vazia.");
            return;
        }

        System.out.println("\n\nIniciando impressão... (" + filaImpressao.size() + " documentos na fila)\n");

        while (!this.filaImpressao.isEmpty()) {
            Documento doc = this.filaImpressao.poll();
            this.impressora.imprimirDocumento(doc);
        }

        System.out.println("\n\nTodos os documentos foram impressos.\n");
    }
}
