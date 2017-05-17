import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TCommand 
{
	TPanel tp = null;
	TPainter bst = null;
	TButtonPanel TButtonPanel = null;
	ButtonDrawListener btnDrawList = new ButtonDrawListener();
	ButtonAddListener btnAddList = new ButtonAddListener();
	ButtonDelListener btnDelList = new ButtonDelListener();
	int width;

	public TCommand(TPanel tp) 
	{
		this.tp = tp;
		bst = new TPainter();
		int[] arr = {50,20,30,40,11,22,33,44,135,67,77,86,99,66,12,136,137,156,176};
		bst.init(arr);
		width = tp.bi.getWidth();

	}

	class ButtonDrawListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{ 
			bst.draw(tp, width);
			tp.repaint();
		}

	}
	class ButtonAddListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			int valadd = Integer.parseInt(TButtonPanel.txtvaladd.getText());
			bst.add(valadd);
			bst.draw(tp, width);
			tp.repaint();
		}

	}
	
	class ButtonDelListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			int valdel = Integer.parseInt(TButtonPanel.txtvaldel.getText());
			bst.del(valdel);	
			bst.draw(tp, width);
			tp.repaint();
		}
		
	}

}

