package com.algebra.asynctask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonStartBackgroundTask: Button = findViewById(R.id.bStartTask)
        val buttonStartForegroundTask: Button = findViewById(R.id.bStartTaskForeGround)
        val testButton: Button = findViewById(R.id.bTestButton)

        buttonStartBackgroundTask.setOnClickListener {
            BackgroundTask(this@MainActivity).execute(5)
        }

        buttonStartForegroundTask.setOnClickListener {
            val taskCount = 5
            for (i in 0 until taskCount) {
                Log.i( "TEST", i.toString( ) )
                Thread.sleep( 3000 )
                Toast.makeText(this@MainActivity, "$i of $taskCount finished", Toast.LENGTH_SHORT).show()
            }
        }

        testButton.setOnClickListener {
            Toast.makeText(this@MainActivity, "Clicked", Toast.LENGTH_SHORT).show()
        }

    }

}
