import java.sql.Connection;//imports for connection
import java.sql.DriverManager;
import java.sql.Statement;// import for statment 



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class First implements ActionListener{
	Frame F = new Frame();
	Button sendDb; 
	Label regno;
	Label name; 
	Label marks; 
	TextField screen = new TextField(20);
	TextField screen2 = new TextField(20);
	TextField screen3 = new TextField(20);
	Panel p2 = new Panel();
	
	public First(){
		
		
		p2.setLayout(new GridLayout(4,4));
		sendDb = new Button("send to qa school db");
		regno = new Label("REGNO:");
		name = new Label("NAME:");
		marks = new Label("MARKS:");
		
		p2.add(regno);
		p2.add(screen);
		p2.add(name);
		p2.add(screen2);
		p2.add(marks);
		p2.add(screen3); 
		p2.add(sendDb);
		
		
		
		sendDb.addActionListener(this);
		
		F.add(p2, BorderLayout.CENTER);
		F.setSize(400, 200);
		F.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {

		new First();
		
	}

  

	@Override
	public void actionPerformed(ActionEvent E) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");// Driver
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/qa","root","");//Ip adress/name of db/username,password
			
			Statement St = con.createStatement();
			St.executeUpdate("insert into school values("+ screen.getText()+","+"'"+screen2.getText()+"'"+","+screen3.getText()+")"); 
			

		}catch(Exception e) {
			System.out.print(e.toString());
		}
		
		
		
	}
}
