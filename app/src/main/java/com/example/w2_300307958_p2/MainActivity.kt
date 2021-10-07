package com.example.w2_300307958_p2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val player1 = ArrayList<Int>()
    val player2 = ArrayList<Int>()

    var currentPlayer = 1
    var winner = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun click(view: android.view.View) {
        val boxClicked = view as Button
        var id = 0
        when (boxClicked.id){
            R.id.button -> id = 1
            R.id.button2 -> id = 2
            R.id.button3 -> id = 3
            R.id.button4 -> id = 4
            R.id.button5 -> id = 5
            R.id.button6 -> id = 6
            R.id.button7 -> id = 7
            R.id.button8 -> id = 8
            R.id.button9 -> id = 9
        }

        gameFunctions(boxClicked, id)
    }



    private fun gameFunctions(boxClicked: Button, id: Int) {


        if (currentPlayer == 1){
            boxClicked.text="X"
            player1.add(id)
            currentPlayer = 2
        }else{
            boxClicked.text="O"
            player2.add(id)
            currentPlayer = 1
        }

        findWinner()

    }

    private fun findWinner() {

        // Row 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner=1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner=2
        }


        // Row 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner=1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner=2
        }


        // Row 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner=1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner=2
        }


        // Column 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner=1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner=2
        }



        // Column 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner=1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner=2
        }


        // Column 3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner=1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner=2
        }

        // Diagonal
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner=1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner=2
        }

        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner=1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner=2
        }

        //Checking winner
        if (winner == 1) {
            Toast.makeText(this, " Looks like Player 1 is the winner!", Toast.LENGTH_SHORT).show()
        } else if (winner == 2){
            Toast.makeText(this, " Looks like Player 2 is the winner!", Toast.LENGTH_SHORT).show()
        }
    }

    fun clear(view: android.view.View) {

        Toast.makeText(this,"", Toast.LENGTH_SHORT).show()

        val button1 = findViewById<Button>(R.id.button)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)

        button1.text = ""
        button2.text = ""
        button3.text = ""
        button4.text = ""
        button5.text = ""
        button6.text = ""
        button7.text = ""
        button8.text = ""
        button9.text = ""

        player1.clear()
        player2.clear()

        winner = -1

    }

}