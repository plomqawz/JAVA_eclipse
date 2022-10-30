package ex_11111;

import javax.swing.*;
import ex_11111.BlockGame.MyFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

class GameOverFrame extends JFrame implements ActionListener {

	private JButton bt_OK;
    private JTextField tf;

    private String namePlayer;

    static int SCORE;
    static int SCORE_REPAINT; // 리페인트 한 횟수를 점수에 활용하기로..

    GameOverFrame() {
        setTitle("Block Game - Game Over");
        setUndecorated(true);
        setResizable(false);
        setLayout(null);
        setBounds(100, 100, MyFrame.CANVAS_WIDTH, MyFrame.CANVAS_HEIGHT);

        tf = new JTextField(20);
        tf.setBounds(MyFrame.CANVAS_WIDTH / 2 - 180 / 2, MyFrame.CANVAS_HEIGHT / 2 - 25 / 2, 180, 25);
        tf.addActionListener(this);


        bt_OK = new JButton("확인");
        bt_OK.setBounds(390, MyFrame.CANVAS_HEIGHT / 2 - 25 / 2, 30, 25);
        bt_OK.addActionListener(this);

        add(tf);
        add(bt_OK);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        namePlayer = tf.getText();
        try (
                FileWriter fw = new FileWriter("test.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
        ) {
            bw.write(namePlayer);
            bw.newLine();
            bw.write(Integer.toString(SCORE));
            bw.newLine();
            bw.write(Integer.toString(SCORE_REPAINT));
            bw.newLine();
            bw.flush();
        } catch (IOException ie) {
            System.out.println(ie);
        }
        new Ranking();
    }

}
