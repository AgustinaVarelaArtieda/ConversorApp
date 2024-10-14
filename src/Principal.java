import com.aluracursos.conversorapp.modelos.Menu;

public class Principal {
    public static void main(String[] args) {
        try {
            Menu menu = new Menu();
            menu.run();
        } catch (Exception e){
            System.err.println("Error al iniciar la aplicación: " + e.getMessage());
        }
    }
}
