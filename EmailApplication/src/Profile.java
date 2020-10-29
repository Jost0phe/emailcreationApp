import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Profile {

	private JFrame frame;
	private JTextField txtLogin;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile window = new Profile();
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
	public Profile() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 660, 463);
		frame.setTitle("Your profile");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblYourProfile = new JLabel("Your profile");
		lblYourProfile.setFont(lblYourProfile.getFont().deriveFont(lblYourProfile.getFont().getStyle() | Font.BOLD));
		lblYourProfile.setBounds(20, 81, 600, 14);
		frame.getContentPane().add(lblYourProfile);
		
		JLabel lblNewLabel = new JLabel("Here are your basics informations");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel.setBounds(20, 106, 375, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblAlreadyHaveAn = new JLabel("Click below to modify your profile");
		lblAlreadyHaveAn.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblAlreadyHaveAn.setBounds(10, 340, 375, 28);
		frame.getContentPane().add(lblAlreadyHaveAn);
		
		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ModifyProfile mdfprofile;
				try {
					mdfprofile = new ModifyProfile();
					mdfprofile.main(null);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnModify.setFont(btnModify.getFont().deriveFont(btnModify.getFont().getStyle() | Font.BOLD));
		btnModify.setBounds(52, 371, 150, 23);
		frame.getContentPane().add(btnModify);
		
		JLabel labelFirstName = new JLabel("First Name :");
		labelFirstName.setFont(labelFirstName.getFont().deriveFont(labelFirstName.getFont().getStyle() | Font.BOLD));
		labelFirstName.setBounds(10, 145, 127, 14);
		frame.getContentPane().add(labelFirstName);
		
		JLabel firstNameLabel = new JLabel("");
		firstNameLabel.setBounds(20, 166, 127, 14);
		frame.getContentPane().add(firstNameLabel);
		
		JLabel labelLastName = new JLabel("Last Name :");
		labelLastName.setFont(labelLastName.getFont().deriveFont(labelLastName.getFont().getStyle() | Font.BOLD));
		labelLastName.setBounds(10, 191, 127, 14);
		frame.getContentPane().add(labelLastName);
		
		JLabel lastNameLabel = new JLabel("");
		lastNameLabel.setBounds(20, 216, 127, 14);
		frame.getContentPane().add(lastNameLabel);
		
		JLabel labelDepartment = new JLabel("Department :");
		labelDepartment.setFont(labelDepartment.getFont().deriveFont(labelDepartment.getFont().getStyle() | Font.BOLD));
		labelDepartment.setBounds(10, 244, 127, 14);
		frame.getContentPane().add(labelDepartment);
		
		JLabel departmentLabel = new JLabel("");
		departmentLabel.setBounds(20, 265, 127, 14);
		frame.getContentPane().add(departmentLabel);
		
		JLabel lblCapacity = new JLabel("Capacity :");
		lblCapacity.setFont(lblCapacity.getFont().deriveFont(lblCapacity.getFont().getStyle() | Font.BOLD));
		lblCapacity.setBounds(10, 290, 127, 14);
		frame.getContentPane().add(lblCapacity);
		
		JLabel labelCapacity = new JLabel("");
		labelCapacity.setBounds(20, 315, 127, 14);
		frame.getContentPane().add(labelCapacity);
		
		JLabel lblAlternateEmail = new JLabel("Alternate Email :");
		lblAlternateEmail.setFont(lblAlternateEmail.getFont().deriveFont(lblAlternateEmail.getFont().getStyle() | Font.BOLD));
		lblAlternateEmail.setBounds(237, 145, 127, 14);
		frame.getContentPane().add(lblAlternateEmail);
		
		JLabel labelAlternate = new JLabel("");
		labelAlternate.setBounds(247, 166, 127, 14);
		frame.getContentPane().add(labelAlternate);
		
		JLabel lblCorporateEmail = new JLabel("Corporate Email :");
		lblCorporateEmail.setFont(lblCorporateEmail.getFont().deriveFont(lblCorporateEmail.getFont().getStyle() | Font.BOLD));
		lblCorporateEmail.setBounds(237, 191, 127, 14);
		frame.getContentPane().add(lblCorporateEmail);
		
		JLabel labelCorporate = new JLabel("");
		labelCorporate.setBounds(247, 216, 127, 14);
		frame.getContentPane().add(labelCorporate);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(lblPassword.getFont().deriveFont(lblPassword.getFont().getStyle() | Font.BOLD));
		lblPassword.setBounds(237, 244, 127, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel labelPassword = new JLabel("");
		labelPassword.setBounds(247, 265, 127, 14);
		frame.getContentPane().add(labelPassword);
		
		txtLogin = new JTextField();
		txtLogin.setText("login");
		txtLogin.setBounds(10, 21, 217, 20);
		frame.getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(237, 21, 217, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String inputLogin = txtLogin.getText();
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
								firstNameLabel.setText(rs2.getString(2));
								lastNameLabel.setText(rs2.getString(3));
								departmentLabel.setText(rs2.getString(4));
								labelCapacity.setText(String.valueOf(rs2.getInt(5)));
								labelAlternate.setText(rs2.getString(6));
								labelCorporate.setText(rs2.getString(7));
								labelPassword.setText(rs2.getString(8));
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
		btnLogIn.setBounds(470, 20, 150, 23);
		frame.getContentPane().add(btnLogIn);
		
		JButton btnNewButton = new JButton("Create email");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setBounds(470, 47, 150, 23);
		frame.getContentPane().add(btnNewButton);
		BufferedImage myPic = ImageIO.read(this.getClass().getResource("banniere.jpg"));
		JLabel labelImage = new JLabel(new ImageIcon(myPic));
		labelImage.setBounds(237, 299, 367, 112);
		frame.getContentPane().add(labelImage);
		
	}
}
