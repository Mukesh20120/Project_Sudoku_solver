package com.example.sudokusolver;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Sudokuboard gameBoard;
    private Solver gameBoardSolver;
    private Button solvebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameBoard = findViewById(R.id.Sudokuboard);
        gameBoardSolver=gameBoard.getSolver();
        solvebtn = findViewById(R.id.solvebtn);
    }
    public void BTNOnePress(View view){
        gameBoardSolver.setNumberPos(1);
        gameBoard.invalidate();
    } public void BTNTwoPress(View view){
        gameBoardSolver.setNumberPos(2);
        gameBoard.invalidate();
    } public void BTNThreePress(View view){
        gameBoardSolver.setNumberPos(3);
        gameBoard.invalidate();
    } public void BTNFourPress(View view){
        gameBoardSolver.setNumberPos(4);
        gameBoard.invalidate();
    } public void BTNFivePress(View view){
        gameBoardSolver.setNumberPos(5);
        gameBoard.invalidate();
    } public void BTNSixPress(View view){
        gameBoardSolver.setNumberPos(6);
        gameBoard.invalidate();
    } public void BTNSevenPress(View view){
        gameBoardSolver.setNumberPos(7);
        gameBoard.invalidate();
    } public void BTNEightPress(View view){
        gameBoardSolver.setNumberPos(8);
        gameBoard.invalidate();
    } public void BTNNinePress(View view){
        gameBoardSolver.setNumberPos(9);
        gameBoard.invalidate();
    }
@SuppressLint("SetTextI18n")
public void solve(View view){
        if(solvebtn.getText().toString().equals(getString(R.string.solve))){
            solvebtn.setText(R.string.clear);

            gameBoardSolver.getEmptyBoxIndexs();
            SolveBoardThread solveBoardThread = new SolveBoardThread();
            new Thread(solveBoardThread).start();
           gameBoard.invalidate();
        }
        else{
            solvebtn.setText(R.string.solve);
            gameBoardSolver.reset();
            gameBoard.invalidate();
        }
}
class SolveBoardThread implements Runnable{
        @Override
    public void run(){
            gameBoardSolver.solve(gameBoard);
        }
    }

}