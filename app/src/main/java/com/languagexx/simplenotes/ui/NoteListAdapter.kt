package com.languagexx.simplenotes.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.*
import com.languagexx.simplenotes.R
import com.languagexx.simplenotes.persistence.Note
import kotlinx.android.synthetic.main.note_items.view.*

class NoteListAdapter(
    private val interaction: Interaction? = null
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

// --- DIFF CALLBACK : THIS CODE IS TO ENHANCE RECYCLER VIEW PERFORMANCE----------------------------

    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Note>() {

        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }
    }
    private val differ =
        AsyncListDiffer(
            NoteRecyclerChangeCallback(this),
            AsyncDifferConfig.Builder(DIFF_CALLBACK).build()
        )

    internal inner class NoteRecyclerChangeCallback(
        private val adapter: NoteListAdapter
    ) : ListUpdateCallback {

        override fun onChanged(position: Int, count: Int, payload: Any?) {
            adapter.notifyItemRangeChanged(position, count, payload)
        }

        override fun onInserted(position: Int, count: Int) {
            adapter.notifyItemRangeChanged(position, count)
        }

        override fun onMoved(fromPosition: Int, toPosition: Int) {
            adapter.notifyDataSetChanged()
        }

        override fun onRemoved(position: Int, count: Int) {
            adapter.notifyDataSetChanged()
        }
    }

    // ---------------------------------------------------------------------------------------------

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is NoteViewHolder -> {
                holder.bind(differ.currentList.get(position))
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (differ.currentList.get(position).id > -1) {
            return 1
        }
        return differ.currentList.g
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {


        when (viewType) {
            0 -> {
                return GenericViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.empty, parent, false)
                )
            }

            else -> {
                return NoteViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.note_items, parent, false), interaction
                )
            }

        }
    }

    fun submitList(
        noteList: List<Note>?
    ) {
        val newList = noteList?.toMutableList()
        differ.submitList(newList)
    }


    interface Interaction {
        fun onItemSelected(position: Int, item: Note)
    }
}

// ------------------ ViewHolders -------------------------------

class NoteViewHolder
constructor(
    itemView: View,
    private val interaction: NoteListAdapter.Interaction?
) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: Note) = with(itemView) {
        itemView.setOnClickListener {
            interaction?.onItemSelected(adapterPosition, item)
        }

        itemView.txtTitle.text = item.title
        itemView.txtDescription.text = item.description
        itemView.txtTag.text = item.tag
    }
}

class GenericViewHolder
constructor(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {


}
