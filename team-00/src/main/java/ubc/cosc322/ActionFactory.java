package ubc.cosc322;

import java.util.ArrayList;

public class ActionFactory {
    public ActionFactory() {
    }

    public ArrayList<ArrayList<Integer>> getActions(AccessibleBoard board, int colour) {
        //holds all possible moves where a move is an array of 6 numbers: currentQueenX, currentQueenY, queenMoveX, queenMoveY, arrowX, arrowY
        ArrayList<ArrayList<Integer>> actions = new ArrayList<>();

        int[][] tilearray = board.tileArray;

        for(int x = 0; x < tilearray.length; x++){
            for(int y = 0; y < tilearray[0].length; y++){
                if(tilearray[x][y] == colour){
                    ArrayList<Integer[]> queenMoves = new ArrayList<>();
                    int[] currPos = {x, y};
                    while((currPos[0] + 1 < 10 && currPos[1] + 1 < 10) && tilearray[currPos[0]+1][currPos[1]+1] != 1 && tilearray[currPos[0]+1][currPos[1]+1] != 2 && tilearray[currPos[0]+1][currPos[1] + 1] != 3){
                        currPos[0] = currPos[0] + 1;
                        currPos[1] = currPos[1] + 1;
                        queenMoves.add(new Integer[]{currPos[0], currPos[1]});
                    }
                    currPos = new int[]{x, y};
                    while(currPos[0] + 1 < 10 && tilearray[currPos[0]+1][currPos[1]] != 1 && tilearray[currPos[0]+1][currPos[1]] != 2 && tilearray[currPos[0]+1][currPos[1]] != 3){
                        currPos[0] = currPos[0] + 1;
                        queenMoves.add(new Integer[]{currPos[0], currPos[1]});
                    }
                    currPos = new int[]{x, y};
                    while((currPos[0] + 1 < 10 && currPos[1] - 1 > -1) && tilearray[currPos[0]+1][currPos[1]-1] != 1 && tilearray[currPos[0]+1][currPos[1]-1] != 2 && tilearray[currPos[0]+1][currPos[1] - 1] != 3){
                        currPos[0] = currPos[0] + 1;
                        currPos[1] = currPos[1] - 1;
                        queenMoves.add(new Integer[]{currPos[0], currPos[1]});
                    }
                    currPos = new int[]{x, y};
                    while(currPos[1] - 1 > -1 && tilearray[currPos[0]][currPos[1]-1] != 1 && tilearray[currPos[0]][currPos[1]-1] != 2 && tilearray[currPos[0]][currPos[1] - 1] != 3){
                        currPos[1] = currPos[1] - 1;
                        queenMoves.add(new Integer[]{currPos[0], currPos[1]});
                    }
                    currPos = new int[]{x, y};
                    while((currPos[0] - 1 > -1 && currPos[1] - 1 > -1) && tilearray[currPos[0]-1][currPos[1]-1] != 1 && tilearray[currPos[0]-1][currPos[1]-1] != 2 && tilearray[currPos[0]-1][currPos[1] - 1] != 3){
                        currPos[0] = currPos[0] - 1;
                        currPos[1] = currPos[1] - 1;
                        queenMoves.add(new Integer[]{currPos[0], currPos[1]});
                    }
                    currPos = new int[]{x, y};
                    while(currPos[0] - 1 > -1 && tilearray[currPos[0]-1][currPos[1]] != 1 && tilearray[currPos[0]-1][currPos[1]] != 2 && tilearray[currPos[0]-1][currPos[1]] != 3){
                        currPos[0] = currPos[0] - 1;
                        queenMoves.add(new Integer[]{currPos[0], currPos[1]});
                    }
                    currPos = new int[]{x, y};
                    while((currPos[0] - 1 > -1 && currPos[1] + 1 < 10) && tilearray[currPos[0]-1][currPos[1]+1] != 1 && tilearray[currPos[0]-1][currPos[1]+1] != 2 && tilearray[currPos[0]-1][currPos[1] + 1] != 3){
                        currPos[0] = currPos[0] - 1;
                        currPos[1] = currPos[1] + 1;
                        queenMoves.add(new Integer[]{currPos[0], currPos[1]});
                    }
                    currPos = new int[]{x, y};
                    while(currPos[1] + 1 < 10 && tilearray[currPos[0]][currPos[1]+1] != 1 && tilearray[currPos[0]][currPos[1]+1] != 2 && tilearray[currPos[0]][currPos[1] + 1] != 3){
                        currPos[1] = currPos[1] + 1;
                        queenMoves.add(new Integer[]{currPos[0], currPos[1]});
                    }


                    for (Integer[] move : queenMoves) {
                        currPos = new int[]{move[0], move[1]};
                        while((currPos[0] + 1 < 10 && currPos[1] + 1 < 10) && tilearray[currPos[0]+1][currPos[1]+1] != 1 && tilearray[currPos[0]+1][currPos[1]+1] != 2 && tilearray[currPos[0]+1][currPos[1] + 1] != 3){
                            currPos[0] = currPos[0] + 1;
                            currPos[1] = currPos[1] + 1;
                            ArrayList<Integer> fullMove = new ArrayList<>();
                            fullMove.add(x);
                            fullMove.add(y);
                            fullMove.add(move[0]);
                            fullMove.add(move[1]);
                            fullMove.add(currPos[0]);
                            fullMove.add(currPos[1]);
                            actions.add(fullMove);
                        }
                        currPos = new int[]{move[0], move[1]};
                        while(currPos[0] + 1 < 10 && tilearray[currPos[0]+1][currPos[1]] != 1 && tilearray[currPos[0]+1][currPos[1]] != 2 && tilearray[currPos[0]+1][currPos[1]] != 3){
                            currPos[0] = currPos[0] + 1;
                            ArrayList<Integer> fullMove = new ArrayList<>();
                            fullMove.add(x);
                            fullMove.add(y);
                            fullMove.add(move[0]);
                            fullMove.add(move[1]);
                            fullMove.add(currPos[0]);
                            fullMove.add(currPos[1]);
                            actions.add(fullMove);
                        }
                        currPos = new int[]{move[0], move[1]};
                        while((currPos[0] + 1 < 10 && currPos[1] - 1 > -1) && tilearray[currPos[0]+1][currPos[1]-1] != 1 && tilearray[currPos[0]+1][currPos[1]-1] != 2 && tilearray[currPos[0]+1][currPos[1] - 1] != 3){
                            currPos[0] = currPos[0] + 1;
                            currPos[1] = currPos[1] - 1;
                            ArrayList<Integer> fullMove = new ArrayList<>();
                            fullMove.add(x);
                            fullMove.add(y);
                            fullMove.add(move[0]);
                            fullMove.add(move[1]);
                            fullMove.add(currPos[0]);
                            fullMove.add(currPos[1]);
                            actions.add(fullMove);
                        }
                        currPos = new int[]{move[0], move[1]};
                        while(currPos[1] - 1 > -1 && tilearray[currPos[0]][currPos[1]-1] != 1 && tilearray[currPos[0]][currPos[1]-1] != 2 && tilearray[currPos[0]][currPos[1] - 1] != 3){
                            currPos[1] = currPos[1] - 1;
                            ArrayList<Integer> fullMove = new ArrayList<>();
                            fullMove.add(x);
                            fullMove.add(y);
                            fullMove.add(move[0]);
                            fullMove.add(move[1]);
                            fullMove.add(currPos[0]);
                            fullMove.add(currPos[1]);
                            actions.add(fullMove);
                        }
                        currPos = new int[]{move[0], move[1]};
                        while((currPos[0] - 1 > -1 && currPos[1] - 1 > -1) && tilearray[currPos[0]-1][currPos[1]-1] != 1 && tilearray[currPos[0]-1][currPos[1]-1] != 2 && tilearray[currPos[0]-1][currPos[1] - 1] != 3){
                            currPos[0] = currPos[0] - 1;
                            currPos[1] = currPos[1] - 1;
                            ArrayList<Integer> fullMove = new ArrayList<>();
                            fullMove.add(x);
                            fullMove.add(y);
                            fullMove.add(move[0]);
                            fullMove.add(move[1]);
                            fullMove.add(currPos[0]);
                            fullMove.add(currPos[1]);
                            actions.add(fullMove);
                        }
                        currPos = new int[]{move[0], move[1]};
                        while(currPos[0] - 1 > -1 && tilearray[currPos[0]-1][currPos[1]] != 1 && tilearray[currPos[0]-1][currPos[1]] != 2 && tilearray[currPos[0]-1][currPos[1]] != 3){
                            currPos[0] = currPos[0] - 1;
                            ArrayList<Integer> fullMove = new ArrayList<>();
                            fullMove.add(x);
                            fullMove.add(y);
                            fullMove.add(move[0]);
                            fullMove.add(move[1]);
                            fullMove.add(currPos[0]);
                            fullMove.add(currPos[1]);
                            actions.add(fullMove);
                        }
                        currPos = new int[]{move[0], move[1]};
                        while((currPos[0] - 1 > -1 && currPos[1] + 1 < 10) && tilearray[currPos[0]-1][currPos[1]+1] != 1 && tilearray[currPos[0]-1][currPos[1]+1] != 2 && tilearray[currPos[0]-1][currPos[1] + 1] != 3){
                            currPos[0] = currPos[0] - 1;
                            currPos[1] = currPos[1] + 1;
                            ArrayList<Integer> fullMove = new ArrayList<>();
                            fullMove.add(x);
                            fullMove.add(y);
                            fullMove.add(move[0]);
                            fullMove.add(move[1]);
                            fullMove.add(currPos[0]);
                            fullMove.add(currPos[1]);
                            actions.add(fullMove);
                        }
                        currPos = new int[]{move[0], move[1]};
                        while(currPos[1] + 1 < 10 && tilearray[currPos[0]][currPos[1]+1] != 1 && tilearray[currPos[0]][currPos[1]+1] != 2 && tilearray[currPos[0]][currPos[1] + 1] != 3){
                            currPos[1] = currPos[1] + 1;
                            ArrayList<Integer> fullMove = new ArrayList<>();
                            fullMove.add(x);
                            fullMove.add(y);
                            fullMove.add(move[0]);
                            fullMove.add(move[1]);
                            fullMove.add(currPos[0]);
                            fullMove.add(currPos[1]);
                            actions.add(fullMove);
                        }

                    }
                }
            }
        }
        return actions;
    }
}
