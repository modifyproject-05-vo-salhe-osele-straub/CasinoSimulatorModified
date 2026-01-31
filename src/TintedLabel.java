import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TintedLabel extends JLabel {
    private BufferedImage image;
    private Color tint = Color.RED;

    public TintedLabel(BufferedImage image) { this.image = image; }
    public void setTint(Color tint) { this.tint = tint; repaint(); }

    @Override
    protected void paintComponent(Graphics tempGraphics) {
        super.paintComponent(tempGraphics);
        if (image == null){
            return;
        }
        Graphics2D temp2DGraphics = (Graphics2D) tempGraphics.create();
        temp2DGraphics.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        temp2DGraphics.setComposite(AlphaComposite.SrcAtop);
        temp2DGraphics.setColor(tint);
        temp2DGraphics.fillRect(0, 0, getWidth(), getHeight());
        temp2DGraphics.dispose();
    }
}
