package org.bdshadow.interview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BracketsTest {

    private Brackets brackets = new Brackets();

    @Test
    void testBrackets() {
        assertTrue(brackets.isCorrect("()()"));
        assertTrue(brackets.isCorrect("(())"));
        assertTrue(brackets.isCorrect("(()())"));

        assertFalse(brackets.isCorrect("((("));
        assertFalse(brackets.isCorrect(")"));
        assertFalse(brackets.isCorrect("(()()"));

        assertFalse(brackets.isCorrect(")("));
        assertFalse(brackets.isCorrect("())("));
    }
}
