package com.example.latihan

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.PopupMenu
import android.widget.Toast
import androidx.core.view.GestureDetectorCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity(),GestureDetector.OnGestureListener {

    override fun onScroll(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFling(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDown(p0: MotionEvent?): Boolean {
      TODO("not implemented")
    }

    override fun onLongPress(event: MotionEvent) {

        gesture_status.setOnLongClickListener(){
            val popupMenu = PopupMenu(this, it)
            popupMenu.setOnMenuItemClickListener() { item ->
                 when (item.itemId) {
                    R.id.menu_shere -> {
                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.whatsapp.com")
                        )
                        startActivity(intent)
                   true
                    }
                    R.id.menu_info -> {
                        Toast.makeText(this, "ada toast", Toast.LENGTH_LONG).show()
                        true
                    }
                    else ->  false


                }

            }
            popupMenu.inflate(R.menu.menu_main)
            try {
                val fieldMPopup=PopupMenu::class.java.getDeclaredField("mPopup")
                fieldMPopup.isAccessible=true
                val mPopup=fieldMPopup.get(popupMenu)
                mPopup.javaClass
                    .getDeclaredMethod("setForceShowIcon",Boolean::class.java)
                    .invoke(mPopup,true)
            }catch (e : Exception){
               Log.e("main","eror",e)
            }finally {
                popupMenu.show()
            }
      true
        }
        }








    override fun onSingleTapUp(p0: MotionEvent?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onShowPress(p0: MotionEvent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    var gDetector: GestureDetectorCompat?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.gDetector= GestureDetectorCompat(this,this)

    }



}
