package com.example.meusnumerosdasorte

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


    fun Clik(view: View) {
        val y = etPeso.text.toString().toFloat()
        val x = etAltura.text.toString().toFloat()
        val msgg = tvMensagem
        val builder = AlertDialog.Builder(this)

        // Mensagem de advertencia campos em branco

        fun msg() {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

            builder.setTitle("ATENÇÃO")

            builder.setMessage("Voçê tem que preencher os campos")
            builder.apply {
                builder.show()
            }


        }
        when {

            etPeso.text.isEmpty() -> {
                msg()
            }
            etAltura.text.isEmpty() -> {
                msg()
            }
            else -> {


                val soma = y / (x * x)
                tvResultado.text = "Seu IMC é:${"%.2f".format(soma)}"
                if (soma <= 18.5) {
                    msgg.text = "Abaixo do Peso Ideal"
                }
                if (soma >= 18.6 && soma <= 24.9) {
                    msgg.text = "Peso Ideal Parabèns"
                }
                if (soma >= 25.0 && soma <= 29.9) {
                    msgg.text = "Levemente Acima do Peso"
                }
                if (soma >= 30.0 && soma <= 34.9) {
                    msgg.text = "Obesidade Grau I"
                }
                if (soma >= 35.0 && soma <= 39.9) {
                    msgg.text = "Obesidade Grau II (Severa)"
                }
                if (soma >= 40) {
                    msgg.text = "Obesidade Grau III (Mórbida)"
                }


            }
        }
    }
}




