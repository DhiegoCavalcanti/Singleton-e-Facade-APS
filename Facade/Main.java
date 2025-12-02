public class Main {
    public static void main(String[] args) {
        StreamingFacade player = new StreamingFacade();

        player.play("Interstellar");
        player.pause();
        player.stop();
    }
}
