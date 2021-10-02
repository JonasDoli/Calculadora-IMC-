package com.example.meusnumerosdasorte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


    fun Clik(view: View) {
        val peso = findViewById<EditText>(R.id.editTextNumber)
        val altura = findViewById<EditText>(R.id.editTextNumber2)
        val res = findViewById<TextView>(R.id.textView)
        val msgg = findViewById<TextView>(R.id.textView3)
        val builder = AlertDialog.Builder(this)

        // Mensagem de advertencia campos em branco

        fun msg() {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

            builder.setTitle("ATENÇÃO")
            builder.setMessage("Voçê tem que preencher os campos")
            builder.show()
        }
        when {

            peso.text.isEmpty() -> {
                msg()
            }
            altura.text.isEmpty() -> {
                msg()
            }
            else -> {
                val y = peso.text.toString().toFloat()
                val x = altura.text.toString().toFloat()
                val pr = 18.6 <=24.9

                val soma =  y /(x * x)
                res.text = "Seu IMC é:${"%.2f".format(soma)}"
                if(soma <= 18.5 ) { msgg.text = "Abaixo do Peso Ideal"}
                if(soma >=18.6 && soma <= 24.9 ){
                    msgg.text = "Peso Ideal Parabèns"
                }
                if(soma >=25.0 && soma <= 29.9 ){
                    msgg.text = "Levemente Acima do Peso"
                }
                if(soma >=30.0 && soma <= 34.9 ){
                    msgg.text = "Obesidade Grau I"
                }
                if(soma >=35.0 && soma <= 39.9 ){
                    msgg.text = "Obesidade Grau II (Severa)"
                }
                if(soma >=40){
                    msgg.text = "Obesidade Grau III (Mórbida)"
                }






            }
        }
    }
}




