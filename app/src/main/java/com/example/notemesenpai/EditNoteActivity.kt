package com.example.notemesenpai

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class EditNoteActivity : AppCompatActivity() {

    lateinit var note: Note

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_note)

        // Variables
        val buttonReturn: Button = findViewById(R.id.buttonReturn)
        val titleTextView: TextView = findViewById(R.id.editTextTitulo)
        val contentTextView: TextView = findViewById(R.id.editTextContent)

        note = MainActivity.notes[intent.getIntExtra("ID", 0)]

        titleTextView.text = note.title
        contentTextView.text = note.content

        // OnClick Event
        buttonReturn.setOnClickListener()
        {

            MainActivity.notes[note.id].title = titleTextView.text.toString();
            MainActivity.notes[note.id].content = contentTextView.text.toString();

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}