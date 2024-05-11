package com.example.mad4

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.engage.common.datamodel.Price

class addrooms : AppCompatActivity() {

    private lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_rooms)

        dbHelper = DBHelper(this, null)

        val createBtn: Button = findViewById(R.id.button_submit)
        createBtn.setOnClickListener {
            val name = R.id.cName.toString()
            val Price = R.id.totalPrice.toInt()

            dbHelper.addName(name, Price)

            Toast.makeText(this, "$name added to database", Toast.LENGTH_LONG).show()

            /*R.id.RName.toString().clear()
            R.id.Description.clear()*/
        }

        /*printName.setOnClickListener {
            val cursor = dbHelper.getName()

            Name.text = ""
            Description.text = ""

            cursor?.apply {
                while (moveToNext()) {
                    Attributes.Name.append(getString(getColumnIndex(DBHelper.RECEIVER_NAME)) + "\n")
                    Description.append(getString(getColumnIndex(DBHelper.DESCRIPTION)) + "\n")
                }
                close()
            }
        }*/
    }

}

private fun DBHelper.addName(name: String, members: Int) {

}
