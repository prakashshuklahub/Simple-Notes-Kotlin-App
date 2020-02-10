package com.languagexx.simplenotes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.getColor
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.languagexx.simplenotes.R
import com.languagexx.simplenotes.persistence.Note
import com.languagexx.simplenotes.util.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_add.*
import javax.inject.Inject


class AddFragment : DaggerFragment() {

    lateinit var color: String

    @Inject
    lateinit var viewmodelProviderFactory: ViewModelProviderFactory

    lateinit var noteViewModel: NoteViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        changeColorOfButton()
        setupViewModel()

        btnAdd.setOnClickListener {
            Navigation.findNavController(requireActivity(),R.id.container).popBackStack()
        }
    }

    private fun saveNoteToDatabase() {

        //Save Notes WHEN app is minimized or back button is clicked [#onPause method will be called]
        //Save Notes WHEN save button is cliked


        /* VALIDATIONS FOR SAVING NOTES

        1)  if TITLE IS NULL -- Title = "Empty Title"

        2)  if all the property of notes is null i.e title , description , color and tag
        then note will note will saved
        show toast "Note is discarded"

         */

        (activity as MainActivity?)?.showFloatingButton()

        if (validations()) {
            Toast.makeText(activity, "Note is saved", Toast.LENGTH_SHORT).show()
            saveNote()
        } else
            Toast.makeText(activity, "Note is Discarded", Toast.LENGTH_SHORT).show()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        saveNoteToDatabase()
    }

    private fun saveNote() {
        val note = Note(0,addTitle.text.toString(),addDescription.text.toString(),color,addTag.text.toString())

        //If title is null set Empty Title
        if (addTitle.text.isNullOrEmpty()) {
           note.title = "Empty Title"

            //Call viewmodel to save the data
            noteViewModel.insert(note)

        }else{
            //Call viewmodel to save the data
            noteViewModel.insert(note)
        }
    }

    fun validations(): Boolean {
        return !(addTitle.text.isNullOrEmpty()
                && addDescription.text.isNullOrEmpty()
                && addTag.text.isNullOrEmpty())
    }

    private fun changeColorOfButton() {
        color = "#ffffff"

        btncolorBlue.setOnClickListener {
            cardView.setCardBackgroundColor(getColor(context!!, R.color.colorBlue))
            color = "#64FFDA"
        }
        btncolorLightBlue.setOnClickListener {
            cardView.setCardBackgroundColor(getColor(context!!, R.color.colorLightBlue))
            color = "#BBDEFB"
        }
        btncolorLightBrown.setOnClickListener {
            cardView.setCardBackgroundColor(getColor(context!!, R.color.colorLightBrown))
            color = "#A1887F"
        }
        btncolorPink.setOnClickListener {
            cardView.setCardBackgroundColor(getColor(context!!, R.color.colorPink))
        }
        btncolorYellow.setOnClickListener {
            cardView.setCardBackgroundColor(getColor(context!!, R.color.colorYellow))
            color = "#FFC400"
        }
    }

    private fun setupViewModel() {
        noteViewModel = ViewModelProvider(this,viewmodelProviderFactory).get(NoteViewModel::class.java)
    }
}