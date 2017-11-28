import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class ImagePixelEditor {
    public static void main(String[] args) {
        ImageBuffered java = new ImageBuffered(); // creates instance of ImageBuffered class
    }
}

class ImageBuffered extends Component {

    Color choice = new Color(255, 0, 0); // Color of choice to change to


    /* constructor reads a new image file, and calls teh iterate through pixels method */
    public ImageBuffered() {
        try {
            // get the BufferedImage, using the ImageIO class
            BufferedImage image = ImageIO.read(new File("image.jpg"));
            iterateThroughPixels(image);
        } catch (IOException e) {
            System.out.println("Image not found. Error: " + e);
        }
    }

    /* converts pixel's int color value to rgb, and checks if the pixel's rgb
     values match the specified rgb value. If so, the pixel's rgb color is changed
      to the choice. */
    public void changePixelRGB(int pixel, BufferedImage image, int x, int y) {

        // bit conversions to rgb
        int red = (pixel>>16)&0x0ff;
        int green=(pixel>>8) &0x0ff;
        int blue= (pixel)    &0x0ff;

        // set new rgb color if matching 255,170,0
        if (red == 255 & green == 255 & blue == 255) {
            image.setRGB(x, y, choice.getRGB());
        }
    }

    /* iterates through the image's pixels, for each pixel, it calls the changePixelRGB() method
    * After iteration, the new file is created*/
    private void iterateThroughPixels(BufferedImage image) {
        int w = image.getWidth();
        int h = image.getHeight();

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int pixel = image.getRGB(x, y);
                changePixelRGB(pixel, image, x, y);
            }
        }

        // write changed image to an output file
        File outputfile = new File("newImage.png");
        try {
            ImageIO.write(image, "png", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



