package visao;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedButton extends JButton {

    private static final int ARC_WIDTH = 15; // Raio horizontal do arco
    private static final int ARC_HEIGHT = 15; // Raio vertical do arco

    public RoundedButton(String text) {
        super(text);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Double(0, 0, width, height, ARC_WIDTH, ARC_HEIGHT);
        g2.setColor(getBackground());
        g2.fill(roundedRectangle);

        g2.setColor(getForeground());
        FontMetrics fontMetrics = g2.getFontMetrics();
        Rectangle stringBounds = fontMetrics.getStringBounds(getText(), g2).getBounds();
        int textX = (width - stringBounds.width) / 2;
        int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();
        g2.drawString(getText(), textX, textY);

        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Não fazer nada para não desenhar a borda padrão
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo de JButton Arredondado");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        RoundedButton button = new RoundedButton("Botão Arredondado");
        button.setBackground(Color.BLUE);
        button.setForeground(Color.WHITE);

        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(button);

        frame.setVisible(true);
    }
}