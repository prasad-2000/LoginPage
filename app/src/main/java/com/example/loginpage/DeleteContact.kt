package com.example.loginpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.contact_delete.*

class DeleteContact : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_delete)
        var helper = DBHelper(this)
        var dbTable = helper.readableDatabase

        delete_button.setOnClickListener {
            var name = delete_name.text.toString()
            var arg = listOf<String>(name).toTypedArray()
            var cursor = dbTable.rawQuery("SELECT CNAME FROM ADDCONTACT WHERE CNAME=?", arg)
            if (cursor.moveToNext()) {
                deleteData(name)
                Toast.makeText(this, "Successfully Deleted", Toast.LENGTH_LONG).show()
                delete_name.setText("")
                delete_name.requestFocus()

            } else
                Toast.makeText(this, "Contact doesn't exist", Toast.LENGTH_LONG).show()

        }

    }

    private fun deleteData(name: String) {
        var helper = DBHelper(this)
        var dbTable = helper.readableDatabase
        var contactName = arrayOf(name)
        dbTable.delete("ADDCONTACT", "CNAME=?", contactName)
        dbTable.close()

    }
}