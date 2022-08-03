package org.lniranjan.stateflowexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    val TAG = "Mainactivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG," CHECKING BRO ")
       val flow1 = flow<Int> {
           for (i in 1.. 10)
           {
               emit(i)
               delay(1000)
           }
       }
        lifecycleScope.launch {
            flow1.buffer().
            filter { it%2==0 }.
            map { it *it }.collect{
                Log.d("main",it.toString())
            }
        }
    }
}