package com.example;

import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void shouldAnswerWithTrue() throws NoSuchFieldException, IllegalAccessException {

        Node bts = Node.create(20);
        bts.add(10);
        bts.add(9);
        bts.add(12);
        bts.add(25);
        bts.add(22);
        bts.add(26);
    }
}
