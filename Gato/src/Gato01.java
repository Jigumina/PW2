
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Gato01 extends JFrame implements ActionListener {
    JButton botones[] = new JButton[9];
    boolean turnoX;
    Font fuente = new Font("Arial", 1, 50);
    JButton btnReiniciar;
    JPanel panelJuego, panelOpciones;

    public Gato01() {
        setSize(400, 400);
        setTitle("Juego Gato");
        setDefaultCloseOperation(3);
        //setLayout(new GridLayout(2, 0));

        panelJuego = new JPanel(new GridLayout(3, 3));
        panelOpciones = new JPanel();
        /*
        botones[0] = new JButton("");
        Font fuente  = new Font("Arial", 1, 50);
        botones[0].setFont(fuente);
        botones[0].addActionListener(this);
        add(botones[0]);
        */

        for (int i = 0; i < botones.length; i++) {
            botones[i] = new JButton("");
            botones[i].setFont(fuente);
            botones[i].addActionListener(this);
            panelJuego.add(botones[i]);
        }
        btnReiniciar = new JButton("Reiniciar Juego");

        btnReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < botones.length; i++) {
                    botones[i].setText("");
                    botones[i].setEnabled(true);
                    turnoX = true;
                }
            }
        });

        panelOpciones.add(btnReiniciar);
        add(panelJuego, BorderLayout.CENTER);
        add(panelOpciones, BorderLayout.SOUTH);

    }

    public void actionPerformed(ActionEvent e) {
        String letra;
        if (turnoX) {
            letra = "X";
            turnoX = false;
        } else {
            letra = "O";
            turnoX = true;
        }
        for (int i = 0; i < botones.length; i++) {
            if ((e.getSource() == botones[i])) {
                botones[i].setText(letra);
                botones[i].setEnabled(false);
            }
        }

        verificar();
    }

    public void verificar() {
        int[][] combos = {
                {0,1,2},{3,4,5},{6,7,8},
                {0,3,6},{1,4,7},{2,5,8},
                {0,4,8},{2,4,6}
        };

        for (int i = 0; i < combos.length; i++) {
            String a = botones[combos[i][0]].getText();
            String b = botones[combos[i][1]].getText();
            String c = botones[combos[i][2]].getText();

            if (!a.equals("") && a.equals(b) && b.equals(c)) {
                JOptionPane.showMessageDialog(this, "Ganó: " + a);

                for (int j = 0; j < botones.length; j++) {
                    botones[j].setEnabled(false);
                }
                return;
            }
        }
    }
}