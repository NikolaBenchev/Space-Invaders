package com.company;

import java.util.Random;

public class Spawner {
    private float currentEnemySpawnTime = 0;
    // time after which an enemy should spawn
    private float spawnEnemyTime;
    // all possible spawn points for the enemies
    private boolean[] enemySpawnPoints = new boolean[Main.BOARD_WIDTH];
    
    private float currentShieldSpawnTime = 0;
    // time after which a shield should spawn
    private float spawnShieldTime;
    // all possible spawn points for the shields
    private float[] shieldSpawnPoints = {1, 3.5f, 6};
    private boolean[] freeShieldSpawnPoints = new boolean[3];
    
    public Spawner(){
        this.spawnEnemyTime = 3;
        this.spawnShieldTime = 10;
    }
    
    public Enemy spawnEnemy(){
        // selects a random point until it has chosen an empty one
        Random rand = new Random();
        int x;
        
        int resets = 0;
        do{
            x = rand.nextInt(Main.BOARD_WIDTH);
            resets++;
        }while(enemySpawnPoints[x] && resets < 100);

        // if we didnt hit and empty spot 100 times in a roll return null (dont spawn an enemy)
        if(resets >= 100)
            return null;
        
        enemySpawnPoints[x] = true;
        
        Enemy enemy = new Enemy(new Position(x * Main.SIZE / 2, 0), 1, 1, 10, "enemy1");
        return enemy;
    }
    
    public Shield spawnShield(){
        // identical to the spawnEnemy function
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
    
    public void setCurrentShieldSpawnTime(float currentShieldSpawnTime) { this.currentShieldSpawnTime = currentShieldSpawnTime; }

    public void setSpawnShieldTime(float spawnShieldTime) {
        this.spawnShieldTime = spawnShieldTime;
    }
    
    public void addToCurrentShieldSpawnTime(float value) {
        this.currentShieldSpawnTime += value;
    }
}
