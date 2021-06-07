package space.invaders;

import java.util.Random;

public class Spawner {
    private float currentEnemySpawnTime = 0;
    private float spawnEnemyTime;
    private boolean[] enemySpawnPoints = new boolean[Main.WINDOW_WIDTH / Main.SIZE * 2];
    
    private float currentShieldSpawnTime = 0;
    private float spawnShieldTime;
    private float[] shieldSpawnPoints = {1, 3.5f, 6};
    private boolean[] freeShieldSpawnPoints = new boolean[3];
    
    public Spawner(){
        this.spawnEnemyTime = 3;
        this.spawnShieldTime = 10;
    }
    
    public Enemy spawnEnemy(){
        Random rand = new Random();
        int x;
        
        int resets = 0;
        do{
            x = rand.nextInt(Main.WINDOW_WIDTH / Main.SIZE * 2);
            resets++;
        }while(enemySpawnPoints[x] && resets < 100);
        
        if(resets >= 100)
            return null;
        
        enemySpawnPoints[x] = true;
        
        Enemy enemy = new Enemy(new Position(x * Main.SIZE / 2, 0), 1, 1, 10, "enemy1");
        return enemy;
    }
    
    public Shield spawnShield(){
        Random rand = new Random();
        int x;
        
        int resets = 0;
        do{
            x = rand.nextInt(3);
            resets++;
        }while(freeShieldSpawnPoints[x] && resets < 100);
        
        if(resets >= 100)
            return null;
        
        freeShieldSpawnPoints[x] = true;
        
        Shield shield = new Shield(new Position((int)(shieldSpawnPoints[x] * Main.SIZE), Main.WINDOW_HEIGHT - Main.SIZE * 2), 5, 0, "shield");
        return shield;
    }
    
    public void freeEnemySpawnPoint(int index){
        enemySpawnPoints[index] = false;
    }
    
    public void freeShieldSpawnPoint(int index){
        freeShieldSpawnPoints[index] = false;
    }
    
    //getters and setters
    public float getSpawnEnemyTime() {
        return this.spawnEnemyTime;
    }

    public void setSpawnEnemyTime(float spawnTime) {
        this.spawnEnemyTime = spawnTime;
    }
    
    public float getCurrentEnemySpawnTime() {
        return currentEnemySpawnTime;
    }

    
    public void setCurrentEnemySpawnTime(float value) {
        this.currentEnemySpawnTime = value;
    }
    
    public void addToCurrentEnemySpawnTime(float value) {
        this.currentEnemySpawnTime += value;
    }    
    
    public float getCurrentShieldSpawnTime() {
        return currentShieldSpawnTime;
    }
    
    public float getSpawnShieldTime() {
        return spawnShieldTime;
    }
    
    public void setCurrentShieldSpawnTime(float currentShieldSpawnTime) {
        this.currentShieldSpawnTime = currentShieldSpawnTime;
    }

    public void setSpawnShieldTime(float spawnShieldTime) {
        this.spawnShieldTime = spawnShieldTime;
    }
    
    public void addToCurrentShieldSpawnTime(float value) {
        this.currentShieldSpawnTime += value;
    }    
//    public Enemy testSpawnEnemy(Position pos){
//        Enemy enemy = new Enemy(pos, 1, 1, 10, "enemy1");
//        return enemy;
//    }


   
}
