package com.example.lab1

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val inputText = findViewById<EditText>(R.id.editTextText);


        inputText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var text = s.toString();
                try {
                    if (text[0] == 'k') {
                        text = text.drop(1);
                        enterK(text.toFloat());
                    } else if (text[0] == 'g') {
                        text = text.drop(1);
                        enterG(text.toFloat());
                    } else if (text[0] == 'S') {
                        text = text.drop(1);
                        enterS(text.toFloat());
                    } else {
                        printErr();
                    }
                } catch (e : Exception) {
                    printErr();
                }

            }
        })
    }

    fun printErr() {
        val textBox1 = findViewById<TextView>(R.id.textView);
        val textBox2 = findViewById<TextView>(R.id.textView2);
        val textBox3 = findViewById<TextView>(R.id.textView3);

        textBox1.text = "Неверный входной формат данных";
        textBox2.text = "";
        textBox3.text = "";
    }

    fun enterK(k: Float) {
        val textBox1 = findViewById<TextView>(R.id.textView);
        val textBox2 = findViewById<TextView>(R.id.textView2);
        val textBox3 = findViewById<TextView>(R.id.textView3);

        textBox1.text = "Катет: " + k.toString();
        textBox2.text = "Гипотинуза: " + sqrt(2 * k * k).toString();
        textBox3.text = "Площадь: " + (k * k * 0.5).toString();
    }

    fun enterG(g: Float) {
        val textBox1 = findViewById<TextView>(R.id.textView);
        val textBox2 = findViewById<TextView>(R.id.textView2);
        val textBox3 = findViewById<TextView>(R.id.textView3);

        val k = sqrt(g*g*0.5);
        textBox1.text = "Катет: " + k.toString();
        textBox2.text = "Гипотинуза: " + g.toString();
        textBox3.text = "Площадь: " + (k * k * 0.5).toString();
    }

    fun enterS(S: Float) {
        val textBox1 = findViewById<TextView>(R.id.textView);
        val textBox2 = findViewById<TextView>(R.id.textView2);
        val textBox3 = findViewById<TextView>(R.id.textView3);

        val k = sqrt(2*S);
        textBox1.text = "Катет: " + k.toString();
        textBox2.text = "Гипотинуза: " + sqrt(2 * k * k).toString();
        textBox3.text = "Площадь: " + S.toString();
    }
}