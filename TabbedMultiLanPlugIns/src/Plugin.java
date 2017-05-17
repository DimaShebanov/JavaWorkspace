import java.awt.Graphics2D;
import java.awt.Rectangle;

public interface Plugin
{
	public void draw(Graphics2D gg, Figure fig);
	public void invoke(RMButtonPanel rmbp, RMCommand rmc);
}
