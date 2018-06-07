package domain;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class FastCharacter extends Character implements Runnable{

    private int tired = 0;
    private int percentage;
    private int speed;
    private int posY;
    private int posX;
    private String type;
    private long tiempo;
    private long tiempoFinalizado;
    private boolean arriba = false, abajo = false, adelante = false, atras = false;
    Logic logic;
    int indice = 0;
    JPanel jpanel;
    String name = "";
    LinkedList positionList;
    int[][] numMatriz;
    Cronometro cronometro;
    ArrayList<PositionCharacter> arrayTime;
    public FastCharacter(int percentage, int posX, int posY, int numImage,
            int[][] matrizObject, String name, String type, int speed, JPanel jpanel) throws IOException {
        //constructor del hilo
        super(posX, posY, numImage, matrizObject, name, type, speed);
        setSprite();
        this.posX = posX;
        this.posY = posY;
        this.percentage = percentage;
        this.speed = speed;
        logic = new Logic();
        this.jpanel = jpanel;
        this.name = name;
        this.positionList = positionList;
        this.type = type;
        this.numMatriz = matrizObject;
        cronometro = new Cronometro();
        arrayTime = new ArrayList<>();
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;

    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;

    }

    public int getTiredPercentage() {
        int percentage = (100 * this.tired) / 10;
        return percentage;

    }

    public ArrayList<PositionCharacter> getArrayTime() {
        return arrayTime;
    }

    public void setArrayTime(ArrayList<PositionCharacter> arrayTime) {
        this.arrayTime = arrayTime;
    }

   
    
    public void setSprite() throws FileNotFoundException, IOException {
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 1; i <= 11; i++) {

            BufferedImage buffer1 = ImageIO.read(new FileInputStream("src/Img/a/Santa" + i + ".png"));
            sprite.add(buffer1);
        }
        super.setSprite(setSprite2());
    }

    public ArrayList setSprite2() throws FileNotFoundException, IOException {
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 1; i < 11; i++) {

            BufferedImage buffer1 = ImageIO.read(new FileInputStream("src/Img/a/" + i + ".png"));
            sprite.add(buffer1);
        }
        return sprite;
    }

    @Override
    public void run() {
        try {
            ArrayList<Image> sprite = super.getSprite();
            cronometro.start();
            super.setPlayerImage(sprite.get(1));
            this.setPositionX(1);
            this.setPositionY(1);
            int coordenadaX = 0;
            int coordenadaY = 0;

            int[][] maze = super.getPath();
            int limite = numMatriz.length - 1;
            boolean free[] = logic.freeSpace(maze, coordenadaX, coordenadaY);
            int random = 4;
            boolean tempD = free[0];
            boolean tempI = free[1];
            boolean tempA = free[2];
            boolean tempB = free[3];
            boolean meta = true;
            
            //recorre el hilo hasta que llegue a la meta
            while (coordenadaX != limite || coordenadaY != limite) {
                try {
                    boolean back = false;
                    boolean front = false;
                    boolean down = false;
                    boolean up = false;
                    Thread.sleep(speed + 100);
                    maze = super.getPath();
                    free = logic.freeSpace(maze, coordenadaX, coordenadaY);

                    if (free[0] != tempD || free[1] != tempI || free[2] != tempA || free[3] != tempB) {
                        random = logic.random();
                    }
                    // adelante

                    if (this.tired > 9) {

                        this.sleep(4000);
                        this.tired = 0;

                    }

                    if (free[0] == true && random == 1 && front == false) {
                        for (int j = 0; j < 65; j++) {

                            super.setPlayerImage(sprite.get(indice));
                            this.setPositionX(getPositionX() + 1);
                            this.setPositionY(this.getPositionY());
                            Thread.sleep(20);
                            indice++;
                            if (indice == 11) {
                                indice = 0;
                            }
 
                            jpanel.repaint();
                        }
                        back = true;
                        coordenadaY++;
                        this.numMatriz[coordenadaX][coordenadaY - 1] = 0;
                        this.numMatriz[coordenadaX][coordenadaY] = 5;
                        tempD = free[0];
                        tempI = free[1];
                        tempA = free[2];
                        tempB = free[3];
                        tired++;
                        
                        //atras
                    } else if (free[1] == true && random == 2 && back == false) {
                        super.setSprite(setSprite2());
                        for (int j = 0; j < 65; j++) {

                            super.setPlayerImage(sprite.get(indice));
                            this.setPositionX(this.getPositionX() - 1);
                            this.setPositionY(this.getPositionY());
                            Thread.sleep(20);
                            indice++;
                            if (indice == 11) {
                                indice = 0;
                            }
                            jpanel.repaint();
                        }
                        front = true;
                        coordenadaY--;
                        this.numMatriz[coordenadaX][coordenadaY + 1] = 0;
                        this.numMatriz[coordenadaX][coordenadaY] = 5;
                        tempD = free[0];
                        tempI = free[1];
                        tempA = free[2];
                        tempB = free[3];
                        tired++;
                        
                        
                        // arriba
                    } else if (free[2] == true && random == 3 && down == false) {
                        for (int j = 0; j < 65; j++) {

                            super.setPlayerImage(sprite.get(indice));
                            this.setPositionX(this.getPositionX());
                            this.setPositionY(this.getPositionY() - 1);
                            Thread.sleep(20);
                            indice++;
                            if (indice == 11) {
                                indice = 0;
                            }
                            jpanel.repaint();
                        }
                        down = true;
                        coordenadaX--;
                        this.numMatriz[coordenadaX + 1][coordenadaY] = 0;
                        this.numMatriz[coordenadaX][coordenadaY] = 5;
                        tempD = free[0];
                        tempI = free[1];
                        tempA = free[2];
                        tempB = free[3];
                        tired++;
                        //abajo
                    } else if (free[3] == true && random == 4 && up == false) {
                        Thread.sleep(20);
                        for (int j = 0; j < 65; j++) {

                            super.setPlayerImage(sprite.get(indice));
                            this.setPositionX(this.getPositionX());
                            this.setPositionY(this.getPositionY() + 1);
                            
                            indice++;
                            if (indice == 11) {
                                indice = 0;
                            }
                            jpanel.repaint();
                            up = true;
                        }
                        coordenadaX++;
                        this.numMatriz[coordenadaX - 1][coordenadaY] = 0;
                        this.numMatriz[coordenadaX][coordenadaY] = 5;
                        tempD = free[0];
                        tempI = free[1];
                        tempA = free[2];
                        tempB = free[3];
                        tired++;
                    }
                  
                    if(coordenadaX == limite || coordenadaY == limite){
                    cronometro.setFinish(true);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(FastCharacter.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            this.numMatriz[limite][limite] = 4;
            
            System.out.println("tiempo final " + cronometro.getTime());
            this.arrayTime.add(new PositionCharacter(this.getName(), cronometro.getTime()));
            // Winner ll = new Winner(name);
        } catch (IOException ex) {
            Logger.getLogger(FastCharacter.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }
    
    
}
