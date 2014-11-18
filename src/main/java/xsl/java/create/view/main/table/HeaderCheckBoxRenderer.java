package xsl.java.create.view.main.table;


import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * <b>システム名：</b>ヤマト運行管理システム。<br>
 * <b>機能名称：</b>共通コンポーネント⇒Table用セルのレーンダー<br>
 * <b>機能説明：</b>Table用セルのレンダ<br>
 * <b>変更履歴：</b>2012/10/23 李海軍 新規<br>
 * <br>
 * 
 * @author 李海軍
 * @since 1.0.0
 * @version 1.0.0 2012/10/23 初版
 * <p>
 */
public class HeaderCheckBoxRenderer extends JCheckBox implements TableCellRenderer {
    /**
     * ID
     */
    private static final long serialVersionUID = -3224639986882887200L;

    /**
     * コンストラクション。<br>
     */
    public HeaderCheckBoxRenderer() {
        this.setBorderPainted(true);
    }

    /*
     * (non-Javadoc)
     * @see javax.swing.table.TableCellRenderer#getTableCellRendererComponent(javax.swing.JTable, java.lang.Object,
     * boolean, boolean, int, int)
     */
    @Override
    public Component getTableCellRendererComponent(JTable table,
                                                   Object value,
                                                   boolean isSelected,
                                                   boolean hasFocus,
                                                   int row,
                                                   int column) {
        return this;
    }

}
