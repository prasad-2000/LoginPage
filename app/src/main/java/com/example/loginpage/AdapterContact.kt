package com.example.loginpage
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.display_layout.view.*

class AdapterContact(var context: Context, var contactList:ArrayList<DataContact>): RecyclerView.Adapter<AdapterContact.view>(){
var selectList=ArrayList<String>()
    inner class view(var inner_view:View):RecyclerView.ViewHolder(inner_view){

        fun data(c:DataContact?,pos:Int){
            itemView.display_name.text = "Name: "+ c?.Name
            itemView.display_email.text = "E-mail: "+ c?.email
            itemView.display_phno.text = "Phone Number: "+ c?.phoneNo
            itemView.showContacts.setOnLongClickListener {
                markSelectedItems(pos)
            }
            itemView.showContacts.setOnClickListener {
                deSelectItem(pos)
            }
            if(c?.isSelected==true)
                itemView.selected.visibility=View.VISIBLE
            else
                itemView.selected.visibility=View.GONE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): view {

        var v = LayoutInflater.from(context).inflate(R.layout.display_layout,parent,false)
        return view(v)

    }

    override fun onBindViewHolder(holder: view, position: Int) {

        var pos = contactList[position]
        holder.data(pos,position)

    }

    override fun getItemCount(): Int {

        return contactList.size

    }
    fun markSelectedItems(pos:Int):Boolean{
        for(i in contactList){
            i.isSelected=false
        }
        var s=contactList.get(pos)
        var name=s.Name
        if(!selectList.contains(name)){
            selectList.add(name)
        }
        selectList.forEach{
            for(i in contactList){
                if(i.Name==it){
                    i.isSelected=true
                }
            }
        }

        notifyDataSetChanged()
        return true
    }
    fun deSelectItem(pos:Int){
        var name=contactList.get(pos).Name
        if(selectList.contains(name)){
            selectList.remove(name)
        }
        contactList.get(pos).isSelected=false
        notifyDataSetChanged()

    }

    fun deleteSelectedItems(){

        for(i in selectList){
            deleteData(i)
        }
        contactList.removeAll { item->item.isSelected==true }
        notifyDataSetChanged()
    }
    private fun deleteData(name:String){

        var helper = DBHelper(context)
        var db =helper.writableDatabase
        var arr= arrayOf(name)
        db.delete("ADDCONTACT","CNAME=?", arr)
        db.close()

    }
}