package com.br.nac_memory

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Chronometer
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.br.nac_memory.R.drawable.*
import kotlinx.android.synthetic.main.*
import kotlinx.android.synthetic.main.fragment_game.*


class GameScreen : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val meter = findViewById<Chronometer>(R.id.c_meter)
        meter.start()

        val imagens: MutableList<Int> = mutableListOf(
            bob,
            hora_aventura,
            michael,
            mickey,
            minion,
            pickachu,
            bob,
            hora_aventura,
            michael,
            mickey,
            minion,
            pickachu
        )

        val botoes = arrayOf(
            button1, button2, button3, button4, button5, button6,
            button7, button8, button9, button10, button11, button12
        )

        val cardBack = back
        var clicked = 0
        var turnOver = false
        var lastClicked = -1

        imagens.shuffle()

        for (i in 0..11) {
            botoes[i].setBackgroundResource(cardBack)
            botoes[i].text = "cardBack"
            botoes[i].textColors.defaultColor
//            botoes[i].textSize = 0.0F
            botoes[i].setOnClickListener {
                if (botoes[i].text == "cardBack" && !turnOver) {
                    botoes[i].setBackgroundResource(imagens[i])
                    botoes[i].setText(imagens[i])
                    if (clicked == 0) {
                        lastClicked = i
                    }
                    clicked++
                } else if (botoes[i].text !in "cardBack") {
                    botoes[i].setBackgroundResource(cardBack)
                    botoes[i].text = "cardBack"
                    clicked--
                }
                if (clicked == 2) {
                    turnOver = true
                    if (botoes[i].text == botoes[lastClicked].text) {
                        botoes[i].isClickable = false
                        botoes[lastClicked].isClickable = false
                        turnOver = false
                        clicked = 0
                    }
                } else if (clicked == 0) {
                    turnOver = false
                }
                while (botoes[0].text != "cardBack" && botoes[1].text != "cardBack" && botoes[2].text != "cardBack" && botoes[3].text != "cardBack"
                    && botoes[4].text != "cardBack" && botoes[5].text != "cardBack" && botoes[6].text != "cardBack" && botoes[7].text != "cardBack"
                    && botoes[8].text != "cardBack" && botoes[9].text != "cardBack" && botoes[10].text != "cardBack" && botoes[11].text != "cardBack") {
                    checkFimdoJogo()
                }
            }


        }
    }

    private fun checkFimdoJogo() {
        val intent = Intent(this@GameScreen, ResultScreen::class.java)
        intent.putExtra("key", "Kotlin")
        startActivity(intent)
    }
}