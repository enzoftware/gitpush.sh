package com.hackspace.enzoftware.light_sensor

import android.content.ComponentCallbacks2
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.hackspace.enzoftware.light_sensor.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity  : AppCompatActivity() , SensorEventListener {

    var sensor:Sensor ?= null
    var sensorManager:SensorManager ?= null

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

    var isRunning = false
    override fun onSensorChanged(event: SensorEvent?) {
        textLight.text = ""+ event!!.values[0] + " lux"

        if(event!!.values[0] > 40 && !isRunning ){
            isRunning = true

            try {
                Toast.makeText(this,"La luz es mayor a 40 lux ",Toast.LENGTH_LONG).show()
                val mp = MediaPlayer()
                mp.setDataSource("http://server6.mp3quran.net/thubti/001.mp3")
                mp.prepare()
                mp.start()

            }catch (ex:Exception){}
        }
    }


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager!!.getDefaultSensor(Sensor.TYPE_LIGHT)
    }


    override fun onResume() {
        super.onResume()
        sensorManager!!.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager!!.unregisterListener(this)
    }

}