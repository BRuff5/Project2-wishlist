package com.example.project2wishlis

import android.os.Bundle
import android.service.autofill.UserData
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    var recView: RecyclerView? = null
    private var userData: MutableList<UserData>? = null
    var e_name: EditText? = null
    var e_price: EditText? = null
    var e_url: EditText? = null
    var submit: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        e_name = findViewById<EditText>(R.id.name)
        e_price = findViewById<EditText>(R.id.price)
        e_url = findViewById<EditText>(R.id.url)
        submit = findViewById<Button>(R.id.submit)
        userData = ArrayList()
        recView = findViewById<RecyclerView>(R.id.recyclerView)
        val linearLayoutManager = LinearLayoutManager(this)
        recView.setLayoutManager(linearLayoutManager)
        val adapter = CustomAdapter(userData as ArrayList<UserData>)
        recView.setAdapter(adapter)
        submit.setOnClickListener(View.OnClickListener {
            val name = e_name.getText().toString()
            val price = e_price.getText().toString()
            val url = e_url.getText().toString()
            val mUserData = UserData(name, price, url)
            userData.add(mUserData)
            adapter.notifyDataSetChanged()
            clearFields()
        })
    }

    fun clearFields() {
        e_name!!.setText("")
        e_price!!.setText("")
        e_url!!.setText("")
    }
}
