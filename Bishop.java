public class Bishop extends ChessPiece implements CheckTrajectory {
    private String Piece = "B";

    public Bishop(String color) {
        super(color);
    }

    @Override
    String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        //a piece can't move to the same cell - work
        if ((line == toLine) && (column == toColumn)) return false;
        //a piece can't go out the chess board - work
        if (toLine > 7 || toLine < 0 || toColumn < 0 || toColumn > 7) return false;

        //a bishop must move only diagonally
        if (Math.abs(toLine - line) != Math.abs(toColumn - column)) return false;

        if (isThereAnObstacle(chessBoard, line, column, toLine, toColumn)) return false;

        return true;
    }

    @Override
    String getSymbol() {
        return Piece;
    }
}
