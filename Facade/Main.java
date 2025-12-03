public class Main {
    public static void main(String[] args) {
        StreamingFacade player = new StreamingFacade();

        // 1. Inicializa o sistema de streaming (Autenticação e Conexão)
        if (!player.initialize()) {
            System.out.println("Falha ao iniciar o reprodutor. Encerrando.");
            return;
        }
        
        // 2. Reprodução do primeiro título
        player.play("Interstellar");
        player.pause();
        
        // 3. Reprodução de um novo título
        player.play("The Matrix"); 
        player.stop();
    }
}
