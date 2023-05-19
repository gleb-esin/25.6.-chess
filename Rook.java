public class Rook extends ChessPiece implements CheckTrajectory{
    private String Piece = "R";
    public Rook(String color) {
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
        //a rook can move only in one direction
        if (Math.abs(toColumn-column) > 0 && Math.abs(toLine-line) > 0) return false;
        if (isThereAnObstacle(chessBoard, line, column, toLine, toColumn)) {
            return false;
        }
        return true;
    }

    @Override
    String getSymbol() {
        return Piece;
    }
}
