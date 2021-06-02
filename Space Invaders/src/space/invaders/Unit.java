package space.invaders;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public abstract class Unit {
    private Position position;
    private int hp;
    private int speed;
    private BufferedImage img;

    Unit(Position position, int hp, int speed, String name){
        this.position = new Position(position.getX(), position.getY());
        setHp(hp);
        setSpeed(speed);
        this.setImg(name);
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(String name) {
        try {                
            System.out.println("Space Invaders/src/img/" + name + ".png");
            img = ImageIO.read(new File("img/" + name + ".png"));
       } catch (IOException ex) {
            System.out.println("not found");
       }
    }
    
    public void setPosition(Position value){
        this.position.setX(value.getX());
        this.position.setY(value.getY());
    }

    public Position getPosition(){
        return this.position;
    }
    
    public void lowerHp(){
        this.hp -= 1;
    }

    public void setHp(int value){
        this.hp = value;
    }

    public int getHp(){
        return this.hp;
    }
    
    public void setSpeed(int value){
        this.speed = value;
    }
    
    public int getSpeed(){
        return this.speed;
    }
    
    public void move(int x, int y){
        this.position.setX(this.getPosition().getX() + x * this.speed);
        this.position.setY(this.getPosition().getY() + y * this.speed);
    }
    
    public boolean collide(Unit unit){
        return (this.getPosition().getX() == unit.getPosition().getX() && 
                this.getPosition().getY() == unit.getPosition().getY());
    }
    
    public void draw(Graphics g, JPanel board){
        g.drawImage(this.img, this.position.getX(), this.position.getY(), Main.SIZE, Main.SIZE, board);
    }
}
