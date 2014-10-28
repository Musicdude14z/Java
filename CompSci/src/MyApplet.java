import java.applet.Applet;
import java.awt.*;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class MyApplet extends Applet {

	private static final long serialVersionUID = -5353920638735199161L;
	public static String name = "Zachary T. Kaplan";
	public static int x = 15, y = 15, dx = 1, dy = 1, height = 100, width = 200, l, h;
	public static Thread t;
	
	public void init() {
		height = Integer.parseInt(getParameter("height"));
		width = Integer.parseInt(getParameter("width"));
		Rectangle2D r2= getFont().getStringBounds(name, 
				getGraphics().getFontMetrics().getFontRenderContext());
		l = (int) r2.getMaxX();
		h = (int) r2.getMaxY();
		setSize(height, width);
		JPanel jp;
		add(jp = new JPanel(true) {
			
			private static final long serialVersionUID = -7102127365903538244L;

			public void screenUpdate() {
				Toolkit.getDefaultToolkit().sync();
			}
			
			public void paintComponent(Graphics graphics) {
				Graphics2D g = (Graphics2D) graphics;
				
				g.clearRect(0, 0, width, height);
				x += dx;
				y += dy;
				if(x+l >= width || x < 0) dx = -dx;
				if(y+h >= height || y < 0) dy = -dy;
				g.setColor(Color.BLACK);
				g.drawString(name, x, y);
				screenUpdate();
				repaint();
				try {
					Thread.sleep(1000/60);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		jp.setPreferredSize(new Dimension(height, width));
	}
	
}