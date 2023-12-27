package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Random;

import blocks.Block;
import blocks.Mino;
import blocks.Minos.Mino_Bar;
import blocks.Minos.Mino_L1;
import blocks.Minos.Mino_L2;
import blocks.Minos.Mino_Square;
import blocks.Minos.Mino_T;
import blocks.Minos.Mino_Z1;
import blocks.Minos.Mino_Z2;

public class Manager {
    final int WIDTH = 360;
    final int HEIGHT = 600;
    public static int l_x;//left
    public static int r_x;//right
    public static int t_y;//top
    public static int b_y;//bottom

    //Mino
    Mino currentMino;
    final int MINO_START_X;
    final int MINO_START_Y;
    Mino nextMino;
    final int NEXTMINO_X;
    final int NEXTMINO_Y;
    public static ArrayList<Block> staticBlocks = new ArrayList<>();

    //etc
    public static int dropInterval = 60; //drops in every 60 frames
    boolean gameOver;

    //Effect
    boolean effectCounterOn;
    int effectCounter;
    ArrayList<Integer> effectY = new ArrayList<>();
    
    //Score
    int level = 1;
    int lines;
    int score;

    public Manager(){
        l_x = (GameArea.WIDTH/2) - (WIDTH/2); // 1280/2 - 360/2 = 460
        r_x = l_x + WIDTH;
        t_y = 50;
        b_y = t_y + HEIGHT;

        MINO_START_X = l_x + (WIDTH/2) - Block.SIZE;
        MINO_START_Y = t_y + Block.SIZE;

        NEXTMINO_X = r_x + 175;
        NEXTMINO_Y = t_y + 500;

        currentMino = pickMino();
        currentMino.setXY(MINO_START_X, MINO_START_Y);
        nextMino = pickMino();
        nextMino.setXY(NEXTMINO_X, NEXTMINO_Y);
    }
    private Mino pickMino(){
        //random mino picker
        Mino mino = null;
        mino = new Mino_Z1();
        int i = new Random().nextInt(7);
        switch(i){
            case 0: mino = new Mino_L1();break;
            case 1: mino = new Mino_L2();break;
            case 2: mino = new Mino_Square();break;
            case 3: mino = new Mino_Bar();break;
            case 4: mino = new Mino_T();break;
            case 5: mino = new Mino_Z1();break;
            case 6: mino = new Mino_Z2();break;
        }
        return mino;
    }

    public void update(){
        //checks if the currentMino is active
        if(currentMino.active == false){
            //if mino is not active, put it into the staticBlocks
            staticBlocks.add(currentMino.b[0]);
            staticBlocks.add(currentMino.b[1]);
            staticBlocks.add(currentMino.b[2]);
            staticBlocks.add(currentMino.b[3]);

            //check if the game is over
            if(currentMino.b[0].x == MINO_START_X && currentMino.b[0].y == MINO_START_Y){
                //new mino stucks by spawn and cant move so game over
                gameOver = true;
            }

            currentMino.deactivating = false;

            //replacement
            currentMino = nextMino;
            currentMino.setXY(MINO_START_X, MINO_START_Y);
            nextMino = pickMino();
            nextMino.setXY(NEXTMINO_X, NEXTMINO_Y);

            //when a mino becomes inactive, check if line(s) can be deleted
            checkDelete();
        }
        else{
            currentMino.update();
        }
    }

    private void checkDelete(){
        int x = l_x;
        int y = t_y;
        int blockCount = 0;
        int lineCount = 0;

        while(x < r_x && y < b_y){
            for(int i = 0; i < staticBlocks.size(); i++){
                if(staticBlocks.get(i).x == x && staticBlocks.get(i).y == y){
                    //increase the count if there is a static block
                    blockCount++;
                }
            }
            
            x += Block.SIZE;

            if(x == r_x){
                if(blockCount == 12){ // current y line is all filled so we can delete them
                    effectCounterOn = true;
                    effectY.add(y);
                    
                    for(int i = staticBlocks.size()-1; i > -1; i--){
                        //remove all the blocks in the current y line
                        if(staticBlocks.get(i).y == y){
                            staticBlocks.remove(i);
                        }
                    }

                    lineCount++;
                    lines++;

                    //game speed
                    if(lines % 10 == 0 && dropInterval > 1){
                        level++;
                        if(dropInterval > 10){
                            dropInterval -= 10;
                        }
                        else{
                            dropInterval -= 1;
                        }
                    }

                    // we deleted line(s) so we need to shift all remain blocks down
                    for(int i = 0; i < staticBlocks.size(); i++){
                        //if a block is above the current y, move it down by the block size
                        if(staticBlocks.get(i).y < y){
                            staticBlocks.get(i).y += Block.SIZE;
                        }
                    }
                }


                blockCount = 0;
                x = l_x;
                y += Block.SIZE;
            }
        }
        // SCORING
        if(lineCount > 0){
            int singleLineScore = 10 * level;
            score += singleLineScore * lineCount;
        }
    }

    public void draw(Graphics2D g2){ 
         //drawing play area
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(4f));
        g2.drawRect(l_x-4, t_y-4, WIDTH+8, HEIGHT+8);
        g2.setColor(Color.gray);
        for(int j = 0; j < 20; j++){ //drawing rects for playarea
            int f_x = l_x; // garbage variable to draw
            int f_y = t_y;

            for(int k = 0; k < 12; k++){
                g2.drawRect(f_x, f_y+(30*(j)), 30, 30);
                f_x += 30;
            }
        }
        g2.setColor(Color.white);
        

        //drawing next tetromino frame

        int x = r_x + 100;
        int y = b_y - 200;
        g2.drawRect(x, y, 200, 200);
        g2.setFont(new Font("Arial", Font.PLAIN, 30));
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.drawString("NEXT", x+60, y+60);

        //draw score frame
        g2.drawRect(x, t_y, 250, 300);
        x += 40;
        y = t_y + 90;
        g2.drawString("Level: " + level, x, y);
        y += 70;
        g2.drawString("Lines: " + lines, x, y);
        y += 70;
        g2.drawString("Score: " + score, x, y);


        //draw the current tetromino
        if(currentMino != null){
            currentMino.draw(g2);
        }
        //draw next mino
        nextMino.draw(g2);

        //draw static blocks
        for(int i = 0; i < staticBlocks.size(); i++){
            staticBlocks.get(i).draw(g2);
        }
        //draw effect
        if(effectCounterOn){
            effectCounter++;

            g2.setColor(Color.red);
            for(int i = 0; i < effectY.size(); i++){
                g2.fillRect(l_x, effectY.get(i), WIDTH, Block.SIZE);
            }
            if(effectCounter == 10){
                effectCounterOn = false;
                effectCounter = 0;
                effectY.clear();
            }
        }

        // Draw game state || Pause || Game Over
        g2.setFont(g2.getFont().deriveFont(50f));
        if(gameOver){
            g2.setColor(Color.white);
            x = l_x + 25;
            y = t_y + 320;
            g2.drawString("GAME OVER", x, y);

        }
        else if(Handling.pausePressed){
            g2.setColor(Color.yellow);
            x = l_x + 70;
            y = t_y + 320;
            g2.drawString("PAUSED", x, y);
        }
        
        // Draw the title
        x = 35;
        y = t_y + 320;
        g2.setColor(Color.white);
        g2.setFont(new Font("Times New Roman", Font.ITALIC, 60));
        g2.drawString("Tetris", x+120, y);
    }
}
