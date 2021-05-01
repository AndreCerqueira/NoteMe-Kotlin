package com.example.notemesenpai

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.*

class MainActivity : AppCompatActivity()
{
    companion object {
        // Model
        var notes: MutableList<Note> = arrayListOf()
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listViewNotes = findViewById<ListView>(R.id.noteListView)
        var postsAdapter = NotesAdapter()
        listViewNotes.adapter = postsAdapter

        // Add button event
        findViewById<Button>(R.id.buttonAddNote).setOnClickListener()
        {
            val listViewNotes = findViewById<ListView>(R.id.noteListView)
            var postsAdapter = NotesAdapter()
            listViewNotes.adapter = postsAdapter

            notes.add(Note(notes.size))
        }
    }

    inner class NotesAdapter : BaseAdapter() {
        override fun getCount(): Int {
            return notes.size
        }

        override fun getItem(position: Int): Any {
            return notes[position]
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val rowView = layoutInflater.inflate(R.layout.row_note, parent, false)

            val textViewTitle = rowView.findViewById<TextView>(R.id.row_note_title)

            textViewTitle.text = notes[position].title

            rowView.setOnClickListener {
                val intent = Intent(this@MainActivity, EditNoteActivity::class.java)
                intent.putExtra("ID", position)
                startActivity(intent)
            }

            return rowView
        }
    }


}


