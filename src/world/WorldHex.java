package world;

public class WorldHex extends World{

    public boolean createInNeighbour(Point point, Class type) {
        Point tmp = new Point(point);

        tmp.x++;
        if ((isThere(tmp) == null) && tmp.x < dimensions.x) {
            addToQueue(type, tmp);
            return true;
        }
        tmp.x -= 2;
        if ((isThere(tmp) == null) && tmp.x >= 0) {
            addToQueue(type, tmp);
            return true;
        }

        if (tmp.y % 2 == 0) tmp.x++;// przesuniecie rozni sie tylko o tyle
        tmp.y--;
        if ((isThere(tmp) == null) && tmp.y >= 0 && tmp.x >=0 && tmp.x < dimensions.x) {
            addToQueue(type, tmp);
            return true;
        }
        tmp.y += 2;
        tmp.x++;
        if ((isThere(tmp) == null) && tmp.y <dimensions.y && tmp.x <dimensions.x) {
            addToQueue(type, tmp);
            return true;
        }
        tmp.y -= 2;
        if ((isThere(tmp) == null) && tmp.y >= 0 && tmp.x <dimensions.x) {
            addToQueue(type, tmp);
            return true;
        }
        tmp.y += 2;
        tmp.x++;
        if ((isThere(tmp) == null) && tmp.x < dimensions.x && tmp.y < dimensions.y) {
            addToQueue(type, tmp);
            return true;
        }
        return false;
    }


    public WorldHex(Point dim){
        super(dim);
    }

    public Point getFieldsize() {

        int dim = dimensions.x > dimensions.y  ? dimensions.x : dimensions.y;
        return new Point((int)(screensize.x / dim / 1.3), (int)(screensize.x /dim/1.2));
    }
}
