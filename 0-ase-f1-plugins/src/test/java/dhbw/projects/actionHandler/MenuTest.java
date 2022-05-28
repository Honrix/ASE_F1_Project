package dhbw.projects.actionHandler;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class MenuTest {

    @Test
    void insertUserOption() {
        Menu menu = new Menu("Test");
        UserOptions userOptions = mock(UserOptions.class);
        String key = "1";
        Map<String, UserOptions> options = new HashMap<>();
        options.put(key, userOptions);
        menu.insertUserOption(key, userOptions);

        assertEquals(userOptions.getClass(), menu.getUserOption(key).getClass());
    }
}