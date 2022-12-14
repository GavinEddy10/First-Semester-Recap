public class GameBoard {

    private int[][] board;

    private Texture emptyTile;
    private Texture questionTile;
    private Texture bombTile;
    private Texture emptyFloor;

    private static final int BOMB = 9, EMPTYTILE = 10, FLAGGEDTILE = 20, QUESTIONTILE = 30;

    public GameBoard() {
        board = new int[16][30];
        initEmptyBoard();

        //load all textures
        emptyTile = new Texture("emptyTile.jpg");
    }

    public boolean isValidLoc(int row, int col) {
        return row>= 0 && row<board.length &&
                col >= 0 && col < board[0].length;
    }
    public void handleClick(int x, int y) {
        //change windows (x,y) coordinate to 2D array loc
        int rowClicked = (y-10)/25;
        int colClicked = (x-10)/25;

        if (isValidLoc(rowClicked,colClicked)) {
            board[rowClicked][colClicked] = 0;
        }
    }

    private void placeBombs() {

    }
    public void draw(SpriteBatch spriteBatch) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board.length; column++) {
                //if we have an empty tile
                if (board[row][0] >= EMPTYTILE && board[row][0] < FLAGGEDTILE) {
                    spriteBatch.draw(emptyTile, (10) + (column * 25) ,  (600-35) - (row * 25));
                }
            }
        }
    }
    private void initEmptyBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = 10;
            }

        }
    }
}
