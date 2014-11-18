package xsl.java.create.view.main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import xsl.java.create.model.TableInfo;
import xsl.java.create.service.DbMetaData;
import xsl.java.create.util.JDBCUtil;
import xsl.java.create.util.TableInfoFactoty;
import xsl.java.create.view.main.db.DbType;
import xsl.java.create.view.main.table.DDLExportTableModel;
import xsl.java.create.view.main.table.MutiTable;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

/**
 * @author lixiuwen Description:
 * 
 *         Company: Gzzhongtu Software ltd.
 * @date 2014-7-30上午11:58:39
 * @version v1.0
 * 
 */
public class GeneraterMain extends JFrame {
	private static final long serialVersionUID = -1849662112222460844L;
	private MutiTable table;// 表格部分
	private Container contioner;// 根容器，采用border布局
	private Connection connection; // 数据库连接
	private DbMetaData tableInfoMetaData;// 数据库的元数据信息
	List<TableInfo> tableInfos;

	public GeneraterMain(final Connection conn, DbType dbType,String dbName) {
		this("生成工具v1.0");
		table = new MutiTable();
		contioner = getContentPane();
		this.connection = conn;
		contioner.add(new CheckBoxPanel(), BorderLayout.SOUTH);

		try {
			table.setModel(new DDLExportTableModel());
			table.setCheckHeaderColumn(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tableInfoMetaData = TableInfoFactoty.getDbMetaData(connection, dbType, dbName);
		tableInfos = tableInfoMetaData.getAllTableInfo();
		processDate();
		BorderLayout borderLayout = new BorderLayout(10, 10);
		contioner.setLayout(borderLayout);
		contioner.add(getSouthPanel(), BorderLayout.CENTER);
	}

	private List<String> checkList;
	private CheckBoxPanel checkBoxPanel;
	private JTextField pathField, packageField;

	private JPanel getSouthPanel() {

		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		p.setPreferredSize(new Dimension(150, 200));
		p.setBounds(0, 0, 200, 200);
		BoxLayout boxLayout = new BoxLayout(p, BoxLayout.Y_AXIS);
		p.setLayout(boxLayout);

		JPanel line1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		line1.add(new JLabel("选择要生成的内容："));
		checkBoxPanel = new CheckBoxPanel();
		line1.add(checkBoxPanel);
		JPanel line2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		line2.add(new JLabel("输入要生成JAVA类的包名："));
		line2.add(packageField = new JTextField("com.gzzhongtu", 20));

		JPanel line3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		line3.add(new JLabel("生 成 文 件 的输出目录："));
		line3.add(pathField = new JTextField(20));
		JButton browse = new JButton("浏览");
		browse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				if (chooser.showOpenDialog(GeneraterMain.this) == JFileChooser.APPROVE_OPTION) {
					pathField.setText(chooser.getSelectedFile().getAbsolutePath());
				}
			}
		});
		line3.add(browse);

		p.add(line1);
		p.add(line2);
		p.add(line3);

		JButton button = new JButton("生成");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkList = checkBoxPanel.getCheckList();
				if (checkList.size() == 0) {
					JOptionPane.showMessageDialog(null, "请选择要生成的项");
					return;
				}
				if (null == pathField.getText() || "" == pathField.getText().trim()) {
					JOptionPane.showMessageDialog(null, "请选择输出的目录");
					return;
				}
				String path = pathField.getText().replace("\\", "/") + File.separator + "生成的代码" + File.separator;
				generateFile(connection, packageField.getText(), path, "ydyx", checkList);
				JOptionPane.showMessageDialog(null, "生成完成");
				try {
					String[] cmd = new String[5];
					cmd[0] = "cmd";
					cmd[1] = "/c";
					cmd[2] = "start";
					cmd[3] = " ";
					cmd[4] = path;
					Runtime.getRuntime().exec(cmd);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		p.add(button);
		p.add(new JPanel());

		JPanel rightPanel = new JPanel(new BorderLayout(0, 10));
		rightPanel.add(new JScrollPane(table));
		rightPanel.add(p, BorderLayout.SOUTH);
		return rightPanel;

	}

	public GeneraterMain(String title) throws HeadlessException {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				JDBCUtil.free(connection);// 窗口关闭释放数据库连接
				System.out.println("连接释放2");
			}
		});
	}

	private void processDate() {
		int size = tableInfos.size();
		Object[][] dataObjects = new Object[size][4];
		for (int i = 0; i < size; i++) {
			dataObjects[i] = new Object[] { true, tableInfos.get(i).getTableName(), tableInfos.get(i).getTableRemark(),
					tableInfos.get(i).getTablePk() };
		}
		try {
			table.refreshContents(dataObjects);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void generateFile(Connection connection, String packageName, String path, String dbName,
			List<String> checkList) {

		String packagePath = packageName.replace(".", File.separator);
		String ibatisPath;
		String javaPath;
		String daoPath;
		String xUtilsPath;
		String docPath;

		try {
			Configuration configuration = new Configuration();
			File templateDir = new File(Thread.currentThread().getContextClassLoader().getResource("").getFile());
			configuration.setObjectWrapper(new DefaultObjectWrapper());
			configuration.setDefaultEncoding("UTF-8");
			configuration.setDirectoryForTemplateLoading(templateDir);

			ibatisPath = path + "ibatis" + File.separator + packagePath;
			new File(ibatisPath).mkdirs();

			javaPath = path + "java" + File.separator + packagePath;
			new File(javaPath).mkdirs();

			xUtilsPath = path + "xUtils" + File.separator + packagePath;
			new File(xUtilsPath).mkdirs();

			docPath = path + "数据库文档";
			new File(docPath).mkdirs();

			for (int i : table.getAllCheckedRows()) {
				TableInfo tableInfo = tableInfos.get(i);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("tableInfo", tableInfo);
				map.put("packageName", packageName);

				if (checkList.contains(CheckBoxPanel.JAVA)) {
					Template javaTemplate = configuration.getTemplate("javaClass.ftl");
					Writer writer = new OutputStreamWriter(new FileOutputStream(javaPath + File.separator
							+ tableInfo.getTableClassName() + ".java"), "UTF-8");
					javaTemplate.process(map, writer);
					writer.close();
				}

				if (checkList.contains(CheckBoxPanel.IBATIS)) {
					Template ibatisTemplate = configuration.getTemplate("ibatisXml.ftl");
					Writer ibatisWriter = new OutputStreamWriter(new FileOutputStream(ibatisPath + File.separator
							+ "ibatis-" + tableInfo.getTableClassName() + ".xml"), "UTF-8");
					ibatisTemplate.process(map, ibatisWriter);
					ibatisWriter.close();
				}

				if (checkList.contains(CheckBoxPanel.XUTILS)) {
					Template xUtilsTemplate = configuration.getTemplate("xUtilsClass.ftl");
					Writer xUtilsWriter = new OutputStreamWriter(new FileOutputStream(xUtilsPath + File.separator
							+ tableInfo.getTableClassName() + ".java"), "UTF-8");
					xUtilsTemplate.process(map, xUtilsWriter);
					xUtilsWriter.close();
				}
			}

			if (checkList.contains(CheckBoxPanel.DOC)) {
				Template wordTemplate = configuration.getTemplate("word_template.ftl");
				Writer wordWrite = new OutputStreamWriter(new FileOutputStream(docPath + File.separator + "数据库文档.doc"));
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("infoList", tableInfos);
				wordTemplate.process(map, wordWrite);
				wordWrite.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.free(connection);
		}
	}

}
