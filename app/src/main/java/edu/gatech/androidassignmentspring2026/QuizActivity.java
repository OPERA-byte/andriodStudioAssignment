package edu.gatech.androidassignmentspring2026;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

/**
 * QuizActivity is the only screen in this assignment.
 * Students complete several TODOs to make the app fully functional.
 */
public class QuizActivity extends AppCompatActivity
{
    private TextView tvScore;
    private TextView tvQuestion;
    private TextView tvFeedback;
    private RadioGroup rgAnswers;
    private RadioButton rbA;
    private RadioButton rbB;
    private RadioButton rbC;
    private RadioButton rbD;

    private MaterialButton btnSubmit;
    private MaterialButton btnNext;
    private MaterialButton btnReset;

    private QuizManagerSingleton quizManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        tvScore = findViewById(R.id.tvScore);
        tvQuestion = findViewById(R.id.tvQuestion);
        tvFeedback = findViewById(R.id.tvFeedback);
        rgAnswers = findViewById(R.id.rgAnswers);

        rbA = findViewById(R.id.rbA);
        rbB = findViewById(R.id.rbB);
        rbC = findViewById(R.id.rbC);
        rbD = findViewById(R.id.rbD);

        btnSubmit = findViewById(R.id.btnSubmit);
        btnNext = findViewById(R.id.btnNext);

        // TODO 1:
        // Initialize quizManager using the singleton.
        // quizManager should point to the shared QuizManagerSingleton instance.
        // HINT: You should NOT use 'new' here.
        quizManager = null;

        // TODO 3:
        // Find btnReset from the layout using its id.
        // Note: activity_quiz.xml has TODO 7 that creates this button.
        btnReset = null;

        bindButtonHandlers();
        renderQuestion();
        updateScoreUI();
    }

    private void bindButtonHandlers()
    {
        btnSubmit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                handleSubmit();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                quizManager.moveToNextQuestion();
                clearSelectionAndFeedback();
                renderQuestion();
                updateScoreUI();
            }
        });

        // TODO 4:
        // Add an OnClickListener for btnReset.
        // When clicked, it should reset the quiz via quizManager, then:
        // - clearSelectionAndFeedback()
        // - renderQuestion()
        // - updateScoreUI()
    }

    private void handleSubmit()
    {
        int checkedId = rgAnswers.getCheckedRadioButtonId();
        if (checkedId == -1)
        {
            tvFeedback.setText("Please select an answer before submitting.");
            return;
        }

        int selectedIndex = idToAnswerIndex(checkedId);

        // TODO 6:
        // Call quizManager.submitAnswer(selectedIndex) and store whether it was correct.
        // Then update tvFeedback to:
        // - "Correct!" if correct
        // - "Incorrect." if incorrect
        boolean correct = false;

        if (correct)
        {
            tvFeedback.setText("Correct!");
        }
        else
        {
            tvFeedback.setText("Incorrect.");
        }

        updateScoreUI();
    }

    private int idToAnswerIndex(int checkedId)
    {
        if (checkedId == R.id.rbA)
        {
            return 0;
        }
        if (checkedId == R.id.rbB)
        {
            return 1;
        }
        if (checkedId == R.id.rbC)
        {
            return 2;
        }
        return 3;
    }

    private void renderQuestion()
    {
        Question q = quizManager.getCurrentQuestion();
        tvQuestion.setText(q.getPrompt());

        rbA.setText(q.getChoice(0));
        rbB.setText(q.getChoice(1));
        rbC.setText(q.getChoice(2));
        rbD.setText(q.getChoice(3));
    }

    private void updateScoreUI()
    {
        tvScore.setText("Score: " + quizManager.getScore() + "/" + quizManager.getTotalAnswered());
    }

    private void clearSelectionAndFeedback()
    {
        rgAnswers.clearCheck();
        tvFeedback.setText(getString(R.string.feedback_default));
    }
}
