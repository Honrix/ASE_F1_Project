package dhbw.projects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInputAdapterTest {

    @Test
    void validateDateInput() {
        UserInputAdapter userInputAdapter = new UserInputAdapter();
        String wrongDate1 = "2222222";
        String wrongDate2 = "adsad22s";
        String correctDate1 = "20200212";
        String correctDate2 = "12341230";
        assertFalse(userInputAdapter.validateDateInput(wrongDate1));
        assertFalse(userInputAdapter.validateDateInput(wrongDate2));
        assertTrue(userInputAdapter.validateDateInput(correctDate1));
        assertTrue(userInputAdapter.validateDateInput(correctDate2));

    }

    @Test
    void validateInputOfRange() {
        UserInputAdapter userInputAdapter = new UserInputAdapter();
        assertTrue(userInputAdapter.validateInputOfRange("1", 20));
        assertTrue(userInputAdapter.validateInputOfRange("20", 20));
        assertTrue(userInputAdapter.validateInputOfRange("6", 13));
        assertTrue(userInputAdapter.validateInputOfRange("49", 50));
        assertFalse(userInputAdapter.validateInputOfRange("-1", 10));
        assertFalse(userInputAdapter.validateInputOfRange("0", 10));
        assertFalse(userInputAdapter.validateInputOfRange("12", 11));
        assertFalse(userInputAdapter.validateInputOfRange("hallo", 13));
    }

    @Test
    void validateConfirmationInput() {
        UserInputAdapter userInputAdapter = new UserInputAdapter();
        assertTrue(userInputAdapter.validateConfirmationInput("Y"));
        assertTrue(userInputAdapter.validateConfirmationInput("N"));
        assertFalse(userInputAdapter.validateConfirmationInput("Test"));
        assertFalse(userInputAdapter.validateConfirmationInput("y"));
        assertFalse(userInputAdapter.validateConfirmationInput("n"));
        assertFalse(userInputAdapter.validateConfirmationInput("1"));


    }

    @Test
    void confirmUserInput() {
        UserInputAdapter userInputAdapter = new UserInputAdapter();
        assertTrue(userInputAdapter.confirmUserInput("Y"));
        assertFalse(userInputAdapter.confirmUserInput("y"));
        assertFalse(userInputAdapter.confirmUserInput("32"));
    }

    @Test
    void validateLaptime() {
        UserInputAdapter userInputAdapter = new UserInputAdapter();
        assertTrue(userInputAdapter.validateLaptime("1.123"));
        assertTrue(userInputAdapter.validateLaptime("12.345"));
        assertTrue(userInputAdapter.validateLaptime("123.456"));
        assertFalse(userInputAdapter.validateLaptime("Test"));
        assertFalse(userInputAdapter.validateLaptime("1234.567"));
        assertFalse(userInputAdapter.validateLaptime(".123"));
        assertFalse(userInputAdapter.validateLaptime("1.12"));
        assertFalse(userInputAdapter.validateLaptime("1.1 "));
        assertFalse(userInputAdapter.validateLaptime("1."));
        assertFalse(userInputAdapter.validateLaptime("10"));

    }

    @Test
    void getOutputString() {
        UserInputAdapter userInputAdapter = new UserInputAdapter();
        assertEquals(userInputAdapter.getOutputString(), "");
    }
}