package teapot_saga_iv;


public class Monster_Bat extends Monster {

    public Monster_Bat(int x, int y)
    {
        this.x = x;
        this.y = y;
        startX = x;
        startY = y;
        
        damage = 1;
        health = 1;
        
        name = "Bat";
        symbol = 230;
        symbol = 'B';
    }
    
    @Override
    public void update ()
    {
        if (distanceToPlayer() < 1)
        {
            Main.getPlayer().damage(damage);
            Main.getPlayer().attack(this);
        }
        
        displace();
    }
} 