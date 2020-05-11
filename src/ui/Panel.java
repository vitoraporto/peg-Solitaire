package ui;

import com.company.Game;
import com.company.invalidMoveException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Panel extends JPanel {
    private Game game;

    public Panel(Game game){
        this.game = game;
        this.enableEvents(AWTEvent.MOUSE_EVENT_MASK);
    }

    private void drawGame(Graphics g) {
        ArrayList<ArrayList<Integer>> positions = game.givePositionsFilled();
        for (ArrayList<Integer> position:positions){
            drawCircle(g,position.get(0),position.get(1));
        }
        ArrayList<ArrayList<Integer>> positionsEmpty = game.givePositionsEmpty();
        for (ArrayList<Integer> position:positionsEmpty){
            drawCircleEmpty(g,position.get(0),position.get(1));
        }
    }

    private void drawCircleEmpty(Graphics g, Integer x, Integer y) {
        x = x*100+25;
        y = y*100+25;
        g.drawOval(x,y,50,50);
    }

    private void drawCircle(Graphics g, int x, int y) {
        x = x*100+25;
        y = y*100+25;
        g.fillOval(x,y,50,50);
    }

    @Override
    public void paintComponent(Graphics g) {
        drawGame(g);
    }

    public void processMouseEvent(MouseEvent e) {
        switch (e.getID()) {
            case MouseEvent.MOUSE_PRESSED:
                mousePressed(e);
                break;
            case MouseEvent.MOUSE_RELEASED:
                mouseReleased(e);
                break;
        }
    }

    public void mousePressed(MouseEvent e) {
        Point point = e.getPoint();
        int x = (int) Math.floor(point.getX()/100);
        int y = (int) Math.floor(point.getY()/100);
        game.setSelectedDot(x,y);
    }

    public void mouseReleased(MouseEvent e) {
        Point point = e.getPoint();
        int x = (int) Math.floor(point.getX()/100);
        int y = (int) Math.floor(point.getY()/100);
        try {
            game.moveTo(x,y);
            Graphics g = getGraphics();
            g.clearRect(0,0,700,700);
            paintComponent(g);
        } catch (invalidMoveException ignored) {
        }
    }
}
