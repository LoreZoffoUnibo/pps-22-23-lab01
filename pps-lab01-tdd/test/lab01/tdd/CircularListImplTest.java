package lab01.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CircularListImplTest {

    CircularList circularList;

    @BeforeEach
    void setUp() {
        circularList = new CircularListImpl();
    }

    @Test
    void testAdd(){
        circularList.add(4);
        assertEquals(4, circularList.next().get());
    }

    @Test
    void testSize(){
        circularList.add(13);
        circularList.add(22);
        circularList.add(872);
        assertEquals(3, circularList.size());
    }

    @Test
    void testIsEmpty(){
        assertTrue(circularList.isEmpty());
    }

    @Test
    void testNextCircular(){
        circularList.add(13);
        circularList.add(22);
        circularList.add(872);
        circularList.next();
        circularList.next();
        circularList.next();
        assertEquals(13, circularList.next().get());
    }

    @Test
    void testNextEmpty(){
        circularList.next();
        assertFalse(circularList.next().isPresent());
    }

    @Test
    void testPreviousCircular(){
        circularList.add(13);
        circularList.add(22);
        circularList.add(872);
        circularList.previous();
        assertEquals(872, circularList.previous().get());
    }

    @Test
    void testPreviousEmpty(){
        circularList.next();
        assertFalse(circularList.previous().isPresent());
    }

    @Test
    void testReset(){
        circularList.add(13);
        circularList.add(22);
        circularList.add(872);
        circularList.add(657);
        circularList.add(86);
        circularList.add(345);
        circularList.add(26);
        circularList.add(67);
        circularList.next();
        circularList.next();
        circularList.reset();
        assertEquals(13, circularList.next().get());
    }

}