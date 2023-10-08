package com.example.coloradapter_kotlin

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var spnColors: Spinner
    lateinit var body: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spnColors= findViewById(R.id.spnColors)
        body= findViewById(R.id.body)
        val colors= arrayOf("Select a color", "Green", "White", "Black", "Blue", "DarkGray", "Red", "Yellow", "Cyan", "Magenta", "Aqua", "Fuchsia", "Lime", "Maroon", "Navy", "Olive", "Purple", "Silver", "Teal")

        spnColors.adapter= ColorAdapter(this@MainActivity, colors)
        spnColors.onItemSelectedListener= object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val selectedColor = p0!!.getItemAtPosition(p2).toString()
                if (selectedColor == "Select a color") {
                    body.setBackgroundColor(Color.TRANSPARENT)
                }
                else{
                    body.setBackgroundColor(Color.parseColor(selectedColor))


                    if(Color.parseColor(selectedColor) == Color.WHITE){
                        spnColors.setBackgroundColor(Color.BLACK)
                    }
                    else{
                        spnColors.setBackgroundColor(Color.WHITE)
                    }
                }

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

    }
}//end MainActivity()

class ColorAdapter(_context: Context, _colors: Array<String>): BaseAdapter()
{
    private val context= _context
    private val colors= _colors

    override fun getCount(): Int {
        return colors.size
    }

    override fun getItem(p0: Int): Any {
        return colors[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val textView: TextView

        if(p1 != null){
            textView= p1 as TextView
        }
        else{
            textView= TextView(context)
        }

        textView.text = colors[p0]
        textView.textSize = 20f
        textView.setPadding(5, 5, 0, 5)
        return textView
    }
    override fun getDropDownView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val textView: TextView

        if(p1 != null){
            textView= p1 as TextView
        }
        else{
            textView= TextView(context)
        }

        textView.text= colors[p0]
        textView.textSize= 20f
        textView.setPadding(5,5,0,5)

        if (p0 == 0){
            textView.setBackgroundColor(Color.TRANSPARENT)
        } else {
            textView.setBackgroundColor(Color.parseColor(colors[p0]))
        }

        return textView
    }
}//end ColorAdapter()