import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Principal {

	public static void main(String[] args) {
		JButton btn = new JButton("Salvar");
		
		
		JFrame frame = new JFrame("Teste");
		frame.setSize(400, 100);	
		
		frame.add(btn);
		frame.setVisible(true);
	
		//ActionListener ac = new AcList();
		btn.addActionListener(new AcList());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}