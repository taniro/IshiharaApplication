package tads.eaj.ufrn.ishiharaapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import tads.eaj.ufrn.ishiharaapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    val CODIGO_TESTE1 = 99
    val CODIGO_TESTE2 = 98
    val CODIGO_TESTE3 = 97

    var dados = DadosMainActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.dadosMainActivity = dados


        binding.teste1Button.setOnClickListener {
            val intent = Intent(this, TesteActivity::class.java)
            /*
            val params = Bundle()
            params.putInt("teste", 1)
            intent.putExtras(params)
             */
            intent.putExtra("teste", 1)
            startActivityForResult(intent, CODIGO_TESTE1)
        }

        binding.teste2Button.setOnClickListener {
            val intent = Intent(this, TesteActivity::class.java)
            intent.putExtra("teste", 2)
            startActivityForResult(intent, CODIGO_TESTE2)
        }

        binding.teste3Button.setOnClickListener {
            val intent = Intent(this, TesteActivity::class.java)
            intent.putExtra("teste", 3)
            startActivityForResult(intent, CODIGO_TESTE3)
        }

        binding.verificarButton.setOnClickListener{
            if (binding.dadosMainActivity!!.teste1.equals("29") &&
                binding.dadosMainActivity!!.teste2.equals("74") &&
                binding.dadosMainActivity!!.teste3.equals("2") ) {
                binding.dadosMainActivity!!.resultado = "OK"
            }else{
                binding.dadosMainActivity!!.resultado = "Procure um médico"
            }
            binding.invalidateAll()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(resultCode){
            RESULT_OK->{
                val resultado = data!!.getStringExtra("resultado")
                when(requestCode){
                    CODIGO_TESTE1 -> {
                        binding.dadosMainActivity!!.teste1 = resultado
                    }
                    CODIGO_TESTE2 ->{
                        binding.dadosMainActivity!!.teste2 = resultado
                    }
                    CODIGO_TESTE3 ->{
                        binding.dadosMainActivity!!.teste3 = resultado
                    }
                }
                binding.invalidateAll()
            }
            RESULT_CANCELED->{

            }
        }

    }
}