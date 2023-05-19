import java.util.Objects;

public class Pawn extends ChessPiece implements CheckTrajectory {
    private String Piece = "P";

    public Pawn(String color) {
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

        //a pawn in the first move can move on to 1 or 2 cells - work
        if ((line == 1 && getColor().equals("White")) && (toLine - line > 2)) return false;
        if (line == 6 && getColor().equals("Black") && (line - toLine > 2)) return false;

        //in a case is not the first move, a pawn can move only one cell - work
        if ((line != 1 && getColor().equals("White")) && (toLine - line > 1)) return false;
        if (line != 6 && getColor().equals("Black") && (line - toLine > 1)) return false;

        //a pawn can move only forward
        if ((getColor().equals("White")) && toLine <= line) return false;
        if ((getColor().equals("Black")) && line <= toLine) return false;

        // a pawn must move only straight if it doesn't eat another piece
        if (getColor().equals("White")) {
            if (chessBoard.board[toLine][toColumn] == null) {
                if (column != toColumn) return false;
            } else {
                if (Math.abs(toColumn - column) != 1 && toLine - line != 1) return false;
            }
        }
        if (getColor().equals("Black")) {
            if (chessBoard.board[toLine][toColumn] == null) {
                if (column != toColumn) return false;
            } else {
                if (Math.abs(toColumn - column) != 1 && line - toLine != 1) return false;
            }
        }

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