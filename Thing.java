import java.util.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Thing {

  public static void main(String[] args) throws IOException {
    List<Offset> offsets = List.of(
        new Offset(1, 0),
        new Offset(0, 1),
        new Offset(2, 1));

    OffsetRenderer renderer = new OffsetRenderer(offsets);

    BufferedImage image = renderer.render();
    ImageIO.write(image, "png", (new File("Blarg.png")));
  }
}