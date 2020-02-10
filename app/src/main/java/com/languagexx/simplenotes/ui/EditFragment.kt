package com.languagexx.simplenotes.ui

import android.os.Bundle
import android.util.Log
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
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.fragment_add.btncolorBlue
import kotlinx.android.synthetic.main.fragment_add.btncolorLightBlue
import kotlinx.android.synthetic.main.fragment_add.btncolorLightBrown
import kotlinx.android.synthetic.main.fragment_add.btncolorPink
import kotlinx.android.synthetic.main.fragment_add.btncolorYellow
import kotlinx.android.synthetic.main.fragment_add.cardView
import javax.inject.Inject


class EditFragment : DaggerFragment() {

    lateinit var color: String

    @Inject
    lateinit var viewmodelProviderFactory: ViewModelProviderFactory

    lateinit var noteViewModel: NoteViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        prepareNoteForEditing()
        changeColorOfButton()
        setupViewModel()

        btnEdit.setOnClickListener {
            saveNoteToDatabase()
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
            //Delete the note if all fields are empty (this is done by user)
            val id:Int = EditFragmentArgs.fromBundle(arguments!!).note?.id!!
            noteViewModel.deleteById(id)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        saveNoteToDatabase()
    }

    private fun saveNote() {

        //getting the id from bundle , we are using that id to update/edit the note
        val id:Int? = EditFragmentArgs.fromBundle(arguments!!).note?.id

        val note = Note(id!!,editTitle.text.toString(),editDescription.text.toString(),color,editTag.text.toString())

        //If title is null set Empty Title
        if (editTitle.text.isNullOrEmpty()) {
            note.title = "Empty Title"

            //Call viewmodel to save the data
            noteViewModel.update(note)

        }else{
            //Call viewmodel to save the data
            noteViewModel.update(note)
        }
    }

    fun validations(): Boolean {
        return !(editTitle.text.isNullOrEmpty()
                && editDescription.text.isNullOrEmpty()
                && editTag.text.isNullOrEmpty())
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



    private fun prepareNoteForEditing() {
    // Getting the note from the bundle
        //Save args plugin is used as i believe bundle is not good for sending large data
        arguments?.let {
            val safeArgs = EditFragmentArgs.fromBundle(it)
            val note = safeArgs.note
            editTitle.setText(note?.title.toString())
            editDescription.setText(note?.description.toString())
            editTag.setText(note?.tag.toString())
        }

    }
}

