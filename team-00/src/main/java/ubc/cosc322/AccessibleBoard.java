package ubc.cosc322;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Map;

public class AccessibleBoard {
    int[][] tileArray;

    AccessibleBoard(){
        tileArray = new int[10][10];
    }

    public void setGameState(final ArrayList<Integer> gameS) {
        SwingUtilities.invokeLater(() -> {
            for(int i = 1; i < 11; ++i) {
                for(int j = 1; j < 11; ++j) {
                    System.out.println(11 * i + j);
                    System.out.println(i + " " + j);
                    int a = (Integer)gameS.get(11 * i + j);
                    if (a == 1) {
                        tileArray[i-1][j-1] = 1;
                    } else if (a == 2) {
                        tileArray[i-1][j-1] = 2;
                    } else if (a == 3) {
                        tileArray[i-1][j-1] = 3;
                    }
                }
            }

        });
    }

    public void updateGameState(ArrayList<Integer> queenCurrent, ArrayList<Integer> queenNew, ArrayList<Integer> arrow) {
        tileArray[queenNew.get(0)][queenNew.get(1)] = tileArray[queenCurrent.get(0)][queenCurrent.get(1)];
        tileArray[queenCurrent.get(0)][queenCurrent.get(1)] = 0;
        tileArray[arrow.get(0)][arrow.get(1)] = 3;
    }

    public void updateGameState(final Map<String, Object> msgDetails) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                updateGameState((ArrayList)msgDetails.get("queen-position-current"), (ArrayList)msgDetails.get("queen-position-next"), (ArrayList)msgDetails.get("arrow-position"));
            }
        });
    }
}
