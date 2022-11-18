import static org.junit.jupiter.api.Assertions.*;

import java.util.logging.Logger;

import app.StringOperations;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class StringOperationsTest {

    public StringOperations stringOperations;
    static Logger log = Logger.getLogger(StringOperationsTest.class.getName());


    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        log.info("BeforeAll");
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        log.info("AfterAll");
    }

    @BeforeEach
    void setUp() throws Exception {
        log.info("BeforeEach");
        stringOperations = new StringOperations();
    }

    @AfterEach
    void tearDown() throws Exception {
        log.info("AfterEach");
        stringOperations = null;
    }

    @Test
    @DisplayName("Test is palindrome true")
    void testIsPanlindromeTrue() {

        assertTrue(stringOperations.isPalindrome("ABCBA"));
    }

    @Test
    void testIsPalindromeFalse() {
        assertFalse(stringOperations.isPalindrome("ABCB"));
    }

    @Test
    void testIsPalindromeEmptyString() {
        assertTrue(stringOperations.isPalindrome(""));
    }

    @Test
    void testIsPalindromeOneLetterString() {
        assertTrue(stringOperations.isPalindrome("1"));
    }

    @Test
    void testIsPalindromeWithOneSpace() {
        assertTrue(stringOperations.isPalindrome("a bcba"));
    }

    @Test
    void testIsPalindromeWithTwoSpaces() {
        assertTrue(stringOperations.isPalindrome("a bcb a"));
    }

    @Test
    void testReverseOneWord() {
        assertEquals("nymE", stringOperations.reverse("Emyn"));
    }

    @Test
    void testReverseOneLetterWord() {
        assertEquals("E", stringOperations.reverse("E"));
    }

    @Test
    void testReverseOneSpaceWord() {
        assertEquals(" ", stringOperations.reverse(" "));
    }

    @Test
    void testReverseZeroLengthWord() {
        assertEquals("", stringOperations.reverse(""));
    }

    @Test
    void testConcatTwoWords() {
        assertEquals("I am happy", stringOperations.concat("I am", " happy"));
    }

    @Test
    void testConcatTwoSpaces() {
        assertEquals("  ", stringOperations.concat(" ", " "));
    }

    @Test
    void testConcatTwoZeroLenghtStrings() {
        assertEquals( null , stringOperations.concat("", ""));
    }

}

