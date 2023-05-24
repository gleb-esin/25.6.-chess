public class King extends ChessPiece {
    private String Piece = "K";

    public King(String color) {
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

        //the King can't move more than 1 cell
        if ((Math.abs(toLine - line) > 1) || (Math.abs(toColumn - column) > 1)) return false;

        return true;
    }

    @Override
    String getSymbol() {
        return Piece;
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        if (board.castling0) {
            // WHITE KING
            if (getColor().equals("White")) {
                //horse - work
                if (board.board[line + 2][column - 1] != null && board.board[line + 2][column - 1].getSymbol().equals("H")
                        && board.board[line + 2][column - 1].getColor().equals("Black")) return true;
                if (board.board[line + 2][column + 1] != null && board.board[line + 2][column + 1].getSymbol().equals("H")
                        && board.board[line + 2][column + 1].getColor().equals("Black")) return true;
                if (board.board[line + 1][column + 2] != null && board.board[line + 1][column + 2].getSymbol().equals("H")
                        && board.board[line + 1][column + 2].getColor().equals("Black")) return true;
                if (board.board[line + 1][column - 2] != null && board.board[line + 1][column - 2].getSymbol().equals("H")
                        && board.board[line + 1][column - 2].getColor().equals("Black")) return true;

                //if king protected by own pawns
                if (board.board[line + 1][column - 2] != null && board.board[line + 1][column - 2].getSymbol().equals("P")
                        && board.board[line + 1][column - 2].getColor().equals("White")
                        &&
                        board.board[line + 1][column - 1] != null && board.board[line + 1][column - 1].getSymbol().equals("P")
                        && board.board[line + 1][column - 1].getColor().equals("White")
                        &&
                        board.board[line + 1][column] != null && board.board[line + 1][column].getSymbol().equals("P")
                        && board.board[line + 1][column].getColor().equals("White")
                        &&
                        board.board[line + 1][column + 1] != null && board.board[line + 1][column + 1].getSymbol().equals("P")
                        && board.board[line + 1][column + 1].getColor().equals("White")) {
                    return false;
                }

                //rook or queen - work
                if (board.board[line + 1][column] == null || (board.board[line + 1][column] != null && (board.board[line + 1][column].getSymbol().equals("Q") || board.board[line + 1][column].getSymbol().equals("R")) &&
                        (board.board[line + 1][column].getColor().equals("Black")))) {
                    boolean queenOrRook = false;
                    for (int i = 1; i < 8; i++) {
                        if (board.board[i][column] != null &&
                                (board.board[i][column].getSymbol().equals("Q") || board.board[i][column].getSymbol().equals("R")) &&
                                (board.board[i][column].getColor().equals("Black"))) queenOrRook = true;
                    }
                    if (queenOrRook) return true;
                }

                //bishop or queen - work
                if (board.board[line + 1][column - 1] != null &&
                        (board.board[line + 1][column - 1].getSymbol().equals("Q") || board.board[line + 1][column - 1].getSymbol().equals("B")) &&
                        board.board[line + 1][column - 1].getColor().equals("Black")) return true;
                if (board.board[line + 2][column - 2] != null && board.board[line + 1][column - 1] == null &&
                        (board.board[line + 2][column - 2].getSymbol().equals("Q") || board.board[line + 2][column - 2].getSymbol().equals("B")) &&
                        board.board[line + 2][column - 2].getColor().equals("Black")) return true;
                if (board.board[line + 1][column + 1] != null &&
                        (board.board[line + 1][column + 1].getSymbol().equals("Q") || board.board[line + 1][column + 1].getSymbol().equals("B")) &&
                        board.board[line + 1][column + 1].getColor().equals("Black")) return true;
                if (board.board[line + 1][column + 1] == null) {
                    boolean queenOrBishop = false;
                    for (int i = 1; i < 7; i++) {
                        for (int k = 3; k < 8; k++) {
                            if (board.board[i][k] != null &&
                                    (board.board[i][k].getSymbol().equals("Q") || board.board[i][k].getSymbol().equals("B")) &&
                                    board.board[i][k].getColor().equals("Black")) queenOrBishop = true;
                        }
                        if (queenOrBishop) return true;
                    }
                }
                //pawns - work
                if (board.board[line + 1][column - 1] != null &&
                        board.board[line + 1][column - 1].getSymbol().equals("P") &&
                        board.board[line + 1][column - 1].getColor().equals("Black")
                ) return true;
                if (board.board[line + 1][column + 1] != null &&
                        board.board[line + 1][column + 1].getSymbol().equals("P") &&
                        board.board[line + 1][column + 1].getColor().equals("Black")
                ) return true;
            }


            // BLACK KING
            //horse - work
            System.out.println(board.board[line - 2][column + 1]);
            if (board.board[line - 2][column - 1] != null && board.board[line - 2][column - 1].getSymbol().equals("H")
                    && board.board[line - 2][column - 1].getColor().equals("White")) return true;
            if (board.board[line - 2][column + 1] != null && board.board[line - 2][column + 1].getSymbol().equals("H")
                    && board.board[line - 2][column + 1].getColor().equals("White")) return true;
            if (board.board[line - 1][column - 2] != null && board.board[line - 1][column - 2].getSymbol().equals("H")
                    && board.board[line - 1][column - 2].getColor().equals("White")) return true;

            //if king protected by own pawns
            if (board.board[line - 1][column - 2] != null && board.board[line - 1][column - 2].getSymbol().equals("P")
                    && board.board[line - 1][column - 2].getColor().equals("Black")
                    &&
                    board.board[line - 1][column - 1] != null && board.board[line - 1][column - 1].getSymbol().equals("P")
                    && board.board[line - 1][column - 1].getColor().equals("Black")
                    &&
                    board.board[line - 1][column] != null && board.board[line - 1][column].getSymbol().equals("P")
                    && board.board[line - 1][column].getColor().equals("Black")
                    &&
                    board.board[line - 1][column + 1] != null && board.board[line - 1][column + 1].getSymbol().equals("P")
                    && board.board[line - 1][column + 1].getColor().equals("Black")) return false;

            //rook or queen - work
            if (board.board[line - 1][column] == null || ((board.board[line - 1][column].getSymbol().equals("Q") || board.board[line - 1][column].getSymbol().equals("R")) &&
                    (board.board[line - 1][column].getColor().equals("White")))) {
                boolean queenOrRook = false;
                for (int i = 6; i >= 0; i--) {
                    if (board.board[i][column] != null &&
                            (board.board[i][column].getSymbol().equals("Q") || board.board[i][column].getSymbol().equals("R")) &&
                            (board.board[i][column].getColor().equals("White"))) queenOrRook = true;
                }
                if (queenOrRook) return true;
            }

            //bishop or queen - work
            if (board.board[line - 1][column - 1] != null &&
                    (board.board[line - 1][column - 1].getSymbol().equals("Q") || board.board[line - 1][column - 1].getSymbol().equals("B")) &&
                    board.board[line - 1][column - 1].getColor().equals("White")) return true;
            if (board.board[line - 2][column - 2] != null && board.board[line - 1][column - 1] == null &&
                    (board.board[line - 2][column - 2].getSymbol().equals("Q") || board.board[line - 2][column - 2].getSymbol().equals("B")) &&
                    board.board[line - 2][column - 2].getColor().equals("White")) return true;
            if (board.board[line - 1][column + 1] != null &&
                    (board.board[line - 1][column + 1].getSymbol().equals("Q") || board.board[line - 1][column + 1].getSymbol().equals("B")) &&
                    board.board[line - 1][column + 1].getColor().equals("White")) return true;
            if (board.board[line - 1][column + 1] == null) {
                boolean queenOrBishop = false;
                for (int i = 6; i >= 0; i--) {
                    for (int k = 3; k < 8; k++) {
                        if (board.board[i][k] != null &&
                                (board.board[i][k].getSymbol().equals("Q") || board.board[i][k].getSymbol().equals("B")) &&
                                board.board[i][k].getColor().equals("White")) queenOrBishop = true;
                    }
                    if (queenOrBishop) return true;
                }
            }
            //pawns -work
            if (board.board[line - 1][column - 1] != null &&
                    board.board[line - 1][column - 1].getSymbol().equals("P") &&
                    board.board[line - 1][column - 1].getColor().equals("White")
            ) return true;
            if (board.board[line - 1][column + 1] != null &&
                    board.board[line - 1][column + 1].getSymbol().equals("P") &&
                    board.board[line - 1][column + 1].getColor().equals("White")
            ) return true;

            return false;
        }


        if (board.castling7) {
            if (getColor().equals("White")) {
                // WHITE KING
                //horse - work
                if (board.board[line + 2][column - 1] != null && board.board[line + 2][column - 1].getSymbol().equals("H")
                        && board.board[line + 2][column - 1].getColor().equals("Black")) return true;
                if (board.board[line + 2][column + 1] != null && board.board[line + 2][column + 1].getSymbol().equals("H")
                        && board.board[line + 2][column + 1].getColor().equals("Black")) return true;
                if (board.board[line + 1][column - 2] != null && board.board[line + 1][column - 2].getSymbol().equals("H")
                        && board.board[line + 1][column - 2].getColor().equals("Black")) return true;

                //if king protected by own pawns - ?
                if (board.board[line + 1][column - 1] != null && board.board[line + 1][column - 1].getSymbol().equals("P")
                        && board.board[line + 1][column - 1].getColor().equals("White")
                        &&
                        board.board[line + 1][column] != null && board.board[line + 1][column].getSymbol().equals("P")
                        && board.board[line + 1][column].getColor().equals("White")
                        &&
                        board.board[line + 1][column + 1] != null && board.board[line + 1][column + 1].getSymbol().equals("P")
                        && board.board[line + 1][column + 1].getColor().equals("White")) {
                    return false;
                }

                //rook or queen - work
                if (board.board[line + 1][column] == null ||((board.board[line + 1][column].getSymbol().equals("Q") || board.board[line + 1][column].getSymbol().equals("R")) &&
                        (board.board[line + 1][column].getColor().equals("Black")))) {
                    boolean queenOrRook = false;
                    for (int i = 2; i < 8; i++) {
                        if (board.board[i][column] != null &&
                                (board.board[i][column].getSymbol().equals("Q") || board.board[i][column].getSymbol().equals("R")) &&
                                (board.board[i][column].getColor().equals("Black"))) queenOrRook = true;
                    }
                    if (queenOrRook) return true;
                }

                //bishop or queen -
                if (board.board[line + 1][column + 1] != null &&
                        (board.board[line + 1][column + 1].getSymbol().equals("Q") || board.board[line + 1][column + 1].getSymbol().equals("B")) &&
                        board.board[line + 1][column + 1].getColor().equals("Black")) return true;
                if (board.board[line + 1][column - 1] == null) {
                    boolean queenOrBishop = false;
                    for (int i = 1; i < 7; i++) {
                        for (int k = 6; k >= 0; k--) {
                            if (board.board[i][k] != null &&
                                    (board.board[i][k].getSymbol().equals("Q") || board.board[i][k].getSymbol().equals("B")) &&
                                    board.board[i][k].getColor().equals("Black")) queenOrBishop = true;
                        }
                        if (queenOrBishop) return true;
                    }
                }

                //pawns - work
                if (board.board[line + 1][column - 1] != null &&
                        board.board[line + 1][column - 1].getSymbol().equals("P") &&
                        board.board[line + 1][column - 1].getColor().equals("Black")
                ) return true;
                if (board.board[line + 1][column + 1] != null &&
                        board.board[line + 1][column + 1].getSymbol().equals("P") &&
                        board.board[line + 1][column + 1].getColor().equals("Black")
                ) return true;
            }
        }


        // BLACK KING
        //horse - work
        if (getColor().equals("Black")) {
            if (board.board[line - 2][column - 1] != null && board.board[line - 2][column - 1].getSymbol().equals("H")
                    && board.board[line - 2][column - 1].getColor().equals("White")) return true;
            if (board.board[line - 2][column + 1] != null && board.board[line - 2][column + 1].getSymbol().equals("H")
                    && board.board[line - 2][column + 1].getColor().equals("White")) return true;
            if (board.board[line - 1][column - 2] != null && board.board[line - 1][column - 2].getSymbol().equals("H")
                    && board.board[line - 1][column - 2].getColor().equals("White")) return true;

            //if king protected by own pawns - ?
            if (
                    board.board[line - 1][column - 1] != null && board.board[line - 1][column - 1].getSymbol().equals("P")
                            && board.board[line - 1][column - 1].getColor().equals("Black")
                            &&
                            board.board[line - 1][column] != null && board.board[line - 1][column].getSymbol().equals("P")
                            && board.board[line - 1][column].getColor().equals("Black")
                            &&
                            board.board[line - 1][column + 1] != null && board.board[line - 1][column + 1].getSymbol().equals("P")
                            && board.board[line - 1][column + 1].getColor().equals("Black")) return false;

            //rook or queen - work
            if (board.board[line - 1][column] == null || ((board.board[line - 1][column].getSymbol().equals("Q") || board.board[line - 1][column].getSymbol().equals("R")) &&
                    (board.board[line - 1][column].getColor().equals("White")))) {
                boolean queenOrRook = false;
                for (int i = 6; i >= 0; i--) {
                    if (board.board[i][column] != null &&
                            (board.board[i][column].getSymbol().equals("Q") || board.board[i][column].getSymbol().equals("R")) &&
                            (board.board[i][column].getColor().equals("White"))) queenOrRook = true;
                }
                if (queenOrRook) return true;
            }

            //bishop or queen - work
            if (board.board[line - 1][column - 1] != null &&
                    (board.board[line - 1][column - 1].getSymbol().equals("Q") || board.board[line - 1][column - 1].getSymbol().equals("B")) &&
                    board.board[line - 1][column - 1].getColor().equals("White")) return true;
            if (board.board[line - 2][column - 2] != null && board.board[line - 1][column - 1] == null &&
                    (board.board[line - 2][column - 2].getSymbol().equals("Q") || board.board[line - 2][column - 2].getSymbol().equals("B")) &&
                    board.board[line - 2][column - 2].getColor().equals("White")) return true;
            if (board.board[line - 1][column + 1] != null &&
                    (board.board[line - 1][column + 1].getSymbol().equals("Q") || board.board[line - 1][column + 1].getSymbol().equals("B")) &&
                    board.board[line - 1][column + 1].getColor().equals("White")) return true;
            if (board.board[line - 1][column + 1] == null) {
                boolean queenOrBishop = false;
                for (int i = 6; i >= 0; i--) {
                    for (int k = 3; k < 8; k++) {
                        if (board.board[i][k] != null &&
                                (board.board[i][k].getSymbol().equals("Q") || board.board[i][k].getSymbol().equals("B")) &&
                                board.board[i][k].getColor().equals("White")) queenOrBishop = true;
                    }
                    if (queenOrBishop) return true;
                }
            }
            //pawns - work
            if (board.board[line - 1][column - 1] != null &&
                    board.board[line - 1][column - 1].getSymbol().equals("P") &&
                    board.board[line - 1][column - 1].getColor().equals("White")
            ) return true;
            if (board.board[line - 1][column + 1] != null &&
                    board.board[line - 1][column + 1].getSymbol().equals("P") &&
                    board.board[line - 1][column + 1].getColor().equals("White")
            ) return true;
        }

        return false;
    }
}


