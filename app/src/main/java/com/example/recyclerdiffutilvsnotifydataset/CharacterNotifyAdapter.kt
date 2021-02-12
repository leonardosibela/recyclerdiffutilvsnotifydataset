package com.example.recyclerdiffutilvsnotifydataset

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.character_list_item.view.*

class CharacterNotifyAdapter(private var characters: List<Character>) :
    RecyclerView.Adapter<CharacterNotifyAdapter.BlogListViewHolder>() {

   fun setCharactersWithNotifyDataSetChanged(characters: List<Character>) {
            this.characters = characters
            notifyDataSetChanged()
        }

    override fun getItemCount() = characters.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.character_list_item, parent, false)
        return BlogListViewHolder(view)
    }

    override fun onBindViewHolder(holder: BlogListViewHolder, position: Int) {
        val blog = characters[position]
        holder.bind(blog)
    }

    class BlogListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val title: AppCompatTextView = view.character_name

        fun bind(character: Character) {
            title.text = character.name
        }
    }
}