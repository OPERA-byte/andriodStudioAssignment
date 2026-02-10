package edu.gatech.androidassignmentspring2026;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds quiz state for the app (singleton).
 *
 * Expected behavior:
 * - Maintains a list of questions
 * - Tracks current question index
 * - Tracks score and total answered
 */
public class QuizManagerSingleton {
    private static QuizManagerSingleton instance;

    private final List<Question> questions;
    private int currentIndex;

    private int score;
    private int totalAnswered;

    private QuizManagerSingleton() {
        questions = new ArrayList<>();
        seedQuestions();
        reset();
    }

    public static QuizManagerSingleton getInstance() {
        if (instance == null) {
            instance = new QuizManagerSingleton();
        }
        return instance;
    }

    private void seedQuestions() {
        questions.add(new Question(
                "Which component defines the UI layout in Android?",
                new String[] {"XML", "Gradle", "SQLite", "JUnit"},
                0
        ));

        questions.add(new Question(
                "What method is called when an Activity is first created?",
                new String[] {"onStart()", "onCreate()", "onPause()", "onDestroy()"},
                1
        ));

        questions.add(new Question(
                "Which class groups RadioButtons so only one can be selected?",
                new String[] {"RecyclerView", "RadioGroup", "LinearLayout", "Intent"},
                1
        ));
    }

    public void reset() {
        currentIndex = 0;
        score = 0;
        totalAnswered = 0;
    }

    public Question getCurrentQuestion() {
        return questions.get(currentIndex);
    }

    public void moveToNextQuestion() {
        currentIndex = (currentIndex + 1) % questions.size();
    }

    public int getScore() {
        return score;
    }

    public int getTotalAnswered() {
        return totalAnswered;
    }

    public int getQuestionCount() {
        return questions.size();
    }

    public boolean submitAnswer(int selectedIndex) {
        totalAnswered += 1;

        // TODO 2:
        // If selectedIndex matches the current question's correct answer index,
        // increment score and return true. Otherwise return false.
        //
        // NOTE: Do NOT advance the question here. The Activity controls navigation.

        if (selectedIndex == questions.get(currentIndex).getCorrectIndex()) {
            score+= 1;
            return true;
        }

        return false;
    }
}