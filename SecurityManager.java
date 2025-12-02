public class SecurityManager {

    public boolean authenticate() {
        System.out.println("Autenticando usuário...");
        return true;
    }

    public boolean checkPermissions(String title) {
        System.out.println("Validando permissões para: " + title);
        return true;
    }
}