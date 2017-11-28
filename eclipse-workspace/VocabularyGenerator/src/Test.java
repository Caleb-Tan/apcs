import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Test {
    public static void main(String[] args) {
        JavaBuffered java = new JavaBuffered();
        java.CreateBuffered();
    }
}

class JavaBuffered extends Component {

    Color choice = new Color(10, 200, 0); // Color of choice to change to


    public void CreateBuffered() {
        System.out.println(choice.getRGB());
        try {
            // get the BufferedImage, using the ImageIO class
            BufferedImage image = ImageIO.read(new File("image.gif"));
            iterateThroughPixels(image);
        } catch (IOException e) {
            System.out.println("Image not found. Error: " + e);
        }
    }

    public void printPixelRGB(int pixel, BufferedImage image, int x, int y) {

        int red = (pixel>>16)&0x0ff;
        int green=(pixel>>8) &0x0ff;
        int blue= (pixel)    &0x0ff;
        if (red == 255 & green == 170 & blue == 0) {
            image.setRGB(x, y, choice.getRGB());
        }
    }

    private void iterateThroughPixels(BufferedImage image) {
        int w = image.getWidth();
        int h = image.getHeight();

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int pixel = image.getRGB(x, y);
                printPixelRGB(pixel, image, x, y);
            }
        }
        // write new, changed image to an output file
        File outputfile = new File("newImage.png");
        try {
            ImageIO.write(image, "png", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



