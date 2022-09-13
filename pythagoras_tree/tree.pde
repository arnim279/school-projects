class Tree {
  private Point start;
  private float size;
  private float angle;
  private int depth;
  private Point[] square_points;
  private Point triangle_top;
  private float triangle_side;
  private float triangle_angle;

  public Tree(Point start, float size, float angle, int depth) {
    this.start = start;
    this.size = size;
    this.angle = angle;
    this.depth = depth;
    this.square_points = new Point[4];

    //println(" ".repeat(this.depth - 1 >= 0 ? this.depth - 1 : 0) + this.depth);

    float diagonale = sqrt(2 * sq(this.size));

    this.square_points[0] = this.start;
    this.square_points[1] = new Point(this.start.x + round(cos(this.angle) * this.size), this.start.y + round(sin(this.angle) * this.size));
    this.square_points[2] = new Point(this.start.x + round(cos(this.angle + radians(45)) * diagonale), this.start.y + round(sin(this.angle + radians(45)) * diagonale));
    this.square_points[3] = new Point(this.start.x - round(cos(HALF_PI - this.angle) * this.size), this.start.y + round(sin((HALF_PI - this.angle)) * this.size));

    this.triangle_angle = atan(triangle_scale) + this.angle;
    this.triangle_side = this.size / sqrt(sq(triangle_scale) + 1);
    this.triangle_top = new Point(
      this.square_points[3].x + round(cos(this.triangle_angle) * triangle_side),
      this.square_points[3].y + round(sin(this.triangle_angle) * triangle_side)
      );
  }

  public void draw() {
    rect(square_points[0], square_points[1], square_points[2], square_points[3]);

    if (this.depth > max_depth) return;

    triangle(this.square_points[2], this.triangle_top, this.square_points[3]);

    if (this.size > .25) this.generateChildTrees();
  }

  private void generateChildTrees() {
    /*
    Tree left = new Tree(
     this.square_points[3],
     this.triangle_side,
     this.triangle_angle,
     this.depth + 1
     );
     
     left.draw();
     */

    Tree right = new Tree(
      this.triangle_top,
      triangle_scale * this.triangle_side,
      -HALF_PI + this.triangle_angle,
      this.depth + 1
      );

    right.draw();
  }
}
