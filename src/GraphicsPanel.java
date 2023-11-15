import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class GraphicsPanel extends JPanel {

  /** initiale Dimension des Zeichen-Panels */
  private final int width = 1000;
  private final int height = 1000;

  /** Konstruktor für das Zeichen-Panel */
  public GraphicsPanel() {
    this.setPreferredSize(new Dimension(width, height));
  }

  /**
   * Inhalt des Zeichen-Panels.
   * 
   * @param graphics
   *          Zum Zeichnen verwendetes Graphics-Objekt.
   */
  public void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);
    this.setBackground(Color.BLACK);
    graphics.setColor(Color.WHITE);


    for (int i=3; i<=24; i++) {
      for (int k=0; k<=i; k++) {
        this.drawLineFromK(graphics, k, i);
      }
    }
  }

  private void drawLineFromK(Graphics graphics, int k, int div) {
    int yMover = this.getSize().height / 2;
    int xMover = this.getSize().width / 2;
    int x1 = this.calculateX(k-1, div)+xMover;
    int x2 = this.calculateX(k, div)+xMover;
    int y1 = this.calculateY(k-1, div)+yMover;
    int y2 = this.calculateY(k, div)+yMover;
    graphics.drawLine(x1, y1, x2, y2);
  }

  private int calculateX(int k, int div) {
    return (int)(400 * Math.cos(k*2*Math.PI/div));
  }

  private int calculateY(int k, int div) {
    return (int)(400 * Math.sin(k*2*Math.PI/div));
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Graphics Window");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(new GraphicsPanel());
    frame.pack();
    frame.setVisible(true);
  }
}
