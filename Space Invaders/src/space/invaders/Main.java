package space.invaders;

public class Main {

    public static final int SIZE = 32;
    
    public static int getSize()
    {
        return SIZE;
    }
    
    
    public static void main(String[] args) {
	    Board board = new Board();

	    board.run();
    }
}
