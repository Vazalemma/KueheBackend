import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Stack tester.
 */
public class StackTester {
    private Stack stack;

    @Before
    public void setup() {
        stack = new Stack(10);
    }

    @Test
    public void testNewStackIsEmpty() {
        assertEquals(true, stack.empty());
    }

    @Test
    public void testNewStackIsNotFull() {
        assertEquals(false, stack.full());
    }

    @Test
    public void testNewStackNoSearchResult() {
        assertEquals(-1, stack.search(8));
    }

    @Test
    public void testPeekAddOnePositiveElementToStack() {
        stack.push(10);
        assertEquals(10, stack.peek());
    }

    @Test
    public void testPopAddOneNegativeElementToStackReturnsPoppedElement() {
        stack.push(-10);
        assertEquals(-10, stack.pop());
    }

    @Test
    public void testAddElementZeroStackNotEmpty() {
        stack.push(0);
        assertEquals(false, stack.empty());
    }

    @Test
    public void testAddOneElementStackNotFull() {
        stack.push(10);
        assertEquals(false, stack.full());
    }

    @Test
    public void testAddOneElementSearchResultAddedElement() {
        stack.push(8);
        assertEquals(1, stack.search(8));
    }

    @Test
    public void testStackIsEmptyAfterOnePushAndOnePop() {
        stack.push(10);
        stack.pop();
        assertEquals(true, stack.empty());
    }

    @Test
    public void testAddThreeElementsToStack() {
        int i = 0;
        while (++i < 4) stack.push(i);
        assertEquals(3, stack.peek());
    }

    @Test
    public void testAddFourElementsToStackAllPoppedLeavesEmptyStack() {
        int i = 0;
        while (++i < 5) stack.push(i);
        while (--i > 0) stack.pop();
        assertEquals(true, stack.empty());
    }

    @Test
    public void testAddFiveElementsToStackGetFourthSearchResult() {
        int i = 0;
        while (++i < 6) stack.push(i);
        assertEquals(4, stack.search(2));
    }

    @Test
    public void testAddFiveElementsToStackSearchResultNegative() {
        int i = 0;
        while (++i < 6) stack.push(i);
        assertEquals(-1, stack.search(7));
    }

    @Test
    public void testAddTenElementsToStackIsNotEmpty() {
        int i = 0;
        while (++i < 11) stack.push(i);
        assertEquals(false, stack.empty());
    }

    @Test
    public void testAddTenElementsToStackBecomesFullStack() {
        int i = 0;
        while (++i < 11) stack.push(i);
        assertEquals(true, stack.full());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testPopEmptyStack() {
        stack.pop();
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testStackOverflow() {
        int i = 0;
        while (++i < 999) stack.push(i);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testPeekingEmptyStack() {
        stack.peek();
    }
}
