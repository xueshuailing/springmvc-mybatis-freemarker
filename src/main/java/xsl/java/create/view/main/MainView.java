package xsl.java.create.view.main;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import xsl.java.create.util.JDBCUtil;
import xsl.java.create.view.main.db.DbType;

/**
 * @author lixiuwen Description:
 * 
 *   Company: Gzzhongtu Software ltd.
 * @date 2014-7-30上午10:41:06
 * @version v1.0
 * 
 */
public class MainView extends JFrame {

	private JPanel outerPanel;// 外边框

	private static final long serialVersionUID = 1462686439906647500L;

	private Connection conn;

	public MainView(String title) throws HeadlessException {
		super(title);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainView("生成工具v1.0").initView().createPanel();
			}
		});

	}

	private MainView initView() {
		this.setSize(380, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(null);

		return this;
	}

	private JTextField dbURLText, dbUserText,dbNameText; // url和用户名 数据库名
	private JPasswordField dbPassText; // 密码
	private JComboBox<DbType> dbTypeComboBox;// 数据库类型
	private static final int TEXTFILLD_WIDTH = 200;
	private static final int TEXTFILLD_HEIGHT = 20;
	int top = 30; // 间隔

	private void createPanel() {
		outerPanel = new JPanel();
		outerPanel.setBounds(20, 10, 330, 180);
		outerPanel.setBorder(BorderFactory.createTitledBorder("数据库信息"));
		outerPanel.setLayout(null);
		addLabel("类  型：", "URL:", "用户名：", "密码：","数据库名:");
		dbPassText = new JPasswordField("123");
		dbURLText = new JTextField("127.0.0.1:3306/myfamily");
		dbUserText = new JTextField("root");
		dbNameText=new JTextField("myfamily");
		Vector<DbType> model = new Vector<DbType>();
		model.add(DbType.MYSQL);
		model.add(DbType.SQLSERVER);
		model.add(DbType.ORACLE);
		dbTypeComboBox = new JComboBox<DbType>(model);
		dbTypeComboBox.setFocusable(false);
		addCOmponent(dbTypeComboBox, dbURLText, dbUserText, dbPassText,dbNameText);
		getContentPane().add(outerPanel);
		addButton();
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				JDBCUtil.free(conn);//窗口关闭释放数据库连接
				System.out.println("连接释放");
			}
		});
		this.setResizable(false);
		this.setVisible(true);
	}

	/**
	 * 添加右边的组件，需要引用对象取值
	 * 
	 * @param fields
	 */
	private void addCOmponent(JComponent... fields) {

		for (int i = 0; i < fields.length; i++) {
			fields[i].setBounds(100, top * (i + 1), TEXTFILLD_WIDTH, TEXTFILLD_HEIGHT);
			outerPanel.add(fields[i]);
		}
	}

	/**
	 * 添加左边的label ，只做显示用
	 * 
	 * @param labels
	 */
	private void addLabel(String... labels) {
		for (int i = 0; i < labels.length; i++) {
			JLabel label = new JLabel(labels[i]);
			label.setBounds(20, top * (i + 1), 60, 20);
			outerPanel.add(label);
		}
	}

	private void addButton() {
		JButton testButton = new JButton("测试连接");
		JButton connButton = new JButton("连接");
		testButton.setBounds(60, 220, 100, 30);
		connButton.setBounds(200, 220, 100, 30);
		testButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (null != checkConn()) {
					JOptionPane.showMessageDialog(null, "数据库连接成功!");
				}
			}
		});
		connButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkConn();
				if (null != checkConn()) {
					DbType type = (DbType) dbTypeComboBox.getSelectedItem();
					String dbName=dbNameText.getText();
					new GeneraterMain(conn,type,dbName);
					MainView.this.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "数据库连接失败!");
				}
			}
		});
		this.getContentPane().add(testButton);
		this.getContentPane().add(connButton);
	}

	private Connection checkConn() {
		DbType type = (DbType) dbTypeComboBox.getSelectedItem();
		conn = JDBCUtil.getConn(type, dbURLText.getText(), dbUserText.getText(),
				String.valueOf(dbPassText.getPassword()));
		return conn;
	}
}
