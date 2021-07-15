
package com.algebra.asynctask

import android.content.Context
import android.widget.Toast
import android.os.AsyncTask

class BackgroundTask(private val context: Context) : AsyncTask< Int, Int, String >( ) {

    override fun doInBackground(vararg params: Int?): String {
        val taskCount = params[0]

        for ( i in 0 until taskCount!! ) {
            performLongTask( )
            publishProgress( ( (i + 1) / taskCount.toDouble( ) * 100 ).toInt( ) )
        }
        return "$taskCount izvrseno..."
    }


    override fun onProgressUpdate( vararg percentage: Int? ) {
        val text = "${percentage[0]} %  izvrseno"
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    override fun onPostExecute( finishMessage: String ) {
        Toast.makeText( context, finishMessage, Toast.LENGTH_SHORT ).show( )
    }

    private fun performLongTask() {
        Thread.sleep( 3000 )
    }

}
