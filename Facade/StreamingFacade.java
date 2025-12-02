public class StreamingFacade {

    private final SecurityManager security;
    private final MediaServer server;
    private final Decoder decoder;

    public StreamingFacade() {
        this.security = new SecurityManager();
        this.server = new MediaServer();
        this.decoder = new Decoder();
    }

    public void play(String title) {

        if (!security.authenticate()) {
            System.out.println("Erro: falha na autenticação.");
            return;
        }

        if (!security.checkPermissions(title)) {
            System.out.println("Erro: conteúdo não autorizado.");
            return;
        }

        if (!server.connect()) {
            System.out.println("Erro: não foi possível conectar ao servidor.");
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