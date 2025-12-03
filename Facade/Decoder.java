public class Decoder {

    private int frameId = 0;

    public int decode(byte[] buffer) {
        System.out.println("Decodificando " + buffer.length + " bytes...");
        return ++frameId;
    }

    public void render(int frame) {
        System.out.println("Renderizando frame #" + frame);
    }
}