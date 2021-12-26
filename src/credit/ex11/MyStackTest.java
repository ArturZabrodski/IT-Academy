package credit.ex11;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyStackTest {

    MyStack<Integer> myStack = new MyStack<>();

    @Test
    public void test1() {

        myStack.push(5);
        myStack.push(8);
        myStack.push(1);
        myStack.push(10);
        myStack.push(10);
        myStack.push(6);

        assertEquals("Размер стека ", 6, myStack.size());
        assertEquals("Последний элемент стека ", 6, myStack.peek());
        assertEquals("Максимальный элемент в стеке ", 10, myStack.max());
    }

    @Test
    public void test2() {

        myStack.push(5);
        myStack.push(8);
        myStack.push(1);
        myStack.push(10);
        myStack.push(10);
        myStack.push(6);

        assertEquals("Удаление элемента ", 6, myStack.pop());
        assertEquals("Удаление элемента ", 10, myStack.pop());
        assertEquals("Максимальный элемент в стеке ", 10, myStack.max());
        assertEquals("Удаление элемента ", 10, myStack.pop());
        assertEquals("Максимальный элемент в стеке ", 8, myStack.max());
        assertEquals("Размер стека ", 3, myStack.size());
    }

    @Test
    public void test3() {

        myStack.push(5);
        myStack.push(8);
        myStack.push(1);

        assertEquals("Максимальный элемент в стеке ", 8, myStack.max());
        assertEquals("Удаление элемента ", 1, myStack.pop());
        assertEquals("Удаление элемента ", 8, myStack.pop());
        assertEquals("Максимальный элемент в стеке ", 5, myStack.max());
        assertEquals("Удаление элемента ", 5, myStack.pop());
        assertEquals("Размер стека ", 0, myStack.size());
    }
}
