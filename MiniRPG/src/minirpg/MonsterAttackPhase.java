package minirpg;

import java.util.ListIterator;
import java.lang.Math;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

public class MonsterAttackPhase extends Battle {

    public int playerDistance[] = new int[4];
    public int playerToAttack;
    public int lowest;
    public int highest;
    public boolean mmc;
    public boolean mca;
    public int attackingMonsterIndex;

    public MonsterAttackPhase() {
    }

    public void findPlayerToAttack() {
        int i = attackingMonsterIndex;
        if (attackingMonsterIndex <= 4 && attackingMonsterIndex != -1) {
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
            System.out.println("attacking monster index is " + i);


            if (attackingMonsterIndex != 5 && monsters.get(attackingMonsterIndex).getMovesLeft() != 0) {
                monsterAttack(attackingMonsterIndex);
            } else if (attackingMonsterIndex != 5 && monsters.get(attackingMonsterIndex).getMovesLeft() == 0) {
                attackingMonsterIndex++;
                run();
            } else if (attackingMonsterIndex == 5) {
                //run();
            }

            //System.out.println(attackingMonsterIndex);
            //System.out.println(i);
        } else {
            System.out.println("DONE!!");
            attackingMonsterIndex = 0;
            for(int x = 0;x <= 5;x++){
               monsters.get(x).setMovesLeft(x); 
               monsters.get(x).setHasAttacked(false);
            }
        }
        //attackingMonsterIndex = -1;
        //System.out.println("meow");



    }

    public void monsterAttack(int attackingMonsterIndex) {
        int i = attackingMonsterIndex;
        int x = playerToAttack;
        //System.out.println("monster attack!");
        if (monsters.get(i).getMovesLeft() != 0) {
            int pColDistance = Math.abs((MiniRPG.players.get(x).getColumn() + 1) - 11);
            int pRowDistance = Math.abs((MiniRPG.players.get(x).getRow() + 1) - 11);
            int mColDistance = Math.abs((monsters.get(i).getColumn() + 1) - 11);
            int mRowDistance = Math.abs((monsters.get(i).getRow() + 1) - 11);
            int distanceBetweenCol = Math.abs(pColDistance - mColDistance);
            int distanceBetweenRow = Math.abs(pRowDistance - mRowDistance);
            //System.out.println("col distance is " + distanceBetweenCol);
            //System.out.println("row distance is " + distanceBetweenRow);
            if (distanceBetweenCol < distanceBetweenRow && distanceBetweenCol != 0) {
                if (monsters.get(i).getColumn() < MiniRPG.players.get(x).getColumn()) {
                    monsterMoveCheck(1, i);
                    if (mmc == true) {
                        monsterMoveRight();
                        monsterCheckAttack();
                    }
                }
                if (monsters.get(i).getColumn() > MiniRPG.players.get(x).getColumn()) {
                    monsterMoveCheck(2, i);
                    if (mmc == true) {
                        monsterMoveLeft();
                        monsterCheckAttack();
                    }
                }
            } else if (distanceBetweenCol < distanceBetweenRow && distanceBetweenRow != 0) {

                if (monsters.get(i).getRow() < MiniRPG.players.get(x).getRow()) {
                    monsterMoveCheck(3, i);
                    if (mmc == true) {
                        monsterMoveDown();
                        monsterCheckAttack();
                    }
                }
                if (monsters.get(i).getRow() > MiniRPG.players.get(x).getRow()) {
                    monsterMoveCheck(4, i);
                    if (mmc == true) {
                        monsterMoveUp();
                        monsterCheckAttack();
                    }
                }
            }
        }
        //run();
    }

    public void monsterMoveCheck(int direction, int attackingMonsterIndex) {
        int d = direction;
        int i = attackingMonsterIndex;
        if (d == 1) {
            if (table.getValueAt(monsters.get(i).getRow(), monsters.get(i).getColumn() + 1) == null /*
                     * || table.getValueAt(monsters.get(i).getRow(),
                     * monsters.get(i).getColumn() + 1) == ""
                     */) {
                mmc = true;
            } else {
                //monsterMoveCheck2(2, i);
                monsters.get(i).setMovesLeft(0);
                run();
            }
        }
        if (d == 2) {
            if (table.getValueAt(monsters.get(i).getRow(), monsters.get(i).getColumn() - 1) == null /*
                     * || table.getValueAt(monsters.get(i).getRow(),
                     * monsters.get(i).getColumn() - 1) == ""
                     */) {
                mmc = true;
            } else {
                //monsterMoveCheck2(3, i);
                monsters.get(i).setMovesLeft(0);
                run();
            }
        }
        if (d == 3) {
            if (table.getValueAt(monsters.get(i).getRow() + 1, monsters.get(i).getColumn()) == null /*
                     * || table.getValueAt(monsters.get(i).getRow() + 1,
                     * monsters.get(i).getColumn()) == ""
                     */) {
                mmc = true;
            } else {
                //monsterMoveCheck2(4, i);
                monsters.get(i).setMovesLeft(0);
                run();
            }
        }
        if (d == 4) {
            if (table.getValueAt(monsters.get(i).getRow() - 1, monsters.get(i).getColumn()) == null /*
                     * || table.getValueAt(monsters.get(i).getRow() - 1,
                     * monsters.get(i).getColumn()) == ""
                     */) {
                mmc = true;
            } else {
                //monsterMoveCheck2(0, i);
                monsters.get(i).setMovesLeft(0);
                run();
            }
        }
    }

    public void monsterMoveCheck2(int direction, int attackingMonsterIndex) {
        int d = direction;
        int i = attackingMonsterIndex;
        if (d == 1) {
            if (table.getValueAt(monsters.get(i).getRow(), monsters.get(i).getColumn() + 1) == null/*
                     * || table.getValueAt(monsters.get(i).getRow(),
                     * monsters.get(i).getColumn() + 1) == ""
                     */) {
                monsterMoveDown();
            } else {
                monsterMoveCheck2(2, i);
            }
        }
        if (d == 2) {
            if (table.getValueAt(monsters.get(i).getRow(), monsters.get(i).getColumn() - 1) == null /*
                     * || table.getValueAt(monsters.get(i).getRow(),
                     * monsters.get(i).getColumn() - 1) == ""
                     */) {
                monsterMoveUp();
            } else {
                monsterMoveCheck2(3, i);
            }
        }
        if (d == 3) {
            if (table.getValueAt(monsters.get(i).getRow() + 1, monsters.get(i).getColumn()) == null /*
                     * || table.getValueAt(monsters.get(i).getRow() + 1,
                     * monsters.get(i).getColumn()) == ""
                     */) {
                monsterMoveRight();
            } else {
                monsterMoveCheck2(4, i);
            }
        }
        if (d == 4) {
            if (table.getValueAt(monsters.get(i).getRow() - 1, monsters.get(i).getColumn()) == null /*
                     * || table.getValueAt(monsters.get(i).getRow() - 1,
                     * monsters.get(i).getColumn()) == ""
                     */) {
                monsterMoveLeft();
            } else {
                monsterMoveCheck2(1, i);
            }
        }
    }

    public void run() {
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

    public void monsterCheckAttack() {
        int i = attackingMonsterIndex;
        int x = 0;
        mca = false;
        while (x < 4) {
            if (table.getValueAt(monsters.get(i).getRow(), monsters.get(i).getColumn() + 1) != null && monsters.get(i).getHasAttacked() == false) {
                if (table.getValueAt(monsters.get(i).getRow(), monsters.get(i).getColumn() + 1).equals(MiniRPG.players.get(x).getName())) {
                    mca = true;
                    System.out.println(monsters.get(i).getName() + "has attacked = " + monsters.get(i).getHasAttacked() );
                    x = playerToAttack;
                    monsterHit();
                    break;
                }
            }
            if (table.getValueAt(monsters.get(i).getRow(), monsters.get(i).getColumn() - 1) != null && monsters.get(i).getHasAttacked() == false) {
                if (table.getValueAt(monsters.get(i).getRow(), monsters.get(i).getColumn() - 1).equals(MiniRPG.players.get(x).getName())) {
                    mca = true;
                    System.out.println(monsters.get(i).getName() + "has attacked = " + monsters.get(i).getHasAttacked());
                    x = playerToAttack;
                    monsterHit();
                    break;
                }
            }
            if (table.getValueAt(monsters.get(i).getRow() + 1, monsters.get(i).getColumn()) != null && monsters.get(i).getHasAttacked() == false) {
                if (table.getValueAt(monsters.get(i).getRow() +1, monsters.get(i).getColumn()).equals(MiniRPG.players.get(x).getName())) {
                    mca = true;
                    System.out.println(monsters.get(i).getName() + "has attacked = " + monsters.get(i).getHasAttacked());
                    x = playerToAttack;
                    monsterHit();
                    break;
                }
            }
            if (table.getValueAt(monsters.get(i).getRow() - 1, monsters.get(i).getColumn()) != null && monsters.get(i).getHasAttacked() == false) {
                if (table.getValueAt(monsters.get(i).getRow() - 1, monsters.get(i).getColumn()).equals(MiniRPG.players.get(x).getName())) {
                    mca = true;
                    System.out.println(monsters.get(i).getName() + "has attacked = " + monsters.get(i).getHasAttacked());
                    x = playerToAttack;
                    monsterHit();
                    break;
                }

            }
            x++;
        }
    }

    public void monsterMoveRight() {
        int i = attackingMonsterIndex;
        updateTable(i);
        monsters.get(i).setColumn(monsters.get(i).getColumn() + 1);
        monsters.get(i).setMovesLeft(monsters.get(i).getMovesLeft() - 1);
        //System.out.println(monsters.get(i).getName() + " moved 1 right");
        updateTable2(i);
        mmc = false;
        //monsterCheckAttack();
        run();
    }

    public void monsterMoveLeft() {
        int i = attackingMonsterIndex;
        updateTable(i);
        monsters.get(i).setColumn(monsters.get(i).getColumn() - 1);
        monsters.get(i).setMovesLeft(monsters.get(i).getMovesLeft() - 1);
        //System.out.println(monsters.get(i).getName() + " moved 1 left");
        updateTable2(i);
        mmc = false;
        //monsterCheckAttack();
        run();
    }

    public void monsterMoveDown() {
        int i = attackingMonsterIndex;
        updateTable(i);
        monsters.get(i).setRow(monsters.get(i).getRow() + 1);
        monsters.get(i).setMovesLeft(monsters.get(i).getMovesLeft() - 1);
        updateTable2(i);
        //System.out.println(monsters.get(i).getName() + " moved 1 down");
        mmc = false;
        //monsterCheckAttack();
        run();
    }

    public void monsterMoveUp() {
        int i = attackingMonsterIndex;
        updateTable(i);
        monsters.get(i).setRow(monsters.get(i).getRow() - 1);
        monsters.get(i).setMovesLeft(monsters.get(i).getMovesLeft() - 1);
        //System.out.println(monsters.get(i).getName() + " moved 1 up");
        updateTable2(i);
        mmc = false;
        //monsterCheckAttack();
        run();
    }
    public void monsterHit(){
    int i = attackingMonsterIndex;
    int x = playerToAttack;  
    infoBox.setText(MiniRPG.players.get(x).getName() + " takes " + 5 + " damage.\n" 
            + MiniRPG.players.get(x).getName() + " is down to " + monsterHP + " Hp");
    monsters.get(i).setHasAttacked(false);
    }
//    public void findNextClosestPlayer(){
//    int i = attackingMonsterIndex;
//        highest = 0;
//        for (int x = 0; x < playerDistance.length; x++) {
//            int pColDistance = Math.abs((MiniRPG.players.get(x).getColumn() + 1) - 11);
//            int pRowDistance = Math.abs((MiniRPG.players.get(x).getRow() + 1) - 11);
//            int mColDistance = Math.abs((monsters.get(i).getColumn() + 1) - 11);
//            int mRowDistance = Math.abs((monsters.get(i).getRow() + 1) - 11);
//            int distanceBetweenCol = Math.abs(pColDistance - mColDistance);
//            int distanceBetweenRow = Math.abs(pRowDistance - mRowDistance);
//            int distanceTotal = distanceBetweenCol + distanceBetweenRow;
//            playerDistance[x] = distanceTotal;
//            //System.out.println(distanceBetween);
//            if (distanceTotal > highest) {
//                highest = playerDistance[x];
//                playerToAttack = x;
//                monsterAttack(attackingMonsterIndex);
//            }
//        }
//    }
}
