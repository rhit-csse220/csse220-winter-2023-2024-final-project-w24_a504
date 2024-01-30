package mainApp;

public class Player {
    private int lives;
    private int x;
    private int y;
    private int speed;
    private boolean isMovingRight;

    public Player(int lives, int startX, int startY, int speed) {
        this.lives = lives;
        this.x = startX;
        this.y = startY;
        this.speed = speed;
        this.isMovingRight = true;
    }

    public void moveRight() {
        if (isMovingRight) {
            x += speed;
        }
    }

    public void moveUp() {
        y -= speed; 
    }

    public void stopMoving() {
        isMovingRight = false;
    }
}