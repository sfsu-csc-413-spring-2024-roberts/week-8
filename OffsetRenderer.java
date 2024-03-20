import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.List;

public class OffsetRenderer {

  private List<Offset> offsets;
  private BufferedImage image;

  public OffsetRenderer(List<Offset> offsets) {
    this.offsets = offsets;
  }

  public BufferedImage render() {
    generateImage();

    return image;
  }

  private final int NODE_WIDTH = 100;
  private final int NODE_HEIGHT = 75;
  private final int HORIZONTAL_PADDING = 25;
  private final int VERTICAL_PADDING = 25;

  private void generateImage() {
    int maxDepth = 1, maxOffset = 2;

    int height = (maxDepth + 1) * NODE_HEIGHT + (maxDepth + 2) * VERTICAL_PADDING;
    int width = (maxOffset + 1) * NODE_WIDTH + (maxOffset + 2) * HORIZONTAL_PADDING;

    this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics = (Graphics2D) image.getGraphics();

    graphics.setBackground(Color.WHITE);
    graphics.clearRect(0, 0, width, height);

    graphics.setColor(Color.MAGENTA);

    for (Offset offset : this.offsets) {
      int x = offset.getX(); // 1
      int y = offset.getY(); // 0

      int xCoordinate = (x + 1) * HORIZONTAL_PADDING + (x * NODE_WIDTH);
      int yCoordinate = (y + 1) * VERTICAL_PADDING + (y * NODE_HEIGHT);

      graphics.drawOval(xCoordinate, yCoordinate, NODE_WIDTH, NODE_HEIGHT);
    }

    for (int i = 0; i < width; i += (NODE_WIDTH + HORIZONTAL_PADDING)) {
      graphics.setBackground(Color.LIGHT_GRAY);
      graphics.clearRect(i, 0, HORIZONTAL_PADDING, height);
    }

    for (int i = 0; i < height; i += (NODE_HEIGHT + VERTICAL_PADDING)) {
      graphics.setBackground(Color.DARK_GRAY);
      graphics.clearRect(0, i, width, VERTICAL_PADDING);
    }
  }
}
