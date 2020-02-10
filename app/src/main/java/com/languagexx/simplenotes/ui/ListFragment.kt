package com.languagexx.simplenotes.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.languagexx.simplenotes.R
import com.languagexx.simplenotes.persistence.Note
import com.languagexx.simplenotes.util.Status
import com.languagexx.simplenotes.util.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

class ListFragment : DaggerFragment(), NoteListAdapter.Interaction {

    private lateinit var noteListAdapter: NoteListAdapter

    private lateinit var noteViewModel: NoteViewModel

    @Inject
    lateinit var viewmodelProviderFactory: ViewModelProviderFactory

    lateinit var allNotes: List<Note>


    // Method #1
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    // Method #2
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()    // Step 1
        observerLiveData()  // Step 2
        initRecyclerView()  // Step 3
    }

    // Method #3
    private fun observerLiveData() {
        noteViewModel.getAllNotes().observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    allNotes = it.data!!
                    noteListAdapter.submitList(allNotes)
                }
                Status.ERROR -> {
                    Log.e("List", "error case")
                }
                Status.LOADING -> {
                    Log.e("List", "loading case")
                }
            }
        })
    }

    // Method #4
    private fun initRecyclerView() {
        recyclerView.apply {
            noteListAdapter = NoteListAdapter(this@ListFragment)
            layoutManager = LinearLayoutManager(this@ListFragment.context)
            adapter = noteListAdapter
            val swipe = ItemTouchHelper(initSwipeToDelete())
            swipe.attachToRecyclerView(recyclerView)
        }
    }

    // Method #5
    private fun setupViewModel() {
        noteViewModel =
            ViewModelProvider(this, viewmodelProviderFactory).get(NoteViewModel::class.java)
    }

    // Method #6
    override fun onItemSelected(position: Int, item: Note) {
        //send note to editFragment
        val navDirection = ListFragmentDirections.actionListFragmentToEditFragment(item)
        findNavController().navigate(navDirection)
    }

    // Method #7
    private fun initSwipeToDelete(): ItemTouchHelper.SimpleCallback {
        //Swipe recycler view items on RIGHT
        return object : ItemTouchHelper.SimpleCallback(
                0, ItemTouchHelper.RIGHT
            ) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return true
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val position = viewHolder.adapterPosition
                    noteViewModel.delete(allNotes.get(position))
                    Toast.makeText(activity, "Note Deleted $position", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


