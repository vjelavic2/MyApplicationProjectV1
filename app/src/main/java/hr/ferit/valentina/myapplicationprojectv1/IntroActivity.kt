package hr.ferit.valentina.myapplicationprojectv1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
//import com.codingstuff.loginandsignup.SignInActivity

class IntroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val button=findViewById<Button>(R.id.button3)
        button.setOnClickListener {
            val intent= Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }


}