package xsl.java.create.view.main;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

/**
 * @author lixiuwen
 * Description: 
 * 
 * Company: Gzzhongtu Software ltd.
 * @date 2014-7-30下午3:07:01
 * @version v1.0
 * 
 */
public class CheckBoxPanel extends JPanel {
	private static final long serialVersionUID = -6890744052614355568L;
	private JCheckBox ibatis, java, doc, dao, xUtils;
	public static final String IBATIS = "ibatis";
	public static final String JAVA = "java";
	public static final String DOC = "doc";
	public static final String DAO = "dao";
	public static final String XUTILS = "xUtils";
	private List<String> list;
	JCheckBox[] checkBoxPanels;

	public CheckBoxPanel() {
		super();
		list = new ArrayList<String>();

		ibatis = new JCheckBox(IBATIS,null,true);
		java = new JCheckBox(JAVA,null,true);
		doc = new JCheckBox(DOC);
		dao = new JCheckBox(DAO);
		xUtils = new JCheckBox(XUTILS);

		checkBoxPanels = new JCheckBox[] { ibatis, java, doc, dao, xUtils };
		for (int i = 0; i < checkBoxPanels.length; i++) {
			this.add(checkBoxPanels[i]);
		}
	}

	public List<String> getCheckList() {
		list.clear();
		for (int i = 0; i < checkBoxPanels.length; i++) {
			if (checkBoxPanels[i].isSelected()) {
				list.add(checkBoxPanels[i].getText());
			}
		}
		return list;
	}

}
