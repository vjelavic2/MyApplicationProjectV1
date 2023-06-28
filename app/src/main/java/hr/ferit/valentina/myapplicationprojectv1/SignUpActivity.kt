package hr.ferit.valentina.myapplicationprojectv1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
//import com.codingstuff.loginandsignup.SignInActivity
import com.google.firebase.auth.FirebaseAuth
import hr.ferit.valentina.myapplicationprojectv1.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySignUpBinding

    private lateinit var firebaseAuth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth=FirebaseAuth.getInstance()

        binding.textView.setOnClickListener {
            val intent= Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
        binding.button.setOnClickListener{
            val email= binding.emailEt.text.toString()
            val pass= binding.passET.text.toString()
            val confirmPass=binding.confirmPassEt.text.toString()

            if(email.isNotEmpty() && pass.isNotEmpty()){
                if(pass ==confirmPass){

                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if(it.isSuccessful){

                            val intent= Intent(this, SignInActivity::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                        }
                    }
                }else{
                    Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Empty fields are not allowed", Toast.LENGTH_SHORT).show()

            }
        }
    }
}