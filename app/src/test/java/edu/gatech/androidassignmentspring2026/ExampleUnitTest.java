package edu.gatech.androidassignmentspring2026;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Local unit tests (runs on the JVM).
 */
public class ExampleUnitTest {
    @Test
    public void submitAnswer_updatesScoreAndAnswered() {
        QuizManagerSingleton mgr = QuizManagerSingleton.getInstance();
        mgr.reset();

        // First question correct answer is index 0 based on seedQuestions()
        boolean correct = mgr.submitAnswer(0);

        // TODO 8:
        // Add assertions to verify:
        // - correct is true
        // - score is 1
        // - totalAnswered is 1
        //
        // Then submit an incorrect answer and verify:
        // - correct is false
        // - score is unchanged
        // - totalAnswered increments

        assertTrue(correct);

        int expectedScore = 1;
        int actualScore = mgr.getScore();
        assertEquals(expectedScore, actualScore);

        int expectedTotalAnswered = 1;
        int actualTotalAnswered = mgr.getTotalAnswered();
        assertEquals(expectedTotalAnswered, actualTotalAnswered);

        correct = mgr.submitAnswer(1);
        assertFalse(correct);

        assertEquals(expectedScore, mgr.getScore());
        assertEquals(actualTotalAnswered + 1, mgr.getTotalAnswered());
    }
}