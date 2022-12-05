import javax.swing.JFrame;

public class PingPong {

    public static void main(String[] args) {
        JFrame obj = new JFrame ();
        //Notifying that there is a class called GameFunction and setting that as gameFunction
        GameFunction gameFunction = new GameFunction();
        //Setting the bound of the game
        obj.setBounds (0, 0, 800, 700);
        //Setting the title of the game
        obj.setTitle("2 PLAYER PING PONG GAME");
        //Prevent the user to resize the resize of the game
        obj.setResizable(false);
        //Make it visible
        obj.setVisible(true);
        //When the user press X, the game will close
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Adding the second class into this main function
        obj.add(gameFunction);
    }

}