package luiz.souza.aula13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class Screen1 : AppCompatActivity() {

    private val TAG: String = "LogScreen1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen1)

        Log.e(TAG, "entrou no oncreate")

         val name = intent.getStringExtra("name")

        toast ("nome que chegou: ${name}")
    }



    override fun onStart() {
        super.onStart()
        Log.d(TAG, "entrou no onstart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "entrou no onresume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "entrou no onpause")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "entrou no onstop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "entrou no ondestroy")

    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "entrou no onrestart")

    }

    private fun toast(message: String) {
        Toast.makeText(baseContext, message, Toast.LENGTH_LONG).show()

    }

}