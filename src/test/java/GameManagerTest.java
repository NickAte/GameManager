import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameManagerTest {

    Game game = new Game();
    Player p1 = new Player(1, "Kolya", 10);
    Player p2 = new Player(2, "Olya", 20);
    Player p3 = new Player(3, "Anya", 30);
    Player p4 = new Player(4, "Petya", 40);
    Player p5 = new Player(5, "Nikita", 40);

    @Test
    public void NotRegistered() {
        game.register(p1);
        game.register(p2);
        game.register(p3);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("unknown1", "unknown2");
        });
    }

    @Test
    public void OneNotRegistered() {
        game.register(p1);
        game.register(p2);
        game.register(p3);

        assertThrows(NotRegisteredException.class, () -> {
            game.round(p1.getName(), "unknown2");
        });
    }

    @Test
    public void TwoNotRegistered() {
        game.register(p1);
        game.register(p2);
        game.register(p3);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("unknown1", p2.getName());
        });
    }

    @Test
    public void PlayerOneWin() {
        game.register(p1);
        game.register(p2);
        game.register(p3);

            int actual = game.round(p1.getName(), p2.getName());
            int expected = 2;
        }

    @Test
    public void PlayerTwoWin() {
        game.register(p2);
        game.register(p4);
        game.register(p5);

        int actual = game.round(p2.getName(), p5.getName());
        int expected = 1;
    }

    @Test
    public void NobodyWin() {
        game.register(p2);
        game.register(p4);
        game.register(p5);

        int actual = game.round(p4.getName(), p5.getName());
        int expected = 0;
    }
}
