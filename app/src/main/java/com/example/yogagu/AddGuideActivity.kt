package com.example.yogagu

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddGuideActivity : AppCompatActivity(), View.OnClickListener {
    private var firebaseDB: DatabaseReference? = null
    private val GUIDE_GROUP = "guide"
    private var checkBoxPublic: CheckBox? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_guide)
        firebaseDB = FirebaseDatabase.getInstance().getReference(GUIDE_GROUP)
        checkBoxPublic = findViewById(R.id.checkBox2)
        checkBoxPublic!!.setChecked(true)
    }

    override fun onClick(view: View) {
        val editTextName = findViewById<View>(R.id.editTextName) as EditText
        val editTextMain = findViewById<View>(R.id.editTextMain) as EditText
        if (checkBoxPublic!!.isChecked) {
            RoomDbAdd(editTextName.text.toString(), editTextMain.text.toString(), "Публичный доступ")
            val firebaseGuide = FirebaseGuide(firebaseDB!!.key, editTextName.text.toString(), editTextMain.text.toString())
            firebaseDB!!.push().setValue(firebaseGuide)
        } else {
            RoomDbAdd(editTextName.text.toString(), editTextMain.text.toString(), "Приватный доступ")
        }
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun RoomDbAdd(name: String, content: String, visible: String) {
        val db = MyDatabase.getDbInstance(this.applicationContext)
        val myDao = db.myDao()
        val guide = Guide()
        guide.name = name
        guide.content = content
        guide.visible = visible
        myDao.insert(guide)
    }
}