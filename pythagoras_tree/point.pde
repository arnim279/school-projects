class Point {
  public int x;
  public int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}


void line(Point start, Point end) {
  //println("(" + start.x + " | " + start.y + ") - (" + end.x + " | " + end.y + ")");
  line(start.x, height - start.y, end.x, height - end.y);
}


void triangle(Point a, Point b, Point c) {
  triangle(a.x, height - a.y, b.x, height - b.y, c.x,  height - c.y);
}

void rect(Point a, Point b, Point c, Point d) {
  quad(a.x, height - a.y, b.x, height - b.y, c.x, height - c.y, d.x, height - d.y);
}
