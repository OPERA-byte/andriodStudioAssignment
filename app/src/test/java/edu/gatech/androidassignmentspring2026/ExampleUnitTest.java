package edu.gatech.androidassignmentspring2026;

import org.junit.Test;

/**
 * Local unit tests (runs on the JVM).
 */
public class ExampleUnitTest
{
    @Test
    public void submitAnswer_updatesScoreAndAnswered()
    {
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
    }
}
