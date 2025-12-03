public class StreamingFacade {

    private final SecurityManager security;
    private final MediaServer server;
    private final Decoder decoder;
    private boolean isReady = false;

    public StreamingFacade() {
        this.security = new SecurityManager();
        this.server = new MediaServer();
        this.decoder = new Decoder();
    }

    public boolean initialize() {
        if (isReady) return true;

        System.out.println("\n--- Inicializando Streaming Facade ---");
        
        if (!security.authenticate()) {
            System.out.println("Erro: falha na autenticação inicial.");
            return false;
        }

        if (!server.connect()) {
            System.out.println("Erro: não foi possível conectar ao servidor inicial.");
            return false;
        }

        this.isReady = true;
        System.out.println("--- Facade pronto para reprodução ---");
        return true;
    }

    public void play(String title) {
        if (!isReady) {
            System.out.println("Erro: O sistema não está inicializado. Chame initialize() primeiro.");
            return;
        }
        
        System.out.println("\n--- Tentando reproduzir: " + title + " ---");

        if (!security.checkPermissions(title)) {
            System.out.println("Erro: conteúdo não autorizado.");
            return;
        }
        server.loadStream();

        byte[] buffer = server.getBuffer();
        int frame = decoder.decode(buffer);
        decoder.render(frame);
    }

    public void pause() {
        System.out.println("Reprodução pausada.");
    }

    public void stop() {
        System.out.println("Reprodução interrompida.");
    }
}