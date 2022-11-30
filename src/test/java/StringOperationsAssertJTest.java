
import app.StringOperations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class StringOperationsAssertJTest {

    private StringOperations stringOperations;

    @Before
    public void setUp() throws Exception {
        stringOperations = new StringOperations();
    }

    @Test
    public void createInstance(){
        assertThat(stringOperations.getClass()).isEqualTo(StringOperations.class);
    }

    @Test
    public void testIsPanlindromeTrue() {
        assertThat(stringOperations.isPalindrome("ABCBA")).isEqualTo(true);
    }

    @Test
    public void testIsPalindromeFalse() {
        boolean isPalindrome = stringOperations.isPalindrome("ABCB");
        assertThat(isPalindrome).isNotEqualTo(true);
    }

    @Test
    public void testIsPalindromeEmptyString() {
        assertThat(stringOperations.isPalindrome("")).isTrue();
    }

    @Test
    public void testIsPalindromeOneLetterString() {
        assertThat(stringOperations.isPalindrome("1")).isNotEqualTo(false);
    }

    @Test
    public void testIsPalindromeWithOneSpace() {
        assertThat(stringOperations.isPalindrome("a bcba")).isEqualTo(true);
    }

    @Test
    public void testIsPalindromeWithTwoSpaces() {
        assertThat(stringOperations.isPalindrome("a bcb a")).isEqualTo(true);
    }

    @Test
    public void testReverseOneWord() {
        String reverse = stringOperations.reverse("Emyn");
        String shouldBe = "nymE";
        assertThat(reverse).startsWith("n").isEqualTo(shouldBe);
    }

    @Test
    public void testReverseOneLetterWord() {
        String reverse = stringOperations.reverse("E");
        assertThat(reverse).isEqualTo("E");
    }

    @Test
    public void testReverseOneSpaceWord() {
        assertThat(stringOperations.reverse(" ")).isEqualToIgnoringWhitespace("").isEqualTo(" ");
    }

    @Test
    public void testReverseZeroLengthWord() {
        assertThat(stringOperations.reverse("")).isEmpty();
    }

    @Test
    public void testConcatTwoWords() {
        assertThat(stringOperations.concat("I am", " happy")).containsSequence("I am happy");
    }

    @Test
    public void testConcatTwoSpaces() {
        assertThat(stringOperations.concat(" ", " ")).isEqualToIgnoringCase("  ");
    }

    @Test
    public void testConcatTwoZeroLenghtStrings() {
        String concated = stringOperations.concat("", "");
        assertThat(concated).isNullOrEmpty();
    }

    @After
    public void tearDown() throws Exception {
        stringOperations = null;
    }
}