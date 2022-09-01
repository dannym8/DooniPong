package com.game.screens.pongscreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Scoreboard {
   private int score;

   public void renderScoreboard(BitmapFont font, Batch batch) {
      batch.begin();
      font.draw(batch, "Score: " + score, Gdx.graphics.getWidth() - 125, Gdx.graphics.getHeight()-13);
      batch.end();
   }

   public void updateScore() {
      score++;
   }

}
