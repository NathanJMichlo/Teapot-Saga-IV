package teapot_saga_iv.a_star;


public class Node {
    
    int x, y, g, h;
    Node parent = null;

    public Node(Node parent, int x, int y, int g)
    {
        this.x = x;
        this.y = y;
        this.parent = parent;
        
        if (parent == null)
        { this.g = 0; }
        else
        { this.g = parent.g + g; }

        this.h =  (int)
                Math.sqrt((AStar.getEndX() - this.x)*(AStar.getEndX() - this.x))
                + (int)
                Math.sqrt((AStar.getEndY() - this.y)*(AStar.getEndY() - this.y));
    }
    
    public boolean equal(Node node)
    {
        return this.x == node.x && this.y == node.y;
    }
    
    public void setG(int g)
    {
        this.g = g;
    }
    
    public void setH(int h)
    {
        this.h = h;
    }
    
    public int getF()
    {
        return g + h;
    }
    
    public Node getParent()
    {
        return this.parent;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
} 