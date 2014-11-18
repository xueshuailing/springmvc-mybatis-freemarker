/*
 * Copyright (c) 2009-2010 SIS CORPORATION, All rights reserved.
 */
package xsl.java.create.view.main.table;



/**
 * <b>システム名：</b>ヤマト運行管理システム。<br>
 * <b>機能名称：</b>DDL作成画面⇒DDL出力モデル<br>
 * <b>機能説明：</b>DDL出力モデル<br>
 * <b>変更履歴：</b>2012/10/24 李海軍 新規<br>
 * <br>
 * 
 * @author 李海軍
 * @since 1.0.0
 * @version 1.0.0 2012/10/24 初版
 * <p>
 */
public class DDLExportTableModel extends MutiTableModel {
    /**
     * ID
     */
    private static final long serialVersionUID = 2901808435846952546L;

    /**
     * 表头
     */
    private static final String[] HEAD_TITLE = new String[] {"选择", "表名", "备注","主键"};

    /**
     * コンストラクション。<br>
     */
    public DDLExportTableModel() {
        super(HEAD_TITLE);
        // デーフォールトチェックコラム
        this.setCheckColumn(0);
    }

    /**
     * コンストラクション。<br>
     * 
     * @param datas データのコレクション
     * @throws Exception データ数が不正の異常
     */
    public DDLExportTableModel(Object[][] datas) throws Exception {
        this();
        // データのコレクションを設定する
        refreshContents(datas);
    }
}
