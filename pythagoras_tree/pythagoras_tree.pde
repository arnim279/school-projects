// wie groß ist die rechte kathede im vergleich zur linken
float triangle_scale = 1;

// how many iterations
int max_depth = 10;

//angle
float angle = radians(0);

// window size
int window_size = 750;

void settings() {
  size(window_size, window_size);
}

void setup() {
  int size = int(width / 5);

  noFill();

  Tree tree = new Tree(
    new Point(
    width/2 - round(cos(angle + radians(45)) * .5 * sqrt(2 * sq(size))),
    height/2 - round(sin(angle + radians(45)) * .5 * sqrt(2 * sq(size)))
    ), //start position
    size,
    angle,
    0 //depth
    );

  tree.draw();
}
