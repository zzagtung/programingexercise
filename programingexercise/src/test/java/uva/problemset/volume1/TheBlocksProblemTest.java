package uva.problemset.volume1;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;


public class TheBlocksProblemTest {

  TheBlocksProblem block;
  
  @Before
  public void setUp() {
    block = new TheBlocksProblem();
  }
  
  @Test
  public void testInit() {
    List<Stack<Integer>> blocks = block.init(10);
    printBlocks(blocks);
    assertThat(blocks, is(notNullValue()));
    assertThat(blocks.size(), is(10));
    assertThat(blocks.get(4).pop(), is(4));
  }

  private void printBlocks(List<Stack<Integer>> blocks) {
    for (Stack<Integer> block : blocks) {
      System.out.println(block);
    }
  }
  
  @Test
  public void testMove() {
    block.init(10);
    block.moveOnto(9, 1);
    block.moveOnto(8, 1);
    block.moveOver(9, 1);
    block.moveOver(7, 1);
    block.moveOver(9, 4);
    printBlocks(block.getBlocks());
  }
  
  @Test
  public void testPile() {
    block.init(10);
    block.moveOnto(9, 1);
    block.moveOver(8, 1);
    block.moveOver(7, 1);
    block.moveOver(6, 1);
    block.pileOver(8, 6);
    block.pileOver(8, 5);
    block.moveOver(2, 1);
    block.moveOver(4, 9);
    printBlocks(block.getBlocks());
  }
}
