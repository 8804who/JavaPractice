package 연습;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class 쥐를잡자 extends JFrame{
    private Container c = getContentPane();

    public 쥐를잡자() {
        setTitle("Mouse 이벤트 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setLayout(null);
        for(int i=1;i<10;i++) addMouse();
        setSize(500, 500);
        setVisible(true);
    }

    void addMouse(){
        JLabel mouse=new JLabel("mouse");
        c.add(mouse);
        mouse.addMouseListener(new MyListener());
        mouse.setSize(40, 40);
        mouse.setLocation((int)(Math.random()*300),(int)(Math.random()*300));
    }

    class MyListener implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            JLabel m=(JLabel) e.getSource();
            m.setText("");
            m.setSize(0, 0);
            addMouse();
        }
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
    }

    public static void main(String [] args) {
        new 쥐를잡자();
    }
}