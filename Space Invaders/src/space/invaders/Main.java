package space.invaders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static final int SIZE = 128,
                            WINDOW_WIDTH = 8 * SIZE,
                            WINDOW_HEIGHT = 5 * SIZE,
                            BOARD_WIDTH = 15,
                            BOARD_HEIGHT = 10;
    public static Window window;
    
    public static void main(String[] args) {
        window = new Window();
    }
    
    public static void addScore(int newScore){
        try{
            File file = new File("src/space/invaders/scores.txt");
            Scanner reader = new Scanner(file);
            LinkedList<Integer> scores = new LinkedList<Integer>();
            boolean scoreNotAdded = true;
            
            while (reader.hasNextInt()){
                int score = reader.nextInt();   
                if(newScore > score && scoreNotAdded){
                    scores.add(newScore);
                    scoreNotAdded = false;
                }
                scores.add(score);    
            }
            
            if(scoreNotAdded)
                scores.add(newScore);
            
            System.out.println("size:" + scores.size());
            
            reader.close();
            
            FileWriter writer = new FileWriter(file);
            for(int i = 0; i < scores.size(); i++){
                writer.write(String.valueOf(scores.get(i)) + '\n');
            }
            
            writer.close();
        }catch(FileNotFoundException e){
            System.out.println("File not fount");
        }catch(IOException ex){
            System.out.println("exception");
        }
    }
    
}
