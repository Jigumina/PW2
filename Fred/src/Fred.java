import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Fred extends JFrame {

    JButton[] casillas = new JButton[4];
    int[] secuencia = new int[5];
    Random random = new Random();

    public Fred() {
        setTitle("Fred20");
        setDefaultCloseOperation(3);
        setSize(300, 300);
        setLayout(new GridLayout(2, 2));

        for (int i = 0; i < 4; i++) {
            casillas[i] = new JButton();
            casillas[i].setBackground(Color.LIGHT_GRAY);

            int index = i;

            casillas[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    encender(index);
                }
            });

            add(casillas[i]);
        }

        generarSecuencia();
        mostrarSecuencia();
    }

    public void generarSecuencia() {
        for (int i = 0; i < secuencia.length; i++) {
            secuencia[i] = random.nextInt(4);
        }

        for (int s : secuencia) {
            System.out.print(s + " ");
        }
    }

    public void mostrarSecuencia() {
        Thread hilo = new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i < secuencia.length; i++) {
                        int indice = secuencia[i];

                        encender(indice);
                        Thread.sleep(1000);

                        casillas[indice].setBackground(Color.LIGHT_GRAY);
                        Thread.sleep(500);
                    }
                } catch (Exception e) {}
            }
        });
        hilo.start();
    }

    public void encender(int i){
        switch(i){
            case 0: casillas[i].setBackground(Color.RED); break;
            case 1: casillas[i].setBackground(Color.GREEN); break;
            case 2: casillas[i].setBackground(Color.BLUE); break;
            case 3: casillas[i].setBackground(Color.YELLOW); break;
        }
    }

    public static void main(String[] args) {
        Fred f = new Fred();
        f.setVisible(true);
    }
}