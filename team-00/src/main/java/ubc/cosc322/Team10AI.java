package ubc.cosc322;

import ygraph.ai.smartfox.games.*;
import ygraph.ai.smartfox.games.amazons.HumanPlayer;

import java.util.ArrayList;
import java.util.Map;

public class Team10AI extends GamePlayer {
    private GameClient gameClient = null;
    private BaseGameGUI gamegui = null;
    private AccessibleBoard board = null;
    private int colour = -1;

    private String userName = null;
    private String passwd = null;

    /**
     * Any name and passwd
     * @param userName
     * @param passwd
     */
    public Team10AI(String userName, String passwd) {
        this.userName = userName;
        this.passwd = passwd;

        //To make a GUI-based player, create an instance of BaseGameGUI
        //and implement the method getGameGUI() accordingly
        this.gamegui = new BaseGameGUI(this);
        this.board = new AccessibleBoard();
    }

    /**
     * The main method
     * @param args for name and passwd (current, any string would work)
     */
    public static void main(String[] args) {
//    	COSC322Test player = new COSC322Test(args[0], args[1]);
        HumanPlayer player1 = new HumanPlayer();
//        HumanPlayer player = new HumanPlayer();
        Team10AI player = new Team10AI(args[0], args[1]);
//        Team10AI player1 = new Team10AI("username", "aduds");

        if(player.getGameGUI() == null) {
            player.Go();
        }
        else {
            BaseGameGUI.sys_setup();
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    player.Go();
                }
            });
        }
        if(player1.getGameGUI() == null) {
            player1.Go();
        }
        else {
            BaseGameGUI.sys_setup();
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    player1.Go();
                }
            });
        }
//        if(player2.getGameGUI() == null) {
//            player2.Go();
//        }
//        else {
//            BaseGameGUI.sys_setup();
//            java.awt.EventQueue.invokeLater(new Runnable() {
//                public void run() {
//                    player2.Go();
//                }
//            });
//        }
    }

    @Override
    public void onLogin() {
        userName = gameClient.getUserName();
        if(gamegui != null) {
            gamegui.setRoomInformation(gameClient.getRoomList());
        }
    }

    @Override
    public boolean handleGameMessage(String messageType, Map<String, Object> msgDetails) {
        if(messageType.equals(GameMessage.GAME_STATE_BOARD)){
            System.out.println(msgDetails.get("game-state"));
            System.out.println("success\n\n\n");
            this.gamegui.setGameState((ArrayList<Integer>) msgDetails.get("game-state"));
            this.board.setGameState((ArrayList<Integer>) msgDetails.get("game-state"));
        }
        else if (messageType.equals(GameMessage.GAME_ACTION_MOVE)){
            this.gamegui.updateGameState(msgDetails);
            this.board.updateGameState(msgDetails);
        }
        else if (messageType.equals(GameMessage.GAME_ACTION_START)){
            System.out.println("Game start" + msgDetails.get("game-state"));
            this.gamegui.setGameState((ArrayList<Integer>) msgDetails.get("game-state"));
            this.board.setGameState((ArrayList<Integer>) msgDetails.get("game-state"));
            System.out.println("Black player" + msgDetails.get("player-black"));
            System.out.println("White player" + msgDetails.get("player-white"));

            if(msgDetails.get("player-black").equals(userName)){
                colour = 1;
            }
            else {
                colour = 2;
            }
            ActionFactory a = new ActionFactory();
            a.getActions(board, colour);
        }
    	System.out.println(msgDetails);
        return true;
    }

    @Override
    public GameClient getGameClient() {
        return this.gameClient;
    }

    @Override
    public BaseGameGUI getGameGUI() {
        return this.gamegui;
    }

    @Override
    public void connect() {
        gameClient = new GameClient(userName, passwd, this);
    }

    @Override
    public String userName() {
        return userName;
    }

    public void sendMove(ArrayList<Integer> queenPosCurrent, ArrayList<Integer> queenPosNew, ArrayList<Integer> arrowPos){
        gameClient.sendMoveMessage(queenPosCurrent, queenPosNew, arrowPos);
    }
}
