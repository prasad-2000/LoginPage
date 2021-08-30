package com.example.loginpage
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.display_activity.*

class DisplayContacts : AppCompatActivity() {
    lateinit var myAdapter:AdapterContact
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.display_activity)
        var tempContactModel=ArrayList<DataContact>()

        var helper = DBHelper(this)
        var db = helper.readableDatabase
        var res = db.rawQuery("SELECT * FROM ADDCONTACT", null)

        while(res.moveToNext())
        {
            var x = res.getColumnIndex("CNAME")
            var y = res.getColumnIndex("EMAIL")
            var z = res.getColumnIndex("PHNO")
            var name = DataContact(
                    res.getString(x).toString(), res.getString(y).toString(), res.getString(z).toString()
            )
            tempContactModel.add(name)
        }
        res.close()


        var layoutmanager = LinearLayoutManager(this)
        layoutmanager.orientation = LinearLayoutManager.VERTICAL
        contact_view.layoutManager = layoutmanager
        myAdapter = AdapterContact(this, tempContactModel)
        contact_view.adapter = myAdapter

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.contact_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.delete_menu->{
                if(::myAdapter.isInitialized){
                    myAdapter.deleteSelectedItems()

                }
            }
        }
        return super.onOptionsItemSelected(item)
    }


}

