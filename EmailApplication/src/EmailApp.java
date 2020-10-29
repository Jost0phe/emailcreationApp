import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class EmailApp {

	private JFrame frame;
	private JTextField firstnamefield;
	private JTextField lastnamefield;
	private JTextField departmentfield;
	private JTextField alternatemailfield;
	private int capacity = 10000;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmailApp window = new EmailApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public EmailApp() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 660, 463);
		frame.setTitle("Email creation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel labelTitre = new JLabel("Email creation");
		labelTitre.setFont(labelTitre.getFont().deriveFont(labelTitre.getFont().getStyle() | Font.BOLD));
		labelTitre.setBounds(27, 31, 150, 14);
		frame.getContentPane().add(labelTitre);
		
		JLabel labelFname = new JLabel("First name :");
		labelFname.setFont(labelFname.getFont().deriveFont(labelFname.getFont().getStyle() | Font.BOLD));
		labelFname.setBounds(69, 94, 150, 14);
		frame.getContentPane().add(labelFname);
		
		JLabel labelLname = new JLabel("Last Name :");
		labelLname.setFont(labelLname.getFont().deriveFont(labelLname.getFont().getStyle() | Font.BOLD));
		labelLname.setBounds(69, 143, 150, 14);
		frame.getContentPane().add(labelLname);
		
		firstnamefield = new JTextField();
		firstnamefield.setBounds(69, 112, 150, 20);
		frame.getContentPane().add(firstnamefield);
		firstnamefield.setColumns(10);
		
		lastnamefield = new JTextField();
		lastnamefield.setColumns(10);
		lastnamefield.setBounds(69, 168, 150, 20);
		frame.getContentPane().add(lastnamefield);
		
		JLabel labelDepartment = new JLabel("Department :");
		labelDepartment.setFont(labelDepartment.getFont().deriveFont(labelDepartment.getFont().getStyle() | Font.BOLD));
		labelDepartment.setBounds(69, 199, 150, 14);
		frame.getContentPane().add(labelDepartment);
		
		departmentfield = new JTextField();
		departmentfield.setColumns(10);
		departmentfield.setBounds(69, 225, 150, 20);
		frame.getContentPane().add(departmentfield);
		
		alternatemailfield = new JTextField();
		alternatemailfield.setColumns(10);
		alternatemailfield.setBounds(69, 274, 150, 20);
		frame.getContentPane().add(alternatemailfield);
		
		JLabel labelAlternateMail = new JLabel("Alternate email :");
		labelAlternateMail.setFont(labelAlternateMail.getFont().deriveFont(labelAlternateMail.getFont().getStyle() | Font.BOLD));
		labelAlternateMail.setBounds(69, 256, 150, 14);
		frame.getContentPane().add(labelAlternateMail);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fname = firstnamefield.getText();
				String lname = lastnamefield.getText();
				String department = departmentfield.getText();
				String alternatemail = alternatemailfield.getText();
				String generatedpassword;
			    int leftLimit = 48; // numeral '0'
			    int rightLimit = 122; // letter 'z'
			    int targetStringLength = 10;
			    Random random = new Random();
			    generatedpassword = random.ints(leftLimit, rightLimit + 1)
			      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
			      .limit(targetStringLength)
			      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
			      .toString();
				
				String generatedemail = fname + "." + lname +"@" + department + ".steam.com";
				
				try {
					String url = "jdbc:mysql://localhost:3306/Emails?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GB";
					String user = "root";
					String password = "Clamart77";
					Connection con = DriverManager.getConnection(url, user, password);
				
					Statement stmt = con.createStatement();
					int stringId ;
					String sql = "SELECT MAX(id) FROM email";
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next()) {
						stringId = rs.getInt(1)+1;
						Statement stmt2 = con.createStatement();
						String sql2 = "SELECT * FROM email";
						ResultSet rs2 = stmt2.executeQuery(sql2);
						if(rs2.next()) {
							if(rs2.getString(7).equals(generatedemail)) {
								JOptionPane.showMessageDialog(null, "This profile already exists !");
							}else {
								PreparedStatement ps = con.prepareStatement("INSERT INTO email(id, firstname, lastname, department, capacity, alternate, corporatemail, password) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
								ps.setInt(1,  stringId);
								ps.setString(2, fname);
								ps.setString(3, lname);
								ps.setString(4, department);
								ps.setInt(5, capacity);
								ps.setString(6, alternatemail);
								ps.setString(7, generatedemail);
								ps.setString(8, generatedpassword);
								ps.executeUpdate();
								JOptionPane.showMessageDialog(null, "Data inserted");
							}
						}
					}	
				} catch (SQLException e1) {
					e1.printStackTrace();
				} 
			}
		});
		btnCreate.setFont(btnCreate.getFont().deriveFont(btnCreate.getFont().getStyle() | Font.BOLD));
		btnCreate.setBounds(69, 305, 150, 23);
		frame.getContentPane().add(btnCreate);
	
		BufferedImage myPic = ImageIO.read(this.getClass().getResource("banniere.jpg"));
		JLabel labelImage = new JLabel(new ImageIcon(myPic));
		labelImage.setBounds(259, 143, 367, 112);
		
		frame.getContentPane().add(labelImage);
		
		JLabel lblNewLabel = new JLabel("Please fill the following fields so we can create your personal adress");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel.setBounds(37, 56, 375, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblAlreadyHaveAn = new JLabel("Already have an adress? Click below to see your informations");
		lblAlreadyHaveAn.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblAlreadyHaveAn.setBounds(27, 339, 375, 28);
		frame.getContentPane().add(lblAlreadyHaveAn);
		
		JButton btnConsult = new JButton("My profile");
		btnConsult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Profile profile;
				try {
					profile = new Profile();
					profile.main(null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		});
		btnConsult.setFont(btnConsult.getFont().deriveFont(btnConsult.getFont().getStyle() | Font.BOLD));
		btnConsult.setBounds(69, 370, 150, 23);
		frame.getContentPane().add(btnConsult);
	}
}
