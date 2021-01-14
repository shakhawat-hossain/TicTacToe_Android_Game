package com.example.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public fun butclick(view:View){
        val butselect=view as Button
        var cellid=0
        when(butselect.id){
            R.id.b1-> cellid=1;
            R.id.b2-> cellid=2;
            R.id.b3-> cellid=3;
            R.id.b4-> cellid=4;
            R.id.b5-> cellid=5;
            R.id.b6-> cellid=6;
            R.id.b7-> cellid=7;
            R.id.b8-> cellid=8;
            R.id.b9-> cellid=9;

        }
        //Toast.makeText(this,"ID:"+cellid,Toast.LENGTH_SHORT).show()
        playgame(cellid,butselect)
    }

    var player1=ArrayList<Int>()
    var player2=ArrayList<Int>()
    var Activeplayer=1



    fun playgame(cellid:Int,butselect:Button){
        if(Activeplayer==1){
            butselect.text="X"

            butselect.setBackgroundColor(Color.RED)
            player1.add(cellid)
            Activeplayer=2

            Autoplay()
        }
        else{
            butselect.text="0"
            butselect.setBackgroundColor(Color.GREEN)
            player2.add(cellid)
            Activeplayer=1

        }

        butselect.isEnabled=false
        cheackwinner()

    }

    fun cheackwinner(){
        var winner=-1
        //row 1
        if(player1.contains(1) && player1.contains(2) &&player1.contains(3) ){
            winner=1
        }
        if(player2.contains(1) && player2.contains(2) &&player2.contains(3) ){
            winner=2
        }

        //row 2
        if(player1.contains(4) && player1.contains(5) &&player1.contains(6) ){
            winner=1
        }
        if(player2.contains(4) && player2.contains(5) &&player2.contains(6) ){
            winner=2
        }

        //row 3
        if(player1.contains(7) && player1.contains(8) &&player1.contains(9) ){
            winner=1
        }
        if(player2.contains(7) && player2.contains(8) &&player2.contains(9) ){
            winner=2
        }


        //col 1
        if(player1.contains(1) && player1.contains(4) &&player1.contains(7) ){
            winner=1
        }
        if(player2.contains(1) && player2.contains(4) &&player2.contains(7) ){
            winner=2
        }

        //col 2
        if(player1.contains(2) && player1.contains(5) &&player1.contains(8) ){
            winner=1
        }
        if(player2.contains(2) && player2.contains(5) &&player2.contains(8) ){
            winner=2
        }

        //col 3

        if(player1.contains(3) && player1.contains(6) &&player1.contains(9) ){
            winner=1
        }
        if(player2.contains(3) && player2.contains(6) &&player2.contains(9) ){
            winner=2
        }

        if(winner!=-1){
            if(winner==1){
                Toast.makeText(this,"Player 1 won the game",Toast.LENGTH_SHORT).show()

            }
            else if(winner==2){
                Toast.makeText(this,"Player 2 won the game",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,"The match is tie",Toast.LENGTH_SHORT).show()
            }
        }

    }

    fun Autoplay(){
        var emptycell=ArrayList<Int>()
        for(cellid in 1..9){
            if(!(player1.contains(cellid)) || (player2.contains(cellid))){
                emptycell.add(cellid)
            }
        }

        val r=Random()
        val randIndex=r.nextInt(emptycell.size-0)+0
        val acellid=emptycell[randIndex]

        var butselect:Button?
        when(acellid){
            1->butselect=b1
            2->butselect=b2
            3->butselect=b3
            4->butselect=b4
            5->butselect=b5
            6->butselect=b6
            7->butselect=b7
            8->butselect=b8
            9->butselect=b9
            else->{
                butselect=b1
            }

        }
        playgame(acellid,butselect)


    }


























}
