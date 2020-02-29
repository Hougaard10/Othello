import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OldAI implements IOthelloAI {

    Map<Position, Integer> ScoreMap;

    public OldAI() {
        ScoreMap = new HashMap<>();
        ScoreMap.put(new Position(0, 0), 120);
        ScoreMap.put(new Position(0, 1), -20);
        ScoreMap.put(new Position(0, 2), 20);
        ScoreMap.put(new Position(0, 3), 5);
        ScoreMap.put(new Position(0, 4), 5);
        ScoreMap.put(new Position(0, 5), 20);
        ScoreMap.put(new Position(0, 6), -20);
        ScoreMap.put(new Position(0, 7), 120);

        ScoreMap.put(new Position(1, 0), -20);
        ScoreMap.put(new Position(1, 1), -40);
        ScoreMap.put(new Position(1, 2), -5);
        ScoreMap.put(new Position(1, 3), -5);
        ScoreMap.put(new Position(1, 4), -5);
        ScoreMap.put(new Position(1, 5), -5);
        ScoreMap.put(new Position(1, 6), -40);
        ScoreMap.put(new Position(1, 7), -20);

        ScoreMap.put(new Position(2, 0), 20);
        ScoreMap.put(new Position(2, 1), -5);
        ScoreMap.put(new Position(2, 2), 15);
        ScoreMap.put(new Position(2, 3), 3);
        ScoreMap.put(new Position(2, 4), 3);
        ScoreMap.put(new Position(2, 5), 15);
        ScoreMap.put(new Position(2, 6), -5);
        ScoreMap.put(new Position(2, 7), 20);

        ScoreMap.put(new Position(3, 0), 5);
        ScoreMap.put(new Position(3, 1), -5);
        ScoreMap.put(new Position(3, 2), 3);
        ScoreMap.put(new Position(3, 3), 3);
        ScoreMap.put(new Position(3, 4), 3);
        ScoreMap.put(new Position(3, 5), 3);
        ScoreMap.put(new Position(3, 6), -5);
        ScoreMap.put(new Position(3, 7), -5);

        ScoreMap.put(new Position(4, 0), 5);
        ScoreMap.put(new Position(4, 1), -5);
        ScoreMap.put(new Position(4, 2), 3);
        ScoreMap.put(new Position(4, 3), 3);
        ScoreMap.put(new Position(4, 4), 3);
        ScoreMap.put(new Position(4, 5), 3);
        ScoreMap.put(new Position(4, 6), -5);
        ScoreMap.put(new Position(4, 7), -5);

        ScoreMap.put(new Position(5, 0), 20);
        ScoreMap.put(new Position(5, 1), -5);
        ScoreMap.put(new Position(5, 2), 15);
        ScoreMap.put(new Position(5, 3), 3);
        ScoreMap.put(new Position(5, 4), 3);
        ScoreMap.put(new Position(5, 5), 15);
        ScoreMap.put(new Position(5, 6), -5);
        ScoreMap.put(new Position(5, 7), 20);

        ScoreMap.put(new Position(6, 0), -20);
        ScoreMap.put(new Position(6, 1), -40);
        ScoreMap.put(new Position(6, 2), -5);
        ScoreMap.put(new Position(6, 3), -5);
        ScoreMap.put(new Position(6, 4), -5);
        ScoreMap.put(new Position(6, 5), -5);
        ScoreMap.put(new Position(6, 6), -40);
        ScoreMap.put(new Position(6, 7), -20);

        ScoreMap.put(new Position(7, 0), 120);
        ScoreMap.put(new Position(7, 1), -20);
        ScoreMap.put(new Position(7, 2), 20);
        ScoreMap.put(new Position(7, 3), 5);
        ScoreMap.put(new Position(7, 4), 5);
        ScoreMap.put(new Position(7, 5), 20);
        ScoreMap.put(new Position(7, 6), -20);
        ScoreMap.put(new Position(7, 7), 120);
    }

    public Position decideMove(GameState s) {
        ArrayList<Position> moves = s.legalMoves();
        Position bestMove = new Position(-1, -1);
        int bestScore = -40;
        if (!moves.isEmpty()) {
            for (Position p : moves) {
                for (Position ps : ScoreMap.keySet()) {
                    if (p.equals(ps)) {
                        if (ScoreMap.get(ps) >= bestScore) {
                            bestScore = ScoreMap.get(ps);
                            bestMove = p;
                        }
                    }
                }
            }
            return bestMove;
        }
         else{
            return bestMove;
        }
    }
}
