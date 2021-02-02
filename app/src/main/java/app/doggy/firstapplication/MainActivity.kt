package app.doggy.firstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //クリックリスナを設定。
        button.setOnClickListener(ClickListener())
        //ロングクリックリスナを設定。
        button.setOnLongClickListener(LongClickListener())
        //タッチリスナを設定。
        //button.setOnTouchListener(TouchListener())
    }

    //クリックした時のリスナクラス。
    private inner class ClickListener: View.OnClickListener{
        override fun onClick(view: View) {
            button.text = "クリックされました!"
        }
    }

    //長押しした時のリスナクラス。
    private inner class LongClickListener: View.OnLongClickListener{
        override fun onLongClick(view: View): Boolean {
            button.text = "長押しされました！"
            return true
        }
    }

    //タッチイベントに応じて処理を行うリスナクラス。
    private inner  class  TouchListener: View.OnTouchListener{
        override fun onTouch(view: View, event: MotionEvent): Boolean {
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    button.text = "押されています！"
                }

                MotionEvent.ACTION_UP -> {
                    button.text = "押されました！"
                }
            }
            return true
        }
    }
}