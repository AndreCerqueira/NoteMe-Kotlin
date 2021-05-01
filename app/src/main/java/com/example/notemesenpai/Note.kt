package com.example.notemesenpai

import android.widget.Button
import android.widget.TextView

class Note
{

    // Properties
    var id: Int
    var title: String? = null
    var content: String? = null

    // Constructor
    constructor(id: Int)
    {
        this.id = id
        this.title = "Nota " + id
    }

}

