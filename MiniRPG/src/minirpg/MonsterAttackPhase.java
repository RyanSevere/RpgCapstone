package minirpg;

import java.util.ListIterator;
import java.lang.Math;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

public class MonsterAttackPhase extends Battle {

    static int playerDistance[] = new int[4];
    static int playerToAttack;
    static int lowest;
    static boolean mmc;
    static int attackingMonsterIndex;

    public MonsterAttackPhase() {
    }

    static void findPlayerToAttack() {
        ListIterator<Monster> li = monsters.listIterator();
        int i = 0;
        attackingMonsterIndex = 0;
        if (li.hasNext()) {
            
        lowest = 100;
        for (int x = 0; x < playerDistance.length; x++) {
            int pColDistance = Math.abs((MiniRPG.players.get(x).getColumn() + 1) - 11);
            int pRowDistance = Math.abs((MiniRPG.players.get(x).getRow() + 1) - 11);
            int mColDistance = Math.abs((monsters.get(i).getColumn() + 1) - 11);
            int mRowDistance = Math.abs((monsters.get(i).getRow() + 1) - 11);
            int distanceBetweenCol = Math.abs(pColDistance - mColDistance);
            int distanceBetweenRow = Math.abs(pRowDistance - mRowDistance);
            int distanceTotal = distanceBetweenCol + distanceBetweenRow;
            playerDistance[x] = distanceTotal;
            //System.out.println(distanceBetween);
            if (distanceTotal < lowest) {
                lowest = playerDistance[x];
                playerToAttack = x;
            }
            //System.out.println(minirpg.MiniRPG.players.get(x).getName() + " is" + playerDistance[x] + "from " +monsters.get(i).getName() );
        }

        //System.out.println(monsters.get(i).getName() + " should attack " + minirpg.MiniRPG.players.get(playerToAttack).getName());
        monsterAttack(i);
        i++;
        attackingMonsterIndex ++;
        li.next();
        //System.out.println(i);
        }
        //System.out.println("meow");



    }

    static void monsterAttack(int attackingMonsterIndex) {
        int i = attackingMonsterIndex;
        int x = playerToAttack;
        run();
        if (monsters.get(i).getMovesLeft() != 0) {

            int pColDistance = Math.abs((MiniRPG.players.get(x).getColumn() + 1) - 11);
            int pRowDistance = Math.abs((MiniRPG.players.get(x).getRow() + 1) - 11);
            int mColDistance = Math.abs((monsters.get(i).getColumn() + 1) - 11);
            int mRowDistance = Math.abs((monsters.get(i).getRow() + 1) - 11);
            int distanceBetweenCol = Math.abs(pColDistance - mColDistance);
            int distanceBetweenRow = Math.abs(pRowDistance - mRowDistance);
            System.out.println("col distance is " + distanceBetweenCol);
            System.out.println("row distance is " + distanceBetweenRow);
            if (distanceBetweenCol < distanceBetweenRow && distanceBetweenCol != 0) {

                if (monsters.get(i).getColumn() < MiniRPG.players.get(x).getColumn()) {
                    monsterMoveCheck(1, i);
                    if (mmc == true) {
                        updateTable(i);
                        monsters.get(i).setColumn(monsters.get(i).getColumn() + 1);
                        monsters.get(i).setMovesLeft(monsters.get(i).getMovesLeft() - 1);
                        //System.out.println(monsters.get(i).getName() + " moved 1 right");
                        updateTable2(i);
                    }
                } else {
                    monsterMoveCheck(2, i);
                    if (mmc == true) {
                        updateTable(i);
                        monsters.get(i).setColumn(monsters.get(i).getColumn() - 1);
                        monsters.get(i).setMovesLeft(monsters.get(i).getMovesLeft() - 1);
                        //System.out.println(monsters.get(i).getName() + " moved 1 left");
                        updateTable2(i);
                    }
                }
            } else if (distanceBetweenCol < distanceBetweenRow && distanceBetweenRow != 0) {

                if (monsters.get(i).getRow() < MiniRPG.players.get(x).getRow()) {
                    monsterMoveCheck(3, i);
                    if (mmc == true) {
                        updateTable(i);
                        monsters.get(i).setRow(monsters.get(i).getRow() + 1);
                        monsters.get(i).setMovesLeft(monsters.get(i).getMovesLeft() - 1);
                        updateTable2(i);
                        //System.out.println(monsters.get(i).getName() + " moved 1 down");
                        mmc = false;
                    }
                } else {
                    monsterMoveCheck(4, i);
                    if (mmc == true) {
                        updateTable(i);
                        monsters.get(i).setRow(monsters.get(i).getRow() - 1);
                        monsters.get(i).setMovesLeft(monsters.get(i).getMovesLeft() - 1);
                        //System.out.println(monsters.get(i).getName() + " moved 1 up");
                        updateTable2(i);
                    }

                }

            }
        } else {
        }
    }

    static void monsterMoveCheck(int direction, int attackingMonsterIndex) {
        int d = direction;
        int i = attackingMonsterIndex;
        if (d == 1) {
            if (table.getValueAt(monsters.get(i).getRow(), monsters.get(i).getColumn() + 1) == null || table.getValueAt(monsters.get(i).getRow(), monsters.get(i).getColumn() + 1) == "") {
                mmc = true;
            }
        } else if (d == 2) {
            if (table.getValueAt(monsters.get(i).getRow(), monsters.get(i).getColumn() - 1) == null || table.getValueAt(monsters.get(i).getRow(), monsters.get(i).getColumn() - 1) == "") {
                mmc = true;
            }
        } else if (d == 3) {
            if (table.getValueAt(monsters.get(i).getRow() + 1, monsters.get(i).getColumn()) == null || table.getValueAt(monsters.get(i).getRow() + 1, monsters.get(i).getColumn()) == null) {
                mmc = true;
            }
        } else if (d == 4) {
            if (table.getValueAt(monsters.get(i).getRow() - 1, monsters.get(i).getColumn()) == null || table.getValueAt(monsters.get(i).getRow() - 1, monsters.get(i).getColumn()) == null) {
                mmc = true;
            }
        }
    }

    static void run() {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                findPlayerToAttack();
            }
        });
        try {
            Thread.sleep(700);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }
}
