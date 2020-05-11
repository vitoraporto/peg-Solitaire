package com.company;

import java.util.ArrayList;

public class Game {
    private Board board = new Board();
    private ArrayList<Integer> selectedDot = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> givePositionsFilled(){
        return board.givePositionsFilled();
    }

    public ArrayList<ArrayList<Integer>> givePositionsEmpty() {
        return board.givePositionsEmpty();
    }

    public void setSelectedDot(int x, int y) {
        selectedDot = new ArrayList<>();
        selectedDot.add(x);
        selectedDot.add(y);
    }

    public void moveTo(int x, int y) throws invalidMoveException {
        if (x-selectedDot.get(0) == -2 && selectedDot.get(1)==y) {
            board.moveLeft(selectedDot);
        } else if (x == selectedDot.get(0) && y - selectedDot.get(1)== -2) {
            board.moveUp(selectedDot);
        } else if (x-selectedDot.get(0) == 2 && selectedDot.get(1)==y) {
            board.moveRight(selectedDot);
        } else if (x == selectedDot.get(0) && y - selectedDot.get(1)== 2) {
            board.moveDown(selectedDot);
        }
    }
}
