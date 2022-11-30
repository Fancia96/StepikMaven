
import app.StringOperations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Supplier;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringOperationsHamcrestTest {

    private StringOperations stringOperations;

    @Before
    public void setUp() throws Exception {
        stringOperations = new StringOperations();
    }

    @Test
    public void createInstance(){
        assertThat(stringOperations.getClass(), is(StringOperations.class));
    }

    @Test
    public void testIsPanlindromeTrue() {
        assertThat(stringOperations.isPalindrome("ABCBA"), equalTo(true));

    }

    @Test
    public void testIsPalindromeFalse() {
        boolean isPalindrome = stringOperations.isPalindrome("ABCB");
        assertThat(isPalindrome, is(not(true)));
    }

    @Test
    public void testIsPalindromeEmptyString() {
        assertThat(stringOperations.isPalindrome(""), is(true));
    }

    @Test
    public void testIsPalindromeOneLetterString() {
        assertThat(stringOperations.isPalindrome("1"), is(not(false)));
    }

    @Test
    public void testIsPalindromeWithOneSpace() {
        assertThat(stringOperations.isPalindrome("a bcba"), is(true));
    }

    @Test
    public void testIsPalindromeWithTwoSpaces() {
        assertThat(stringOperations.isPalindrome("a bcb a"), equalTo(true));
    }

    @Test
    public void testReverseOneWord() {
        String reverse = stringOperations.reverse("Emyn");
        String shouldBe = "nymE";
        assertThat(reverse, allOf(equalTo(shouldBe), startsWith("n")));
    }

    @Test
    public void testReverseOneLetterWord() {
        String reverse = stringOperations.reverse("E");
        assertThat(reverse, equalTo("E"));
    }

    @Test
    public void testReverseOneSpaceWord() {
        assertThat(stringOperations.reverse(" "), equalToIgnoringWhiteSpace(""));
    }

    @Test
    public void testReverseZeroLengthWord() {
        assertThat(stringOperations.reverse(""), emptyString());
    }

    @Test
    public void testConcatTwoWords() {
        assertThat(stringOperations.concat("I am", " happy"), stringContainsInOrder("I am happy"));
    }

    @Test
    public void testConcatTwoSpaces() {
        assertThat(stringOperations.concat(" ", " "), equalToIgnoringCase("  "));
    }

    @Test
    public void testConcatTwoZeroLenghtStrings() {
        String concated = stringOperations.concat("", "");
        assertThat( concated, is(nullValue()));
    }

    @After
    public void tearDown() throws Exception {
        stringOperations = null;
    }

}