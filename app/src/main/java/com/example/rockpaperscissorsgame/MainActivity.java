package com.example.rockpaperscissorsgame;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView handAnimImageView;
    ImageView setHandImageView;
    AnimationDrawable animationDrawable;

    TextToSpeech textToSpeech;

    TextToSpeech.OnInitListener onInitListener = new TextToSpeech.OnInitListener() {
        @Override
        public void onInit(int i) {
            if(i != TextToSpeech.ERROR) {
                textToSpeech.setLanguage(Locale.CANADA);
                textToSpeech.setPitch(1.0f);
                textToSpeech.setSpeechRate(1.0f);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handAnimImageView = findViewById(R.id.handAnimation);
        setHandImageView = findViewById(R.id.set_hand_image_view);

        animationDrawable = (AnimationDrawable) handAnimImageView.getDrawable();

        textToSpeech = new TextToSpeech(getApplicationContext(), onInitListener);
    }

    public void button_click(View view) {
        int id = view.getId();

        if (id == R.id.replay_button) {
            setHandImageView.setVisibility(View.GONE);
            handAnimImageView.setVisibility(View.VISIBLE);
            animationDrawable.start();
            voicePlay("Rock Paper Scissors");
        }
        else if (id == R.id.scissors_button) {
            animationDrawable.stop();
            handAnimImageView.setVisibility(View.GONE);
            setHandImageView.setVisibility(View.VISIBLE);
            setHandImageView.setImageResource(R.drawable.com_scissors);
            int getComHand = new Random().nextInt(3)+1;
            if(getComHand == 1) {
                setHandImageView.setImageResource(R.drawable.com_scissors);
                if(view.getId() == R.id.scissors_button){
                    voicePlay("Tied, Play Again");
                }
                else if(view.getId() == R.id.rock_button) {
                    voicePlay("You won");
                }
                else {
                    voicePlay("You lost");
                }
            }
            else if(getComHand == 2) {
                setHandImageView.setImageResource(R.drawable.com_rock);
                if(view.getId() == R.id.rock_button){
                    voicePlay("Tied, Play Again");
                }
                else if(view.getId() == R.id.paper_button) {
                    voicePlay("You won");
                }
                else {
                    voicePlay("You lost");
                }
            }
            else {
                setHandImageView.setImageResource(R.drawable.com_paper);
                if(view.getId() == R.id.paper_button){
                    voicePlay("Tied, Play Again");
                }
                else if(view.getId() == R.id.scissors_button) {
                    voicePlay("You won");
                }
                else {
                    voicePlay("You lost");
                }
            }
        }
        else if (id == R.id.rock_button) {
            animationDrawable.stop();
            handAnimImageView.setVisibility(View.GONE);
            setHandImageView.setVisibility(View.VISIBLE);
            setHandImageView.setImageResource(R.drawable.com_scissors);
            int getComHand = new Random().nextInt(3)+1;
            if(getComHand == 1) {
                setHandImageView.setImageResource(R.drawable.com_scissors);
                if(view.getId() == R.id.scissors_button){
                    voicePlay("Tied, Play Again");
                }
                else if(view.getId() == R.id.rock_button) {
                    voicePlay("You won");
                }
                else {
                    voicePlay("You lost");
                }
            }
            else if(getComHand == 2) {
                setHandImageView.setImageResource(R.drawable.com_rock);
                if(view.getId() == R.id.rock_button){
                    voicePlay("Tied, Play Again");
                }
                else if(view.getId() == R.id.paper_button) {
                    voicePlay("You won");
                }
                else {
                    voicePlay("You lost");
                }
            }
            else {
                setHandImageView.setImageResource(R.drawable.com_paper);
                if(view.getId() == R.id.paper_button){
                    voicePlay("Tied, Play Again");
                }
                else if(view.getId() == R.id.scissors_button) {
                    voicePlay("You won");
                }
                else {
                    voicePlay("You lost");
                }
            }
        }
        else if (id == R.id.paper_button) {
            animationDrawable.stop();
            handAnimImageView.setVisibility(View.GONE);
            setHandImageView.setVisibility(View.VISIBLE);
            setHandImageView.setImageResource(R.drawable.com_scissors);
            int getComHand = new Random().nextInt(3)+1;
            if(getComHand == 1) {
                setHandImageView.setImageResource(R.drawable.com_scissors);
                if(view.getId() == R.id.scissors_button){
                    voicePlay("Tied, Play Again");
                }
                else if(view.getId() == R.id.rock_button) {
                    voicePlay("You won");
                }
                else {
                    voicePlay("You lost");
                }
            }
            else if(getComHand == 2) {
                setHandImageView.setImageResource(R.drawable.com_rock);
                if(view.getId() == R.id.rock_button){
                    voicePlay("Tied, Play Again");
                }
                else if(view.getId() == R.id.paper_button) {
                    voicePlay("You won");
                }
                else {
                    voicePlay("You lost");
                }
            }
            else {
                setHandImageView.setImageResource(R.drawable.com_paper);
                if(view.getId() == R.id.paper_button){
                    voicePlay("Tied, Play Again");
                }
                else if(view.getId() == R.id.scissors_button) {
                    voicePlay("You won");
                }
                else {
                    voicePlay("You lost");
                }
            }
        }
        else {
            animationDrawable.stop();
            handAnimImageView.setVisibility(View.GONE);
            setHandImageView.setVisibility(View.VISIBLE);
            setHandImageView.setImageResource(R.drawable.com_scissors);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        textToSpeech.shutdown();
    }

    public void voicePlay(String voiceText) {
        textToSpeech.speak(voiceText, TextToSpeech.QUEUE_FLUSH,null,null);
    }
}
