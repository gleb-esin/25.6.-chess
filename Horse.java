public class Horse extends ChessPiece implements CheckTrajectory {
    private String Piece = "H";

    public Horse(String color) {
        super(color);
    }

    @Override
    String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        //piece can't move to the same cell - work
        if ((line == toLine) && (column == toColumn)) return false;
        //piece can't go out the chess board - work
        if (toLine > 7 || toLine < 0 || toColumn < 0 || toColumn > 7) return false;
        //horse can move vertically in range between 2 and 1 - work
        if (Math.abs(toLine - line) > 2 || Math.abs(toLine - line) < 1) return false;
        //horse can move horizontally in range between 2 and 1 - work
        if (Math.abs(toColumn - column) > 2 || (Math.abs(toColumn - column) < 1)) return false;
        //horse must change line and column - work
        if (Math.abs(line - toLine) <= 0 && Math.abs(toColumn - column) <= 0) return false;
        //horse can't move diagonally
        if (Math.abs(line - toLine) == Math.abs(toColumn - column)) return false;
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
