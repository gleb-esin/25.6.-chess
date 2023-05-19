import java.util.ArrayList;

public interface CheckTrajectory {
    default boolean isThereAnObstacle(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        ArrayList<ChessPiece> trajectory = new ArrayList<>();
        //add cells to the trajectory
        //if a trajectory is horizontal
        if (line == toLine) {
            for (int i = column+1; i < toColumn; i++) {
                trajectory.add(chessBoard.board[line][i]);
            }
        }
        //if a trajectory is vertical
        if (column == toColumn) {
            for (int i = line+1; i < toLine; i++) {
                trajectory.add(chessBoard.board[i][column]);
            }
        }
        //if a trajectory is diagonal
        if (Math.abs(column - toColumn) == Math.abs(line - toLine)) {
            for (int i = line+1, k = column+1; i < toLine; i++, k++) {
                trajectory.add(chessBoard.board[i][k]);
            }
        }

        for (ChessPiece i: trajectory) {
            if (i != null) return true;
        }
        return false;
    }
}