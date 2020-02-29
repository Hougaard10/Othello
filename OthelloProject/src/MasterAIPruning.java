@SuppressWarnings("Duplicates")

public class MasterAIPruning implements IOthelloAI {

    private int maxDepth = 9;
    private Position bestMove;

    @Override
    public Position decideMove(GameState s) {
        return minimaxDecision(s);
    }

    public Position minimaxDecision(GameState s) {
        maxValue(s, maxDepth, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return bestMove;
    }

    public int maxValue(GameState s, int depth, int alpha, int beta) {
        int v = Integer.MIN_VALUE;
        if (depth <= 0 || s.isFinished() || s.legalMoves().isEmpty()) {
            return evaluation(s);
        } else {
            for (Position p : s.legalMoves()) {
                int utility = minValue(result(s, p), depth - 1, alpha, beta);
                if (utility >= v) {
                    v = utility;
                    if (depth == maxDepth) {
                        bestMove = p;
                    }
                }
                if (v < beta){
                    beta = v;
                }
                // Beta cut
                if (beta <= alpha) {
                    break;
                }
            }
            return v;
        }
    }

    public int minValue(GameState s, int depth, int alpha, int beta) {
        int v = Integer.MAX_VALUE;
        if (depth <= 0 || s.isFinished() || s.legalMoves().isEmpty()) {
            return evaluation(s);
        } else {
            for (Position p : s.legalMoves()) {
                int utility = maxValue(result(s, p), depth - 1, alpha, beta);
                if (utility <= v) {
                    v = utility;
                    if (depth == maxDepth) {
                        bestMove = p;
                    }
                }
                if (v > alpha){
                    alpha = v;
                }
                // Alpha cut
                if (beta <= alpha) {
                    break;
                }
            }
            return v;
        }
    }

    // Takes a board and a legal move, and returns the resulting board
    public GameState result(GameState s, Position p){
        GameState tempState = new GameState(s.getBoard(), s.getPlayerInTurn());
        tempState.insertToken(p);
        return tempState;
    }

    public int evaluation(GameState s) {
        int[] tokenArray = s.countTokens();

        // Number of white tokens vs. black tokens
        int evaluation = 100 * (tokenArray[1] - tokenArray[0]) / (tokenArray[1] + tokenArray[0]);

        // white corner positions vs black corner positions
        if (countMaxCorners(s) + countMinCorners(s) != 0) {
            evaluation += 100 * (countMaxCorners(s) - countMinCorners(s)) / (countMaxCorners(s) + countMinCorners(s));
        }
        return evaluation;
    }

    // Counts the number of corner positions possessed by white (max)
    public int countMaxCorners(GameState s) {
        int maxCorners = 0;
        int[][] treeBoard = s.getBoard();
        if (treeBoard[0][0] == 2) {
            maxCorners++;
        }
        if (treeBoard[7][0] == 2) {
            maxCorners++;
        }
        if (treeBoard[0][7] == 2) {
            maxCorners++;
        }
        if (treeBoard[7][7] == 2) {
            maxCorners++;
        }
        return maxCorners;
    }

    // Counts the number of corner positions possessed by black (min)
    public int countMinCorners(GameState s) {
        int minCorners = 0;
        int[][] treeBoard = s.getBoard();
        if (treeBoard[0][0] == 1) {
            minCorners++;
        }
        if (treeBoard[7][0] == 1) {
            minCorners++;
        }
        if (treeBoard[0][7] == 1) {
            minCorners++;
        }
        if (treeBoard[7][7] == 1) {
            minCorners++;
        }
        return minCorners;
    }
}