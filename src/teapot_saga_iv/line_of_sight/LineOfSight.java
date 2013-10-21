package teapot_saga_iv.line_of_sight;

import teapot_saga_iv.Files;
import teapot_saga_iv.MapData;

public class LineOfSight
{
    private char[][] sight;
    
    public LineOfSight(MapData data)
    {
        sight = data.getMap().clone();
                
        for (int y = 0; y < data.getMap().length; y++)
        { sight[y] = data.getMap()[y].clone(); }
        
        fill('0');
    }
    
    public void update(int x, int y)
    {
        findVisable(x,y);
    }
    
    /**
     * Searches for lines to every wall in the current map.
     * 
     * a 40x80 map requires W*n calculations.
     * 
     * where W is the number of walls
     * 
     * inaccurate.
     * 
     * @param sx - start x pos.
     * @param sy - start y pos.
     */
    private void findVisable(int sx, int sy)
    {
        
        for (int ey = 0; ey < sight.length; ey++)
        {
            for (int ex = 0; ex < sight[ey].length; ex++)
            {
                if(Files.currentMap()[ey][ex] == '#' || Files.currentMap()[ey][ex] == '+') // only searches to all the walls in the current map
                {
                    Line line = new Line(sx,sy,ex,ey);

                    for (Point p : line.getPoints())
                    {
                        int px = p.getX();
                        int py = p.getY();

                        if(Files.currentMap()[py][px] == '#' || Files.currentDisMap()[py][px] == '+')
                        {
                            sight[py][px] = '1';
                            break;
                        } else {
                            sight[py][px] = '1';
                        }
                    }
                }
            }
        }
    }
    
    public void fill (char a)
    {
        for (int y = 0; y < sight.length; y++)
        {
            for (int x = 0; x < sight[y].length; x++)
            {
                sight[y][x] = a;
            }
        }
    }
    
    private void print ()
    {
        for (char [] y : sight)
        {
            for (char x : y)
            {
                System.out.print(x);
            }
            System.out.println();
        }
    }
    
    public char[][] getVisible()
    {
        return sight;
    }
}