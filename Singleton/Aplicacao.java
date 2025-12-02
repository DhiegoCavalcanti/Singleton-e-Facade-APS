import java.io.IOException;

public class Aplicacao {
    public static void main(String[] args) throws Exception {
        limparTela();

        System.out.println("\n[Contabilidade] Tentando obter o Gerenciador...");
        SpoolerImpressao contabilidadeSpooler = SpoolerImpressao.getInstancia();

        contabilidadeSpooler.adicionarImpressao(new Documento("Balanco_Anual.xlsx", 45));
        contabilidadeSpooler.adicionarImpressao(new Documento("Nota_Fiscal_123.pdf", 1));

        System.out.println("\n\n[Recursos Humanos] Tentando obter o Gerenciador...");
        SpoolerImpressao rhSpooler = SpoolerImpressao.getInstancia();

        rhSpooler.adicionarImpressao(new Documento("Ficha_Funcionario_João.pdf", 3));
        rhSpooler.adicionarImpressao(new Documento("Modelo_Relatorio.docx", 1));

        boolean mesmoObjeto = (contabilidadeSpooler == rhSpooler);

        System.out.println("\n\nOs gerenciadores são o mesmo objeto? > " + mesmoObjeto);
        
        contabilidadeSpooler.iniciarImpressao();
    }

    public static void limparTela() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls")
                    .inheritIO()
                    .start()
                    .waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException e) {
             e.printStackTrace();
        }
    }
}
