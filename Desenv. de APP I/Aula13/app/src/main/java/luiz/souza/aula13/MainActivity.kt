package luiz.souza.aula13

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import java.net.URI

class MainActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextSomething: EditText
    private lateinit var buttonSound1: Button
    private lateinit var buttonSound2: Button

    private var mediaPlayer: MediaPlayer? = null

    private val TAG: String = "LogMainActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e(TAG, "entrou no oncreate")
        initializer()

        buttonSound1.setOnClickListener {
            stop()
            play(R.raw.after_dark)
            Log.d(TAG, "clicou no buttonSound1")


           // val URI = Uri.parse("tel:${editTextSomething.text.toString()} ")
           // val intent = Intent(Intent.ACTION_DIAL, URI)
           // startActivity(intent)

            val URI = Uri.parse("https://www.${editTextSomething.text.toString()}")
            val intent = Intent(Intent.ACTION_VIEW, URI)
            startActivity(intent)


        }

        buttonSound2.setOnClickListener {
            stop()
            play(R.raw.morena_lofi)
            Log.d(TAG, "clicou no buttonSound2")

            val intent = Intent(this@MainActivity, Screen1::class.java)
            intent.putExtra("name", editTextName.text.toString())
            startActivity(intent)
        }

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
        stop()
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

    private fun play(sound: Int) {
        mediaPlayer = MediaPlayer.create(this@MainActivity, sound)
        mediaPlayer?.start()
        Log.d(TAG, "entrou no play")

    }
    private fun stop() {
        mediaPlayer?.let {
            if (it.isPlaying) {
                it.stop()
                Log.d(TAG, "entrou no if do let do stop")
            }
        }
    }

    private fun initializer(){
        buttonSound1 = findViewById(R.id.buttonSound1)
        buttonSound2 = findViewById(R.id.buttonSound2)
        editTextName = findViewById(R.id.editTextName)
        editTextSomething = findViewById(R.id.editTextSomething)
        Log.d(TAG, "passou no initializer")

    }

}