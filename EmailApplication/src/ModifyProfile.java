import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ModifyProfile {

	private JFrame frame;
	private JTextField firstnamefield;
	private JTextField lastnamefield;
	private JTextField departmentfield;
	private JTextField capacityfield;
	private JTextField alternatefield;
	private JTextField corporatefield;
	private JTextField passwordfield;
	private JTextField textfieldLogin;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyProfile window = new ModifyProfile();
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
	public ModifyProfile() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 660, 463);
		frame.setTitle("Modify your profile");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblYourProfile = new JLabel("Your profile");
		lblYourProfile.setFont(lblYourProfile.getFont().deriveFont(lblYourProfile.getFont().getStyle() | Font.BOLD));
		lblYourProfile.setBounds(20, 74, 600, 14);
		frame.getContentPane().add(lblYourProfile);
		
		JLabel lblNewLabel = new JLabel("Modify any information that might not be up to date");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel.setBounds(20, 99, 375, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel labelFirstName = new JLabel("First Name :");
		labelFirstName.setFont(labelFirstName.getFont().deriveFont(labelFirstName.getFont().getStyle() | Font.BOLD));
		labelFirstName.setBounds(10, 138, 127, 14);
		frame.getContentPane().add(labelFirstName);
		
		JLabel labelLastName = new JLabel("Last Name :");
		labelLastName.setFont(labelLastName.getFont().deriveFont(labelLastName.getFont().getStyle() | Font.BOLD));
		labelLastName.setBounds(10, 184, 127, 14);
		frame.getContentPane().add(labelLastName);
		
		JLabel labelDepartment = new JLabel("Department :");
		labelDepartment.setFont(labelDepartment.getFont().deriveFont(labelDepartment.getFont().getStyle() | Font.BOLD));
		labelDepartment.setBounds(10, 237, 127, 14);
		frame.getContentPane().add(labelDepartment);
		
		JLabel lblCapacity = new JLabel("Capacity :");
		lblCapacity.setFont(lblCapacity.getFont().deriveFont(lblCapacity.getFont().getStyle() | Font.BOLD));
		lblCapacity.setBounds(10, 283, 127, 14);
		frame.getContentPane().add(lblCapacity);
		
		JLabel lblAlternateEmail = new JLabel("Alternate Email :");
		lblAlternateEmail.setFont(lblAlternateEmail.getFont().deriveFont(lblAlternateEmail.getFont().getStyle() | Font.BOLD));
		lblAlternateEmail.setBounds(237, 138, 127, 14);
		frame.getContentPane().add(lblAlternateEmail);
		
		JLabel lblCorporateEmail = new JLabel("Corporate Email :");
		lblCorporateEmail.setFont(lblCorporateEmail.getFont().deriveFont(lblCorporateEmail.getFont().getStyle() | Font.BOLD));
		lblCorporateEmail.setBounds(237, 184, 127, 14);
		frame.getContentPane().add(lblCorporateEmail);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(lblPassword.getFont().deriveFont(lblPassword.getFont().getStyle() | Font.BOLD));
		lblPassword.setBounds(237, 237, 127, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblAlreadyHaveAn = new JLabel("Click below to save changes");
		lblAlreadyHaveAn.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblAlreadyHaveAn.setBounds(10, 333, 375, 28);
		frame.getContentPane().add(lblAlreadyHaveAn);
		
		JButton btnSave = new JButton("Save Changes");
		btnSave.setFont(btnSave.getFont().deriveFont(btnSave.getFont().getStyle() | Font.BOLD));
		btnSave.setBounds(52, 364, 150, 23);
		frame.getContentPane().add(btnSave);
		
		firstnamefield = new JTextField();
		firstnamefield.setBounds(20, 153, 170, 20);
		frame.getContentPane().add(firstnamefield);
		firstnamefield.setColumns(10);
		
		lastnamefield = new JTextField();
		lastnamefield.setColumns(10);
		lastnamefield.setBounds(20, 206, 170, 20);
		frame.getContentPane().add(lastnamefield);
		
		departmentfield = new JTextField();
		departmentfield.setColumns(10);
		departmentfield.setBounds(20, 262, 170, 20);
		frame.getContentPane().add(departmentfield);
		
		capacityfield = new JTextField();
		capacityfield.setColumns(10);
		capacityfield.setBounds(20, 308, 170, 20);
		frame.getContentPane().add(capacityfield);
		
		alternatefield = new JTextField();
		alternatefield.setColumns(10);
		alternatefield.setBounds(245, 153, 170, 20);
		frame.getContentPane().add(alternatefield);
		
		corporatefield = new JTextField();
		corporatefield.setColumns(10);
		corporatefield.setBounds(245, 209, 170, 20);
		frame.getContentPane().add(corporatefield);
		
		passwordfield = new JTextField();
		passwordfield.setColumns(10);
		passwordfield.setBounds(245, 262, 170, 20);
		frame.getContentPane().add(passwordfield);
		
		textfieldLogin = new JTextField();
		textfieldLogin.setText("login");
		textfieldLogin.setColumns(10);
		textfieldLogin.setBounds(10, 12, 217, 20);
		frame.getContentPane().add(textfieldLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(237, 12, 217, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String inputLogin = textfieldLogin.getText();
					String inputPassword = new String(passwordField.getPassword());
					try {
						String url = "jdbc:mysql://localhost:3306/Emails?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GB";
						String user = "root";
						String passwordRoot = "Clamart77";
						Connection con = DriverManager.getConnection(url, user, passwordRoot);
			//			System.out.println("Success");
						
						Statement stmt = con.createStatement();
						
						String sql = "SELECT corporatemail, password FROM email WHERE corporatemail = '"+ inputLogin + "' and password = '"+ inputPassword +"';";
						ResultSet rs = stmt.executeQuery(sql);
						if(rs.next()) {
							JOptionPane.showMessageDialog(null, "Success");
							lblYourProfile.setText(rs.getString(1));
							String sql2 = "SELECT * FROM email WHERE corporatemail ='"+ inputLogin +"';";
							ResultSet rs2 = stmt.executeQuery(sql2);
							while(rs2.next()) {
								firstnamefield.setText(rs2.getString(2));
								lastnamefield.setText(rs2.getString(3));
								departmentfield.setText(rs2.getString(4));
								capacityfield.setText(String.valueOf(rs2.getInt(5)));
								alternatefield.setText(rs2.getString(6));
								corporatefield.setText(rs2.getString(7));
								passwordfield.setText(rs2.getString(8));
							}	
						}else {
							JOptionPane.showMessageDialog(null, "Incorect username or password");
						}	
					}catch(Exception c){
						c.printStackTrace();
				}
			}
		});
		btnLogIn.setFont(btnLogIn.getFont().deriveFont(btnLogIn.getFont().getStyle() | Font.BOLD));
		btnLogIn.setBounds(470, 11, 150, 23);
		frame.getContentPane().add(btnLogIn);
		
		JButton btnEmailApp = new JButton("Create email");
		btnEmailApp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				EmailApp emailapp;
				try {
					emailapp = new EmailApp();
					EmailApp.main(null);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEmailApp.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEmailApp.setBounds(470, 38, 150, 23);
		frame.getContentPane().add(btnEmailApp);	
		
		
		BufferedImage myPic = ImageIO.read(this.getClass().getResource("banniere.jpg"));
		JLabel labelImage = new JLabel(new ImageIcon(myPic));
		labelImage.setBounds(237, 293, 367, 112);
		frame.getContentPane().add(labelImage);
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String url = "jdbc:mysql://localhost:3306/Emails?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GB";
					String user = "root";
					String passwordRoot = "Clamart77";
					int userId ;
					
					Connection con = DriverManager.getConnection(url, user, passwordRoot);
					String sql1 = "SELECT id FROM email WHERE corporatemail = '" + textfieldLogin.getText()+ "';";
					PreparedStatement ps = con.prepareStatement(sql1);
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						userId = rs.getInt(1);
						PreparedStatement ps2= con.prepareStatement("UPDATE email SET firstname = ?, lastname = ?, department = ?, capacity = ?, alternate = ?, corporatemail = ?, password = ? WHERE id = "+ userId + ";");
						ps2.setString(1, firstnamefield.getText());
						ps2.setString(2, lastnamefield.getText());
						ps2.setString(3, departmentfield.getText());
						ps2.setInt(4, Integer.valueOf(capacityfield.getText()));
						ps2.setString(5, alternatefield.getText());
						ps2.setString(6, corporatefield.getText());
						ps2.setString(7, passwordfield.getText());
						ps2.executeUpdate();	
						JOptionPane.showMessageDialog(null, "Saved");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

}
