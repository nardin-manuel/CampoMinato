import javax.swing.*;

public class CampoMinatoMain {
    public static Icon terraNonVisitata = new ImageIcon("tnv.jpg");
    public static Icon terraVisitata = new ImageIcon("tv.jpg");
    public static Icon mina = new ImageIcon("bomba.jpg");
    public static Icon[] numbers = {new ImageIcon("0.gif"), new ImageIcon("1.gif"), new ImageIcon("9.gif")
    };

    public static void main(String args[]) {
        JFrame frame = new JFrame("Campo Minato");
        frame.setVisible(true);
        frame.setSize(1000, 500);
        new CampoMinato(frame, 10, 10); // Crea un gioco "Campo Minato" con una gliglia di lato N=10 e K=5 mine
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

    }


}