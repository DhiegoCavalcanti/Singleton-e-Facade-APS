public class MediaServer {

    private byte[] buffer;

    public boolean connect() {
        System.out.println("Conectando ao servidor de mídia...");
        return true;
    }

    public void loadStream() {
        System.out.println("Carregando stream...");
        buffer = new byte[]{1, 2, 3, 4, 5};
    }

    public byte[] getBuffer() {
        return buffer;
    }
}