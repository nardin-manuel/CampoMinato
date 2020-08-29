import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class CampoMinato {
    protected static int mine;
    protected static int visitedNumber;
    Random r = new Random();
    JDialog dialog;
    //campi di classe
    private JButton[][] campo;
    private boolean[][] bombe;
    private boolean[][] visited;
    private JFrame frame;
    private GridLayout layout;
    private int lato;

    //costruttore
    public CampoMinato(JFrame frame, int lato, int mine) {
        this.frame = frame;
        this.mine = mine;
        this.lato = lato;
        layout = new GridLayout(lato, lato);
        bombe = new boolean[lato][lato];
        visited = new boolean[lato][lato];
        frame.setLayout(layout);
        this.campo = new JButton[lato][lato];
        for (int i = 0; i < lato; i++)
            for (int j = 0; j < lato; j++) {
                campo[i][j] = new JButton();
                campo[i][j].setBackground(Color.green);
                campo[i][j].setVisible(true);
                frame.add(campo[i][j]);


                campo[i][j].addActionListener((e) -> {
                    for (int k = 0; k < lato; k++) {
                        for (int l = 0; l < lato; l++) {
                            if (campo[k][l].equals(e.getSource())) {
                                //System.out.println("k: " + k + ", l: " + l);
                                if (bombe[k][l]) {
                                    campo[k][l].setBackground(Color.RED);
                                    try {
                                        Thread.sleep(100);
                                    } catch (InterruptedException interruptedException) {
                                        interruptedException.printStackTrace();
                                    }
                                    JOptionPane.showMessageDialog(frame, "Te ga perso! Mona!");
                                    System.exit(1);
                                }
                                scopriPercorso(k, l);
                                System.out.println("Mine: " + mine + "|Visited: " + CampoMinato.visitedNumber + "|Tot: " + (mine + visitedNumber));
                                if (mine + visitedNumber == Math.pow(lato, 2)) {
                                    JOptionPane.showMessageDialog(frame, "Te ga vinto! Intelligente!");
                                    System.exit(1);
                                }
                            }
                        }
                    }
                });


            }
        for (int i = 0; i < mine; i++) {
            boolean valid = false;
            while (!valid) {
                int xr = r.nextInt(lato);
                int yr = r.nextInt(lato);
                if (!bombe[xr][yr]) {
                    valid = true;
                    bombe[xr][yr] = true;
                    //campo[xr][yr].setBackground(Color.LIGHT_GRAY);
                }
            }
        }

    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < this.lato && y >= 0 && y < this.lato;
    }

    private int getNBombeVicine(int x, int y) {
        int acc = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (isValid(i, j) && bombe[i][j] && (i != x || j != y)) {
                    acc++;
                }
            }
        }
        return acc;
    }

    public void scopriPercorso(int x, int y) {

        int nBombeVicine = getNBombeVicine(x, y);
        if (nBombeVicine != 0) {
            campo[x][y].setText("" + nBombeVicine);
            if (!visited[x][y]) {
                visited[x][y] = true;
                campo[x][y].setBackground(Color.LIGHT_GRAY);
                visitedNumber++;
            }
        } else {
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    //  System.out.println(String.format("i: %d, j: %d", i,j));
                    if (isValid(i, j) && !visited[i][j]) {
                        // campo[i][j].setBackground(Color.GREEN);
                        visited[i][j] = true;
                        visitedNumber++;
                        campo[x][y].setBackground(Color.LIGHT_GRAY);
                        scopriPercorso(i, j);


                    }
                }
            }
        }
    }
}