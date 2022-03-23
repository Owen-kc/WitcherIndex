package com.example.assignment1application;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Quiz extends AppCompatActivity {

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
        setTitle("The Witcher Index");
    }

    private TextView countLabel, questionLabel;
    private Button answerBtn1, answerBtn2, answerBtn3, answerBtn4;

    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    String quizData[][] = {
            // {"Question", "Right Answer", "Choice1", "Choice2", "Choice3"}
            {"What is Geralt's full name?", "Geralt of Rivia", "Geralt of Nivia", "Geralt of Geneva", "Geralt of Roscommon"},
            {"Who Knighted Geralt?", "Queen Meve of Lyria & Rivia", "Jaskier", "Regis", "Yennefer of Vengerberg"},
            {"What is Geralt's horses name?", "Roche", "Cat", "Humbug", "Chevy Mustang"},
            {"What is Geralt's adoptive daughters name?", "Ciri", "Triss", "Yennefer", "John"},
            {"Who is Geralt's best friend?", "Jaskier", "Yennefer", "John Doe", "Kingston the Queen of Dwarves"},///asian
            {"Who is the ruler of Redania?", "Radovid II", "King Henselt", "King Foltest", "Queen Meve"},
            {"Who is the ruler of Kaedwen?", "King Henselt", "Regis", "Milva of the Forest", "Queen Marika"},
            {"What are Witcher swords made from?", "Steel and Silver", "Steel only", "Silver Only", "Meteoric Ore"},
            {"Who is Ciri's true father?", "Emhyr Var Emreis", "Geralt of Rivia", "John Aszan", "Vilgefortz of Roggeven"},
            {"Where did Yennefer and Triss study?", "Aretuza", "Ban Ard", "Cavan town", "Shipbreaker Bay"}, ///america
            {"What is the trial Witchers go through?", "Trial of Grasses", "Trial of Maths", "Trial of Deciding", "Trial of Worth"},
            {"Who rules the Wolf School?", "Vesemir", "Geralt", "Lambert", "Eskel"},
            {"What is the capital?", "Oxenfurt", "Redania", "Rivia", "Athens"},
            {"What shape are Witchers eyes?", "Cat", "Cow", "Dog", "Goat"},
            {"Which race is not higher?", "Humans", "Elves", "Gnomes", "Dogs"}///europe
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        countLabel = findViewById(R.id.countLabel);
        questionLabel = findViewById(R.id.questionLabel);
        answerBtn1 = findViewById(R.id.answerBtn1);
        answerBtn2 = findViewById(R.id.answerBtn2);
        answerBtn3 = findViewById(R.id.answerBtn3);
        answerBtn4 = findViewById(R.id.answerBtn4);

        // Receive quizCategory from StartActivity.
        int quizCategory = getIntent().getIntExtra("QUIZ_CATEGORY", 0);
        Log.v("CATEGORY", quizCategory + "");


        // Create quizArray from quizData.
        for (int i = 0; i < quizData.length; i++) {

            // Prepare array.
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]); // Country
            tmpArray.add(quizData[i][1]); // Right Answer
            tmpArray.add(quizData[i][2]); // Choice1
            tmpArray.add(quizData[i][3]); // Choice2
            tmpArray.add(quizData[i][4]); // Choice3

            // Add tmpArray to quizArray.
            quizArray.add(tmpArray);
        }

        showNextQuiz();
    }

    public void showNextQuiz() {

        // Update quizCountLabel.
        countLabel.setText("Q" + quizCount);

        // Generate random number between 0 and 14 (quizArray's size - 1)
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        // Pick one quiz set.
        ArrayList<String> quiz = quizArray.get(randomNum);

        // Set question and right answer.
        // Array format: {"Country", "Right Answer", "Choice1", "Choice2", "Choice3"}
        questionLabel.setText(quiz.get(0));
        rightAnswer = quiz.get(1);

        // Remove "Country" from quiz and Shuffle choices.
        quiz.remove(0);
        Collections.shuffle(quiz);

        // Set choices.
        answerBtn1.setText(quiz.get(0));
        answerBtn2.setText(quiz.get(1));
        answerBtn3.setText(quiz.get(2));
        answerBtn4.setText(quiz.get(3));

        // Remove this quiz from quizArray.
        quizArray.remove(randomNum);
    }

    public void checkAnswer(View view) {

        // Get pushed button.
        Button answerBtn = findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        String alertTitle;

        if (btnText.equals(rightAnswer)) {
            // Correct
            alertTitle = "Correct!";
            rightAnswerCount++;

        } else {
            alertTitle = "Wrong...";
        }

        // Create AlertDialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Answer : " + rightAnswer);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (quizCount == QUIZ_COUNT) {
                    // Show Result.
                    Intent intent = new Intent(getApplicationContext(), QuizResult.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount);
                    startActivity(intent);

                } else {
                    quizCount++;
                    showNextQuiz();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

}