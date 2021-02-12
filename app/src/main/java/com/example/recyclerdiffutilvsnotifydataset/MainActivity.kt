package com.example.recyclerdiffutilvsnotifydataset

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private var characterAdapter = CharacterNotifyAdapter(listOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupRecyclerView()
        fetchDataWithNotifyDataseChanged()
    }

    private fun setupRecyclerView() {
        characters_recycler.apply {
            setHasFixedSize(true)
            adapter = characterAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun fetchDataWithNotifyDataseChanged() {
        getCharacters()
        characterAdapter.characters = getCharacters()
    }

    private fun getCharacters(): List<Character> {
        return listOf(
            Character(1, "Spider Man"),
            Character(2, "Iron Man"),
            Character(3, "Hulk"),
            Character(4, "Captain America"),
            Character(5, "Thanos"),
            Character(6, "Wolverine"),
            Character(7, "Deadpool"),
            Character(8, "Dr. Strange"),
            Character(9, "Black Widow"),
            Character(10, "Thor"),
            Character(11, "Vision"),
            Character(12, "Nick Fury"),
            Character(13, "Venom"),
            Character(14, "Galactus"),
            Character(15, "Punisher")
        )
    }
}