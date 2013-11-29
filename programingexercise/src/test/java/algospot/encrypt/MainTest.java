package algospot.encrypt;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class MainTest {

  @Test
  public void testEncrypt() throws Exception {
    Main main = new Main();
    String input = "HelloWorld";
    String enc = main.encrypt(input);
    assertThat(enc, equalTo("HloolelWrd"));
    enc = main.encrypt("KwonkiYoonrth");
    assertThat(enc, equalTo("KokYorhwniont"));
  }
}
