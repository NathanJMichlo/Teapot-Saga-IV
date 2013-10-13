package teapot_saga_iv.characters;


public class Monster_Prisoner extends Monster {

    public Monster_Prisoner(int x, int y)
    {
        this.x = x;
        this.y = y;
        startX = x;
        startY = y;
        
        damage = 1;
        health = 2;
        
        name = "Prisoner";
        symbol = 'P';
    }
} 