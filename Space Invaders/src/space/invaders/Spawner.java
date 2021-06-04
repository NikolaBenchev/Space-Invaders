package space.invaders;

import java.util.Random;

public class Spawner {
    private float currentSpawnTime = 0;
    private float spawnTime;
    private boolean[] spawnPoints = new boolean[Main.WINDOW_WIDTH / Main.SIZE * 2];
    private int[] shieldSpawnPoints = {1, 3, 6};

    public Spawner(){
        this.spawnTime = 3;
    }
    
    public Enemy spawnEnemy(){
        System.out.println("spawn enemy");
        Random rand = new Random();
        int x;
        
        int resets = 0;
        do{
            x = rand.nextInt(Main.WINDOW_WIDTH / Main.SIZE * 2);
            resets++;
        }while(spawnPoints[x] && resets < 100);
        
        if(resets >= 100)
            return null;
        
        System.out.println("pass");
        spawnPoints[x] = true;
        
        Enemy enemy = new Enemy(new Position(x * Main.SIZE / 2, 0), 1, 1, 10, "enemy1");
        return enemy;
    }
    
    public Shield spawnShield()
    {
        Random rand = new Random();
        int x = rand.nextInt(3);
        Shield shield = new Shield(new Position(shieldSpawnPoints[x] * Main.SIZE, Main.WINDOW_HEIGHT - Main.SIZE * 2), 5, 0, "shield");
        return shield;
        
    }
    
    public void freeSpawnPoint(int index){
        spawnPoints[index] = false;
    }
    
    //getters and setters
    public float getSpawnTime() {
        return this.spawnTime;
    }

    public void setSpawnTime(float spawnTime) {
        this.spawnTime = spawnTime;
    }
    
    public float getCurrentSpawnTime() {
        return currentSpawnTime;
    }

    
    public void setCurrentSpawnTime(float value) {
        this.currentSpawnTime = value;
    }
    
    public void addToCurrentSpawnTime(float value) {
        this.currentSpawnTime += value;
    }
//    public Enemy testSpawnEnemy(Position pos){
//        Enemy enemy = new Enemy(pos, 1, 1, 10, "enemy1");
//        return enemy;
//    }
    
}
