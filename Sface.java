import java.applet.*;
import java.awt.*;
import java.awt.event.*;
/* <applet code = "Sface.class" width = 300 height = 300> </applet> */
public class Sface  extends Applet implements ActionListener,Runnable
{
	boolean flag = true;
	int x = 530;
	int y = 250;
	Thread t = null;

	public void start()
	{
		t = new Thread(this);
		flag = false;
		t.start();
	}

	public void run()
	{
		for(;;)
		{
			try
			{
				repaint();
				Thread.sleep(100);
				if(flag)
					break;
			}

			catch(InterruptedException e)
			{
				System.out.println("Exception :- " + e);
			}
		}
	}

	public void stop()
	{
		flag = true;
		t = null;
	}

	Button b1 = new Button("UP");
	Button b2 = new Button("DOWN");
	Button b3 = new Button("LEFT");
	Button b4 = new Button("RIGHT");

	public void init()
	{
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			y = y - 10;

		}

		if(ae.getSource()==b2)
		{
			y = y + 10;

		}

		if(ae.getSource()==b3)
		{
			x = x - 10;
		}

		if(ae.getSource()==b4)
		{
			x = x + 10;
		}
	}

		public void paint(Graphics g)
	    {
	    	g.setColor(Color.YELLOW);
	        g.fillOval(x, y, 170, 170);
	        g.setColor(Color.BLACK);
	        g.fillOval(x+40, y+45, 15, 25);
	        g.fillOval(x+115, y+45, 15, 25);
	        g.fillOval(x+70,y+95,30,42);
	    }
    
}
