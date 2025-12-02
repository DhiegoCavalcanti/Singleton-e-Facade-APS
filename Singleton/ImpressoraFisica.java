public class ImpressoraFisica {
    public void imprimirDocumento(Documento doc) {
        System.out.print("\nImprimindo " + doc.getNome() + "... ");
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Impressão concluída.");
    }
}
