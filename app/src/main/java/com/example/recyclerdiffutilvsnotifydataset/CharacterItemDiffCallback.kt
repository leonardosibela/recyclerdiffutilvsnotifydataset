package com.example.recyclerdiffutilvsnotifydataset

import androidx.recyclerview.widget.DiffUtil

class CharacterItemDiffCallback(
    var oldCharacterList: List<Character>,
    var newCharacterList: List<Character>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldCharacter = getOldAtPosition(oldItemPosition)
        val newCharacter = getNewAtPosition(oldItemPosition)
        return oldCharacter.id == newCharacter.id
    }
    override fun getOldListSize() = oldCharacterList.size


    override fun getNewListSize() = newCharacterList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldCharacter = getOldAtPosition(oldItemPosition)
        val newCharacter = getNewAtPosition(oldItemPosition)
        return oldCharacter.id == newCharacter.id &&  oldCharacter.name == newCharacter.name
    }

    private fun getOldAtPosition(position: Int) = oldCharacterList[position]

    private fun getNewAtPosition(position: Int) = newCharacterList[position]
}