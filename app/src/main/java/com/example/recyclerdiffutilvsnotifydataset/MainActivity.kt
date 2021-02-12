package com.example.recyclerdiffutilvsnotifydataset

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private var characterAdapter = CharacterNotifyAdapter(listOf())
    private var fetchesAmount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupRecyclerView()
        fetchDataWithNotifyDatasetChanged()
        setupViews()
    }

    private fun setupRecyclerView() {
        characters_recycler.apply {
            setHasFixedSize(true)
            adapter = characterAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun fetchDataWithNotifyDatasetChanged() {
        displayNewCharacters()
    }

    private fun displayNewCharacters() {
        val characters = getCharacters()
        characterAdapter.setCharactersWithNotifyDataSetChanged(characters)
    }

    private fun setupViews() {
        Log.d(TAG, "setupViews()")
        setupChangeButton()
    }

    private fun setupChangeButton() {
        Log.d(TAG, "setupChangeButton()")
        change_button.setOnClickListener {
            Log.d(TAG, "change_button.OnClickListener")
            displayNewCharacters()
        }
    }

    private fun getCharacters() = if (fetchesAmount++ % 2 == 0) {
        Log.d(TAG, "setupChangeButton()")
        getCharactersOdd()
    } else {
        getCharactersEven()
    }

    private fun getCharactersOdd(): List<Character> {
        Log.d(TAG, "getCharactersOdd()")
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

    private fun getCharactersEven(): List<Character> {
        Log.d(TAG, "getCharactersEven()")
        return listOf(
            Character(1, "Spider Man"),
            Character(2, "Iron Man"),
            Character(3, "Hulk"),
            Character(4, "Captain America"),
            Character(5, "Thanos"),
            Character(11, "VISION"),
            Character(12, "NICK FURY"),
            Character(13, "VENOM"),
            Character(14, "GALACTUS"),
            Character(15, "PUNISHER")
        )
    }
}