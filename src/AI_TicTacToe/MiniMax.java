/*
 * ===================================================================
 * Copyright © 2018 - All Rights Reserved
 * 
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * 
 * Proprietary and Solely
 * Written by Vivek Rohom <rohomv1@udayton.edu>
 * ===================================================================
 */
package AI_TicTacToe;

/**
 *
 * @author Vivek
 */
public class MiniMax {

    static class Move {

        int row, col;
    };

    static String computer = "O", human = "X";

    static Boolean isMovesLeft(String board[][]) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == "   ") {
                    return true;
                }
            }
        }
        return false;
    }

    static int evaluate(String b[][]) {
        for (int row = 0; row < 3; row++) {
            if (b[row][0].equals(b[row][1])
                    && b[row][1].equals(b[row][2])) {
                if (b[row][0].equals(computer)) {
                    return +10;
                } else if (b[row][0].equals(human)) {
                    return -10;
                }
            }
        }

        for (int col = 0; col < 3; col++) {
            if (b[0][col].equals(b[1][col])
                    && b[1][col].equals(b[2][col])) {
                if (b[0][col].equals(computer)) {
                    return +10;
                } else if (b[0][col].equals(human)) {
                    return -10;
                }
            }
        }

        if (b[0][0].equals(b[1][1]) && b[1][1].equals(b[2][2])) {
            if (b[0][0].equals(computer)) {
                return +10;
            } else if (b[0][0].equals(human)) {
                return -10;
            }
        }

        if (b[0][2].equals(b[1][1]) && b[1][1].equals(b[2][0])) {
            if (b[0][2].equals(computer)) {
                return +10;
            } else if (b[0][2].equals(human)) {
                return -10;
            }
        }
        return 0;
    }

    static int minimax(String board[][],
            int depth, Boolean isMax) {
        int score = evaluate(board);
        if (score == 10) {
            return score;
        }
        if (score == -10) {
            return score;
        }
        if (isMovesLeft(board) == false) {
            return 0;
        }
        if (isMax) {
            int best = -1000;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j].equals("   ")) {
                        board[i][j] = computer;
                        best = Math.max(best, minimax(board,
                                depth + 1, !isMax));
                        board[i][j] = "   ";
                    }
                }
            }
            return best;
        } else {
            int best = 1000;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j].equals("   ")) {
                        board[i][j] = human;
                        best = Math.min(best, minimax(board,
                                depth + 1, !isMax));
                        board[i][j] = "   ";
                    }
                }
            }
            return best;
        }
    }

    static Move findOptimalMove(String board[][]) {
        int bestVal = -1000;
        Move bestMove = new Move();
        bestMove.row = -1;
        bestMove.col = -1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals("   ")) {
                    board[i][j] = computer;
                    int moveVal = minimax(board, 0, false);
                    board[i][j] = "   ";
                    if (moveVal > bestVal) {
                        bestMove.row = i;
                        bestMove.col = j;
                        bestVal = moveVal;
                    }
                }
            }
        }
        return bestMove;
    }
}
