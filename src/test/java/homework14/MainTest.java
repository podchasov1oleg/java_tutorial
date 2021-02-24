package homework14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void sliceAfterFourEmpty() {
        Exception exception = assertThrows(RuntimeException.class, () -> Main.sliceAfterFour(new Integer[]{}));

        String expectedMessage = "Array is empty";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void sliceAfterFourNoFour() {
        Exception exception = assertThrows(RuntimeException.class, () -> Main.sliceAfterFour(new Integer[]{1,2,3,5,6,7,8,9}));

        String expectedMessage = "Array has no 4 value";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void sliceAfterFourLast() {
        assertArrayEquals(new Integer[]{}, Main.sliceAfterFour(new Integer[]{1,2,3,5,6,7,8,4}));
    }

    @Test
    void sliceAfterFourFirst() {
        assertArrayEquals(new Integer[]{2,3,5,6,7,8,0}, Main.sliceAfterFour(new Integer[]{4,2,3,5,6,7,8,0}));
    }

    @Test
    void sliceAfterFourMiddle() {
        assertArrayEquals(new Integer[]{6,7,8,0}, Main.sliceAfterFour(new Integer[]{1,2,3,5,4,6,7,8,0}));
    }

    @Test
    void arrayContainsOnlyOneAndFourCorrect() {
        assertTrue(Main.arrayContainsOnlyOneAndFour(new int[]{1,1,1,4,4,1,4,4}));
    }

    @Test
    void arrayContainsOnlyOneAndFourOnlyOnes() {
        assertFalse(Main.arrayContainsOnlyOneAndFour(new int[]{1,1,1,1,1,1}));
    }

    @Test
    void arrayContainsOnlyOneAndFourOnlyFours() {
        assertFalse(Main.arrayContainsOnlyOneAndFour(new int[]{4,4,4,4}));
    }

    @Test
    void arrayContainsOnlyOneAndFourOutOfRange() {
        assertFalse(Main.arrayContainsOnlyOneAndFour(new int[]{1,4,4,1,1,4,3}));
    }

    @Test
    void arrayContainsOnlyOneAndFourEmpty() {
        assertFalse(Main.arrayContainsOnlyOneAndFour(new int[]{}));
    }
}