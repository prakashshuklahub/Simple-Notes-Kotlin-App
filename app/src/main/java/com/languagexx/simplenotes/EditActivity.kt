package com.languagexx.simplenotes

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.activity_edit.cardView

//Activity to edit note
class EditActivity:AppCompatActivity() {

    var color:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        //getting values from intent
        var editIntent = intent
        var title = intent.getStringExtra("title")
        var description = intent.getStringExtra("description")
        var tag = intent.getStringExtra("tag")
        var id = intent.getStringExtra("id")

        //fill the edit text with note values
        editTitle.setText(title)
        editDescription.setText(description)
        editTag.setText(tag)

        //Save note
       btnEdit.setOnClickListener {

           //getting values from edittext
           title = editTitle.text.toString()
           description = editDescription.text.toString()
           tag = editTag.text.toString()


           //sending values via intent
           editIntent.putExtra("title",title)
           editIntent.putExtra("description",description)
           editIntent.putExtra("tag",tag)
           editIntent.putExtra("id",id)
           if(color==null){
               editIntent.putExtra("color", "#ffffff")
           }
           else{
               editIntent.putExtra("color", color)
           }

           setResult(Activity.RESULT_OK,editIntent)
           finish()
       }
    }

    //button for color
    fun buttonColor(view: View) {
        val id = view.id
        if (id == R.id.btncolorLightBrown) {
            cardView.setBackgroundColor(resources.getColor(R.color.colorBrown))
            color = "#A1887F"
        }
        else if (id == R.id.btncolorPink) {
            cardView.setBackgroundColor(resources.getColor(R.color.colorPink))
            color = "#E880FC"
        }
        else if (id == R.id.btncolorYellow) {
            cardView.setBackgroundColor(resources.getColor(R.color.colorYellow))
            color = "#FFC400"
        }
        else if (id == R.id.btncolorLightBlue) {
            cardView.setBackgroundColor(resources.getColor(R.color.colorLightBlue))
            color=  "#BBDEFB"
        }
        else if (id == R.id.btncolorBlue) {
            cardView.setBackgroundColor(resources.getColor(R.color.colorBlue))
            color= "#64FFDA"
        }
    }
}