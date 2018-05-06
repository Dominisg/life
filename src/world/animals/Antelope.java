package world.animals;

import world.Direction;
import world.Organism;
import world.Point;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Antelope extends Animal {
    public Antelope(world.Point cords, world.World world) {
        super(cords, world, 4, 4);
        try {
            BufferedImage tmp = ImageIO.read(new File("src/world/animals/graphics/antelope.png"));
            image = tmp.getScaledInstance(world.getFieldsize().x, world.getFieldsize().y, Image.SCALE_FAST);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void action() {
        world.takeFromBoard(this);
        Point last_cords = new Point(cords);
        Direction dir;


        do {
            dir = Direction.randomDirection();
        } while(!willBeIn(dir));
        move(dir);
        do {
            dir = Direction.randomDirection();
        } while(!willBeIn(dir));
        Organism collision_target = move(dir);
        if(cords==last_cords)
        {
            world.setOnBoard(this);
            action();
        }
        else
        {
            //comment
            if(collision_target!=null) Collision(collision_target,last_cords);
            if(world.checkIfAlive(this))world.setOnBoard(this);
        }


    }

//    @Override
//    public boolean willItEscape() {
//        Point tmp = new Point(cords);
//        if(gen.nextBoolean())
//        {
//            if(willBeIn(Direction.RIGHT)
//            {
//                if(!super.move(dir))
//            }
//        }
//    }
}
