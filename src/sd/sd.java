package sd;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileSystemView;

import java.awt.Window.Type;

public class sd {

	public JFrame frame;
	public static String str;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sd window = new sd();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public sd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setForeground(new Color(0, 255, 0));
		frame.setBackground(new Color(255, 0, 0));
		frame.setResizable(false);
		frame.setType(Type.UTILITY);
		frame.setTitle("\u7F16\u8BD1\u539F\u7406");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 878, 501);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(155, 68, 700, 382);
		frame.getContentPane().add(scrollPane);

		final JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(124, 19, 654, 32);
		frame.getContentPane().add(scrollPane_1);

		final JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);

		JButton button1 = new JButton("\u6587\u4EF6");
		button1.setHorizontalAlignment(SwingConstants.CENTER);
		button1.setFont(new Font("宋体", Font.PLAIN, 13));
		button1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JFileChooser filechooser = new JFileChooser();// 创建文件选择器
				FileSystemView fsv = FileSystemView.getFileSystemView();  //注意了，这里重要的一句  
				filechooser.setCurrentDirectory(fsv.getHomeDirectory());// fsv.getHomeDirectory()获取桌面路径
				filechooser.showOpenDialog(null);
				File f = filechooser.getSelectedFile();// 读取文件路径存到f中
				str = f.getAbsolutePath();// 将文件路径传给str
				textArea_1.setText(str);
//				if(str!=null)
//					textArea.setText("文件读取成功！");
//				 int i=str.length()-1;        //路径字符串处理
//	        	 while(str.charAt(i)!='\\')
//	        		 i--;
//	        str= str.substring(0,i+1);
			}
		});
		button1.setBackground(SystemColor.inactiveCaptionBorder);
		button1.setBounds(1, 15, 69, 33);
		frame.getContentPane().add(button1);

		JLabel label_1 = new JLabel("\u8DEF\u5F84\uFF1A");
		label_1.setFont(new Font("仿宋", Font.PLAIN, 13));
		label_1.setBounds(88, 24, 51, 22);
		frame.getContentPane().add(label_1);

		JButton button = new JButton("\u786E\u5B9A");
		button.setFont(new Font("宋体", Font.PLAIN, 13));
		button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e1) {
				str = textArea_1.getText();
//				if(str!=null)
//					textArea.setText("文件读取成功！");
//				 int i=str.length()-1;   //路径字符串的处理
//	        	 while(str.charAt(i)!='\\') //"\\"表示路径中的"\"
//	        		 i--;
//	        str= str.substring(0,i+1);//生成文件的文件夹路径给变量str
			}

		});
		button.setBounds(781, 17, 69, 33);
		frame.getContentPane().add(button);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(2, 83, 140, 354);
		frame.getContentPane().add(panel);

		JButton button_1 = new JButton("\u6E90\u4EE3\u7801");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 13));
		button_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {// 源代码按钮监视器
				output(textArea, str);

			}

		});
		button_1.setBounds(25, 10, 105, 31);
		panel.add(button_1);

		JButton button_2 = new JButton("\u9519\u8BEF");
		button_2.addMouseListener(new MouseAdapter() {// 错误按钮监视器
			@Override
			public void mouseClicked(MouseEvent e) {
				
				output(textArea, "ErrorLog.txt");	
			}
		});
		button_2.setFont(new Font("宋体", Font.PLAIN, 13));
		button_2.setBounds(26, 65, 105, 31);
		panel.add(button_2);

		JButton button_3 = new JButton("\u8BCD\u6CD5");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {// 词法按钮监视器
				output(textArea, "testToken.txt");
			}
		});
		button_3.setFont(new Font("宋体", Font.PLAIN, 13));
		button_3.setBounds(26, 120, 105, 31);
		panel.add(button_3);

		JButton button_4 = new JButton("\u8BED\u6CD5");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {// 语法按钮监视器
				output(textArea, "testGrammar.txt");

			}
		});
		button_4.setFont(new Font("宋体", Font.PLAIN, 13));
		button_4.setBounds(26, 175, 105, 31);
		panel.add(button_4);

		JButton button_5 = new JButton("\u8BED\u4E49");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {// 语义按钮监视器
				output(textArea, "resultYuYi.txt");
			}
		});
		button_5.setFont(new Font("宋体", Font.PLAIN, 13));
		button_5.setBounds(26, 230, 105, 31);
		panel.add(button_5);

	}

	public void output(JTextArea textArea, String str1) {//将文件内容从界面输出，参数输出位置和路径
		if (str1 == null)
			textArea.setText("请选择要读取的文件！");
		File fRead = new File(str1);
		textArea.setText(null);
		Reader in;
		try {
			in = new FileReader(fRead);

			BufferedReader bufferRead = new BufferedReader(in);
			String S = bufferRead.readLine();
			while (S != null) {
				textArea.append(S + "\n");
				S = bufferRead.readLine();
			}

		} catch (FileNotFoundException e1) {

		} catch (IOException e1) {

		}

	}
}
// I:\eclipse_javacc\eclipse_javacc\java\G\test.txt