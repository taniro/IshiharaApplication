package tads.eaj.ufrn.ishiharaapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import tads.eaj.ufrn.ishiharaapplication.databinding.ActivityTesteBinding

class TesteActivity : AppCompatActivity() {

    lateinit var binding:ActivityTesteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_teste)

        val tipo_teste = intent.getIntExtra("teste", 1)

        when(tipo_teste){
            1 -> {
                binding.testeImageView.setImageResource(R.drawable.teste1)
            }
            2 -> {
                binding.testeImageView.setImageResource(R.drawable.teste2)
            }
            3 -> {
                binding.testeImageView.setImageResource(R.drawable.teste3)
            }
        }

        binding.cancelarButton.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }

        binding.confirmarButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("resultado", binding.numeroEditText.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}