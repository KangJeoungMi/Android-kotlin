package com.example.timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.Timer
import kotlin.concurrent.timer

class MainActivity() : AppCompatActivity(), View.OnClickListener {

    var isrunning = false
    var Timer : Timer? = null
    var time = 0

    private lateinit var btn_start: Button
    private lateinit var btn_reset: Button
    private lateinit var tv_min: TextView
    private lateinit var tv_sec: TextView
    private lateinit var tv_milsec: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //뷰가져오기
        btn_start = findViewById(R.id.btn_start)
        btn_reset = findViewById(R.id.btn_reset)
        tv_min = findViewById(R.id.tv_min)
        tv_sec = findViewById(R.id.tv_sec)
        tv_milsec = findViewById(R.id.tv_milsec)

        // 버튼별 onClickListener생성
        btn_start.setOnClickListener(this)
        btn_reset.setOnClickListener(this)
    }

    override fun onClick(v: View?){
        when(v?.id){
            R.id.btn_start -> {
                if(isrunning){
                    Pause()
                }else{
                    start()
                }
            }
            R.id.btn_reset -> {
                reset()
            }
        }
    }

    private fun reset() {
        Timer?.cancel()
        btn_start.text="초기화"
        btn_start.setBackgroundColor(getColor(R.color.blue))
        isrunning = false

        time=0
        tv_milsec.text = ".00"
        tv_sec.text = ":00"
        tv_min.text = "00"

    }

    private fun Pause() {
        btn_start.text="시작"
        btn_start.setBackgroundColor(getColor(R.color.blue))

        isrunning = false
        Timer?.cancel()

    }

    private fun start() {
        btn_start.text="일시정지"
        btn_start.setBackgroundColor(getColor(R.color.red))
        isrunning = true

        Timer = timer(period=10){
            time++
            val milsec = time%100
            val sec = (time%6000)/100
            val min = time/6000

            runOnUiThread{
                if (isrunning){
                    tv_milsec.text =
                        if(milsec <10) ".0${milsec}" else ".${milsec}"
                    tv_sec.text =
                        if(sec <10) ":0${sec}" else ":${sec}"

                    tv_min.text = "$min"
                }
            }



        }

    }

}


