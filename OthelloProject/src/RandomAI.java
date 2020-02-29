import java.util.ArrayList;

public class RandomAI implements IOthelloAI {

    public Position decideMove(GameState s) {
        ArrayList<Position> moves = s.legalMoves();
        if (!moves.isEmpty())
            return moves.get((int) (Math.random() * ((moves.size() - 1) + 1)));
        else
            return new Position(-1, -1);
    }
}
