package com.languagexx.simplenotes

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add.*

//Activity for adding new note
class AddActivity : AppCompatActivity() {


    var color:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)


        //Save note button onclick
        btnAdd.setOnClickListener {

            //Geeting the values from editext
            val title = addTitle.text.toString()
            val description = addDescription.text.toString()
            val tag = addTag.text.toString()

            //sending the values via intent
            val addIntent = Intent()
            addIntent.putExtra("title", title)
            addIntent.putExtra("description", description)
            addIntent.putExtra("tag", tag)
            if(color==null){
                addIntent.putExtra("color", "#ffffff")
            }
            else{
                addIntent.putExtra("color", color)
            }

            setResult(Activity.RESULT_OK, addIntent)
            finish()
        }
    }

    //color buttons
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