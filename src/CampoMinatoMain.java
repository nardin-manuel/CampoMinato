import javax.swing.*;

public class CampoMinatoMain {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Campo Minato");
        new CampoMinato(frame, 10, 10); // Crea un gioco "Campo Minato" con una gliglia di lato N=10 e K=5 mine
        frame.setSize(1000, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }
}