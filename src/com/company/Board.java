package com.company;

import java.util.ArrayList;

public class Board {
    private ArrayList<ArrayList<Integer>> bMatrix;

    public Board(){
        bMatrix = new ArrayList<>();
        ArrayList<Integer> line1 = botonDownRow();
        ArrayList<Integer> line2 = botonDownRow();
        ArrayList<Integer> line3 = midleRow();
        ArrayList<Integer> line4 = centerRow();
        ArrayList<Integer> line5 = midleRow();
        ArrayList<Integer> line6 = botonDownRow();
        ArrayList<Integer> line7 = botonDownRow();
        bMatrix.add(line1);
        bMatrix.add(line2);
        bMatrix.add(line3);
        bMatrix.add(line4);
        bMatrix.add(line5);
        bMatrix.add(line6);
        bMatrix.add(line7);
    }

    private ArrayList<Integer> centerRow() {
        ArrayList<Integer> line = new ArrayList<>();
        line.add(1);
        line.add(1);
        line.add(1);
        line.add(0);
        line.add(1);
        line.add(1);
        line.add(1);
        return line;
    }

    private ArrayList<Integer> midleRow() {
        ArrayList<Integer> line = new ArrayList<>();
        line.add(1);
        line.add(1);
        line.add(1);
        line.add(1);
        line.add(1);
        line.add(1);
        line.add(1);
        return line;
    }

    private ArrayList<Integer> botonDownRow() {
        ArrayList<Integer> line = new ArrayList<>();
        line.add(-1);
        line.add(-1);
        line.add(1);
        line.add(1);
        line.add(1);
        line.add(-1);
        line.add(-1);
        return line;
    }

    public void moveLeft(ArrayList<Integer> selectedDot) throws invalidMoveException {
        if (selectedDot.get(0) < 2){
            throw new invalidMoveException();
        }
        if (bMatrix.get(selectedDot.get(1)).get(selectedDot.get(0)) != 1 || bMatrix.get(selectedDot.get(1)).get(selectedDot.get(0)-1) != 1 || bMatrix.get(selectedDot.get(1)).get(selectedDot.get(0)-2) != 0){
            throw new invalidMoveException();
        }
        bMatrix.get(selectedDot.get(1)).set(selectedDot.get(0), 0);
        bMatrix.get(selectedDot.get(1)).set(selectedDot.get(0)-1, 0);
        bMatrix.get(selectedDot.get(1)).set(selectedDot.get(0)-2, 1);
    }

    public void moveUp(ArrayList<Integer> selectedDot) throws invalidMoveException {
        if (selectedDot.get(1) < 2){
            throw new invalidMoveException();
        }
        if (bMatrix.get(selectedDot.get(1)).get(selectedDot.get(0)) != 1 || bMatrix.get(selectedDot.get(1)-1).get(selectedDot.get(0)) != 1 || bMatrix.get(selectedDot.get(1)-2).get(selectedDot.get(0)) != 0){
            throw new invalidMoveException();
        }
        bMatrix.get(selectedDot.get(1)).set(selectedDot.get(0), 0);
        bMatrix.get(selectedDot.get(1)-1).set(selectedDot.get(0), 0);
        bMatrix.get(selectedDot.get(1)-2).set(selectedDot.get(0), 1);
    }

    public void moveRight(ArrayList<Integer> selectedDot) throws invalidMoveException {
        if (selectedDot.get(0) > 4){
            throw new invalidMoveException();
        }
        if (bMatrix.get(selectedDot.get(1)).get(selectedDot.get(0)) != 1 || bMatrix.get(selectedDot.get(1)).get(selectedDot.get(0)+1) != 1 || bMatrix.get(selectedDot.get(1)).get(selectedDot.get(0)+2) != 0){
            throw new invalidMoveException();
        }
        bMatrix.get(selectedDot.get(1)).set(selectedDot.get(0), 0);
        bMatrix.get(selectedDot.get(1)).set(selectedDot.get(0)+1, 0);
        bMatrix.get(selectedDot.get(1)).set(selectedDot.get(0)+2, 1);
    }

    public void moveDown(ArrayList<Integer> selectedDot) throws invalidMoveException {
        if (selectedDot.get(1) > 4){
            throw new invalidMoveException();
        }
        if (bMatrix.get(selectedDot.get(1)).get(selectedDot.get(0)) != 1 || bMatrix.get(selectedDot.get(1)+1).get(selectedDot.get(0)) != 1 || bMatrix.get(selectedDot.get(1)+2).get(selectedDot.get(0)) != 0){
            throw new invalidMoveException();
        }
        bMatrix.get(selectedDot.get(1)).set(selectedDot.get(0), 0);
        bMatrix.get(selectedDot.get(1)+1).set(selectedDot.get(0), 0);
        bMatrix.get(selectedDot.get(1)+2).set(selectedDot.get(0), 1);
    }

    public ArrayList<ArrayList<Integer>> givePositionsFilled() {

        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (bMatrix.get(i).get(j)==1){
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(j);
                    pair.add(i);
                    pairs.add(pair);
                }
            }
        }
        return pairs;
    }

    public ArrayList<ArrayList<Integer>> givePositionsEmpty() {
        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (bMatrix.get(i).get(j)==0){
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(j);
                    pair.add(i);
                    pairs.add(pair);
                }
            }
        }
        return pairs;
    }
}
