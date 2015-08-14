import org.junit.*;
import static org.junit.Assert.*;

public class WordPuzzleTest {

  // Testing the replacement - regardless the case
  @Test
  public void wordPuzzle_ReplaceA_String() {
      WordPuzzle testWordPuzzle = new WordPuzzle();
      String answer = "-, -";
      assertEquals(answer, testWordPuzzle.replacedAEIOU("A, a"));
  }

  @Test
  public void wordPuzzle_ReplaceWord_String() {
      WordPuzzle testWordPuzzle = new WordPuzzle();
      String answer = "T-st-ng";
      assertEquals(answer, testWordPuzzle.replacedAEIOU("Testing"));
  }
}
