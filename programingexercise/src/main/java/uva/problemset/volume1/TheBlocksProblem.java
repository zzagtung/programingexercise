package uva.problemset.volume1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * The TheBlocksProblem class.
 * Volume 1. 101 문제.
 * 
 * @author Ryan
 * @date 2013. 11. 15.
 */
public class TheBlocksProblem {

  private List<Stack<Integer>> blocks;
  private int prevIndex = 0;
  
  public static void main(String[] args) {
    
  }
  
  public List<Stack<Integer>> init(int n) {
    blocks = new ArrayList<Stack<Integer>>();
    for (int i = 0; i < n; i++) {
      Stack<Integer> block = new Stack<Integer>();
      block.push(i);
      blocks.add(block);
    }
    return blocks;
  }
  
  public List<Stack<Integer>> getBlocks() {
    return blocks; 
  }

  public void initPosition(int index) {
    blocks.get(index).push(index);
  }
  
  /**
   * Move a onto b.<br/>
   * 먼저 a 와 b 에 stacked 되어 있는 block 을 초기화한 뒤 a 를 b 위에.
   * 
   * @param a
   * @param b
   */
  public void moveOnto(int a, int b) {
    findBlockAndInit(a);
    findBlockAndInit(b);
    findBlockAndPop(a);
    findBlockAndPushValue(a, b);
  }

  private void findBlockAndPushValue(int value, int blockIndex) {
    for (Stack<Integer> block : blocks) {
      // find b
      if (block.search(blockIndex) > 0) {
        block.push(value);
        break;
      }
    }
  }

  private void findBlockAndPop(int a) {
    for (Stack<Integer> block : blocks) {
      if (block.search(a) > 0) {
        block.pop();
      }
    }
  }

  private void findBlockAndInit(int blockIndex) {
    List<Integer> stackedBlock = new ArrayList<Integer>();
    // find block
    for (Stack<Integer> block : blocks) {
      if (block.search(blockIndex) > 0) {
        Integer aIndex = block.search(blockIndex);
        // a 위에 stack element 가 있을 때.
        if (aIndex.equals(block.search(block.peek())) == false) {
          // peek index 에서 a index 차이 만큼 pop
          int peekIndex = block.search(block.peek());
          for (int i = 0; i < aIndex - peekIndex; i++) {
            stackedBlock.add(block.pop());
          }
        }
        break;
      }
    }
    // and initialize position.
    for (Integer index : stackedBlock) {
      initPosition(index);
    }
  }
  
  /**
   * Move a over b.<br/>
   * 먼저 a 위에 쌓여있는 블럭들을 초기화 한 뒤, a 를 b 위에.
   * 
   * @param a
   * @param b
   */
  public void moveOver(int a, int b) {
    findBlockAndInit(a);
    findBlockAndPop(a);
    findBlockAndPushValue(a, b);
  }
  
  /**
   * Pile a onto b<br/>
   * 먼저 b 위에 쌓여있는 블럭들을 초기화 한뒤, a 블럭 위로 쌓여 있는 모든 블럭이 b 위로 이동.(순서 유지)
   * 
   * @param a
   * @param b
   */
  public void pileOnto(int a, int b) {
    // a 블럭위로 쌓여있는 모든 블럭 저장.
    Stack<Integer> temp = findBlockAndSaveTemp(a);
    if (temp.contains(b)) {
      rollbackBlocks(temp);
      return;
    }
    // b 위에 쌓여있는 블럭들을 초기화.
    findBlockAndInit(b);
    // a blocks pile 을 b block 위로.
    pileOverToB(b, temp);
  }

  private void pileOverToB(int b, Stack<Integer> temp) {
    for (Stack<Integer> block : blocks) {
      if (block.search(b) > 0) {
        while(temp.empty() == false) {
          block.push(temp.pop());
        }
      }
    }
  }

  private Stack<Integer> findBlockAndSaveTemp(int a) {
    Stack<Integer> temp = new Stack<Integer>();
    for (Stack<Integer> block : blocks) {
      if (block.search(a) > 0) {
        int aIndex = block.search(a);
        for (int i = 0; i < aIndex; i++) {
          temp.push(block.pop());
        }
        break;
      }
      prevIndex++;
    }
    return temp;
  }
  
  /**
   * Pile a over b<br/>
   * a 블럭 위로 쌓여 있는 모든 블럭이 b 블럭이 포함된 stack 에 top 으로 이동.(순서유지)
   * 
   * @param a
   * @param b
   */
  public void pileOver(int a, int b) {
    Stack<Integer> temp = findBlockAndSaveTemp(a);
    if (temp.contains(b)) {
      // temp 에 저장되어 있는것을 원래 블럭 위치로.
      rollbackBlocks(temp);
      return;
    }
    pileOverToB(b, temp);
  }

  private void rollbackBlocks(Stack<Integer> temp) {
    while (temp.empty() == false) {
      blocks.get(prevIndex).push(temp.pop());
    }
  }
}
