package com.example.mynumerology;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;

    public int getNumCount(int a) {
        int inp = a;
        int x;
        while (inp > 10) {
            a = 0;
            while (inp > 9) {
                x = inp - ((inp / 10) * 10);
                inp = inp / 10;
                a = a + x;
            }
            a = a + inp;
            inp = a;
        }
        return inp;
    }

    public int getNumOfName(String name) {
        int num = 0;

        for (char ch : name.toCharArray()) {
            switch (Character.toUpperCase(ch)) {
                case 'A':
                case 'I':
                case 'J':
                case 'Q':
                case 'Y':
                    num += 1;
                    break;

                case 'B':
                case 'K':
                case 'R':
                    num += 2;
                    break;

                case 'C':
                case 'G':
                case 'L':
                case 'S':
                    num += 3;
                    break;

                case 'D':
                case 'M':
                case 'T':
                    num += 4;
                    break;

                case 'E':
                case 'H':
                case 'N':
                case 'X':
                    num += 5;
                    break;

                case 'U':
                case 'V':
                case 'W':
                    num += 6;
                    break;

                case 'O':
                case 'Z':
                    num += 7;
                    break;

                case 'F':
                case 'P':
                    num += 8;
                    break;
            }
        }
        return num;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the text from the EditText
                String text = editText.getText().toString().trim();

                // Check if the EditText is empty
                if (!text.isEmpty()) {
                    int numerology = getNumCount(getNumOfName(text));

                    // Display a toast message with the text from the EditText
                    Toast.makeText(MainActivity.this, "Numerology no is : " + numerology, Toast.LENGTH_LONG).show();
                } else {
                    // Display a toast message if the EditText is empty
                    Toast.makeText(MainActivity.this, "Please enter name", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}