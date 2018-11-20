package graphs;

class Coordinate {
    int x;
    int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Coordinate that = (Coordinate) obj;
        return x == that.x && y == that.y;
    }
}
