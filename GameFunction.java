//these are all imports for my game graphic, keyboard movement, and the game function
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameFunction extends JPanel implements KeyListener, ActionListener {

    // false because the game should not play 3332by itself
    private boolean play = false;

    // delaying the speed of the game
    int player1Score = 0;
    int player2Score = 0;
    private Timer timer;
    private int delay = -5;

    //The variable for X and Y position for player 1 (Starting position)
    private int player1Y = 150;
    private int player1X = 10;

    //The variable for X and Y position for player 2 (Starting position)
    private int player2Y = 150;
    private int player2X = 738;

    //The variable for X and Y position for game ball (Starting position)
    private int ballposX = 390;
    private int ballposY = 260;

    //X and Y direction of the Ping pong ball
    private int ballXdir = -1;
    private int ballYdir = -2;

    public GameFunction () {
        addKeyListener(this);
        setFocusable (true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer (delay, this);
        timer.start();
    }

    //graphic of the game (Game board, Ping pong ball, and Player pads)
    public void paint (Graphics g) {
    //Background colour
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0 , 0, 800, 600);

    //Player 1 PingPong Pad and the starting position of it
        g.setColor(Color.BLUE);
        g.fillRect(player1X,player1Y,40,200);
    //Player 1 PingPong Pad and the starting position of it
        g.setColor(Color.BLUE);
        g.fillRect(player2X, player2Y, 40, 200);

    //Border colour
        g.setColor(Color.BLACK);
    //Top border
        g.fillRect(0,0,790, 5);
    //Bottom border
        g.fillRect(0,558,790,558);
    //Middle line (decoration)
        g.fillRect(400, 0, 10, 600);

    //End Zone (HOW TO SCORE A POINT)
    //Border colour
        g.setColor(Color.RED);
    //Left side border
        g.fillRect(0,5,5,553);
    //Right side border
        g.fillRect(782,5,5,553);

    //Game score
        g.setColor(Color.red);
        g.setFont(new Font("serif", Font.BOLD, 30));
    //Player 1 score is on the left
        g.drawString("" + player1Score, 380, 30);
        g.drawString(":", 400, 30);
    //Player 2 score is on the right
        g.drawString("" + player2Score, 415, 30);

    //Ping pong ball
    //Game ball colour
        g.setColor(Color.YELLOW);
    //Position  of the ball and the size of the ball
        g.fillOval (ballposX, ballposY, 30 , 30);

    //The rule of the game
    //Game Rule title colour, font, and title
        g.setColor(Color.WHITE);
        g.fillRect(0,563, 787, 100);
        g.setColor(Color.black);
        g.setFont((new Font("Monospaced", Font.BOLD, 30)));
        g.drawString("GAME RULE", 327, 588);
    //How to move the player pads for player 1 and player 2
    //Instruction colour and font
        g.setColor(Color.RED);
        g.setFont((new Font("Monospaced", Font.BOLD, 20)));
        g.drawString("PLAYER 1 Movement: W to move UP and S to move Down", 125, 610);
        g.setColor(Color.BLUE);
        g.setFont((new Font("Monospaced", Font.BOLD, 20)));
        g.drawString("PLAYER 2 Movement: UP ARROW KEY and DOWN ARROW KEY", 125, 635);
        g.setColor(Color.black);
        g.setFont((new Font("Monospaced", Font.BOLD, 15)));
        g.drawString("*TAP TO MOVE*", 348, 657);

    //How to determine when a player wins the game
    //Player 1 Win
        if (ballposX > 750) {
            play = false;
            ballXdir = 0;
            ballYdir = 0;

            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced", Font.BOLD, 30));
            g.drawString("Game Over! Player1 WINS! ", 200, 240);

    //How to restart the game and score
            g.setColor(Color.red);
            g.setFont(new Font("serif", Font.BOLD, 20));
            g.drawString("Press Enter to Restart", 310, 350);

    //How to resume the game and keep the score
            g.setColor(Color.red);
            g.setFont(new Font("serif", Font.BOLD, 18));
            g.drawString("Press R to Resume", 325, 400);

        }
    //Player 2 Win
        if (ballposX < 5) {
            play = false;

            ballXdir = 0;
            ballYdir = 0;

            g.setColor(Color.BLUE);
            g.setFont(new Font("Monospaced", Font.BOLD, 30));
            g.drawString("Game Over! Player 2 WINS! ", 200, 240);

    //How to restart the game and score
            g.setColor(Color.blue);
            g.setFont(new Font("serif", Font.BOLD, 20));
            g.drawString("Press Enter to Restart", 310, 350);

    //How to resume the game and keep the score
            g.setColor(Color.blue);
            g.setFont(new Font("serif", Font.BOLD, 18));
            g.drawString("Press R to Resume", 325, 400);
        }
        g.dispose();

    }


    @Override
    //The function of the game (Ball, Board, and Player pads)
    public void actionPerformed(ActionEvent e) {
    //When the game starts, this function will run
        timer.start();
        if(play) {
    //Player 1 gains 1 score if the ball touches the right border (750)
            if (ballposX >= 750) {
                player1Score += 1;
            }
    //Player 1 gains 2 score if the ball touches the left border (5)
            if (ballposX <= 5) {
                player2Score += 1;

    //Intersection with the player pads and the border
    //This prevent the player pads to leave the game board and disappear
    //restricting their movement to keep it in a certain space

    //Player 1 pad intersection with top border
            }
            if (new Rectangle (player1X,player1Y,40,200). intersects(new Rectangle(0,0,790, 5))) {
                player1Y = 5;
    //Player 2 pad intersection with top border
            }
            if (new Rectangle (player2X, player2Y, 40, 200). intersects(new Rectangle(0,0,790, 5))) {
                player2Y = 5;
            }
    //Player 1 pad intersection with bottom border
            if (new Rectangle (player1X,player1Y,40,200). intersects(new Rectangle(0,558,790,558))) {
                player1Y = 359;
            }
    //Player 2 pad intersection with bottom border
            if (new Rectangle (player2X, player2Y, 40, 200). intersects(new Rectangle(0,558,790,558))) {
                player2Y = 359;
            }
    //Ball intersection with player 1 paddle
            if (new Rectangle (ballposX, ballposY, 30, 30).intersects(new Rectangle(player1X, player1Y, 40 ,200)))
            {
                ballXdir = -ballXdir;
            }
    //Ball intersection with player 2 paddle
            if (new Rectangle (ballposX, ballposY, 30, 30). intersects(new Rectangle(player2X, player2Y, 40, 200))) {
                ballXdir = -ballXdir;
            }

    //Direction of the ball
            ballposX -= ballXdir;
            ballposY -= ballYdir;

    //top border
            if(ballposY < 5) {
                ballYdir = -ballYdir;
            }
    //bottom border

            if (ballposY > 527 ) {
                ballYdir = -ballYdir;
            }

            repaint();
        }
    }

    @Override
    //Movement key for Player 1 and Player 2 Paddles

    public void keyPressed(KeyEvent e) {
    //Detect player 1 arrow keys (UP and DOWN)
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (player1Y <= 5) {
                player1Y = 5;
            }
            else {
                moveUp2();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (player1Y >= 560) {
                player1Y = 560;
            }
            else {
                moveDown2();
            }
        }
    //Detect player 2 arrow keys (W and S)
        if (e.getKeyCode() == KeyEvent.VK_W) {
            if (player2Y <= 5) {
                player2Y = 5;
            }
            else {
                moveUp1();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            if (player2Y >= 560) {
                player2Y = 560;
            }
            else {
                moveDown1();
            }
        }

    //Function to Resume the game (R)
    //keeps the score and restarting the position of the player pads and the  ball
        if (e.getKeyCode() == KeyEvent.VK_R) { //Resume
            if (ballposX <= 5 || ballposX >= 750) {
                play = true;
                ballposX = 390;
                ballposY = 260;
                ballXdir = -1;
                ballYdir = -2;
                player1Y = 150;
                player2Y = 150;

            }
        }
    //Function to Restart the game (ENTER)
    //Restarts the score (0:0) and restarts the position of the player pads and the ball
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!play) {
                play = true;
                player1Score = 0;
                player2Score = 0;
                ballposX = 390;
                ballposY = 260;
                ballXdir = -1;
                ballYdir = -2;
                player1Y = 150;
                player2Y = 150;

                repaint();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) { }

    //Method for the Player 1 and 2 Movement
    //If W or S is pressed it will move Up or Down by 27
    //If UP Arrow or DOWN Arrow is pressed it will move Up or Down by 27

    //Player 1 Movement UP (W)
    public void moveUp1() {
        if (ballposX >= 750 || ballposX <= 5) {
            play = false;
        }
        else {
            play = true;
    //How much the player should move when pressed UP (arrow key)
            player1Y -= 27;
        }
    }

    //Player 1 Movement DOWN (S)
    public void moveDown1() {
        if (ballposX >= 750 || ballposX <= 5) {
            play = false;
        }
        else {
            play = true;
    //How much the player should move when pressed DOWN (arrow key)
            player1Y += 27;
        }
    }

    //Player 2 Movement UP (ARROW UP)
    public void moveUp2 () {
        if (ballposX >= 750 || ballposX < 5) {
            play = false;
        }
        else {
            play = true;
    //How much the player should move when pressed UP (W)
            player2Y -=27;
        }
    }

    //Player 2 Movement DOWN (ARROW DOWN)
    public void moveDown2 () {
        if (ballposX >=  750 || ballposX < 5) {
            play = false;
        }
        else {

            play = true;
    //How much the player should move when pressed DOWN (arrow S)
            player2Y += 27;
        }
    }

}