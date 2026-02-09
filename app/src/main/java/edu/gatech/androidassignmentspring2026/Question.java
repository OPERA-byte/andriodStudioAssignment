package edu.gatech.androidassignmentspring2026;

/**
 * Simple model object representing one multiple-choice question.
 */
public class Question {
    private final String prompt;
    private final String[] choices;
    private final int correctIndex;

    public Question(String prompt, String[] choices, int correctIndex)
    {
        this.prompt = prompt;
        this.choices = choices;
        this.correctIndex = correctIndex;
    }

    public String getPrompt()
    {
        return prompt;
    }

    public int getCorrectIndex()
    {
        return correctIndex;
    }

    // TODO 5:
    // Implement getChoice(int index)
    // - If index is out of bounds, return an empty string.
    // - Otherwise return the choice at that index.
    public String getChoice(int index)
    {
        return "";
    }
}
