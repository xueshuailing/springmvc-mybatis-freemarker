package xsl.java.create.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import xsl.java.create.model.TableInfo;
import xsl.java.create.service.DbMetaData;
import xsl.java.create.util.JDBCUtil;
import xsl.java.create.util.TableInfoFactoty;
import xsl.java.create.view.main.db.DbType;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

/**
 * User: lxw
 * Date: 14-3-12 下午1:13
 */
public class FreemarkerTest {

    public static void main(String[] args) {
        Connection connection = JDBCUtil.getConn(DbType.MYSQL,"127.0.0.1/supermarkt","root","123");
        String dbName="supermarkt";
        String path=System.getProperty("user.dir"); //获取项目根目录
        // String path="d:/test";
        generateFile(connection, path, dbName);

    }

	/**
	 * @param connection
	 * @param packageName
	 * @param path
	 * @param dbName
	 */
	private static void generateFile(Connection connection,  String path, String dbName) {
		String allPath;
		try {
            Configuration configurationResource = new Configuration();//配置文件的模块
            File templateDirResource = new File(path+ResourceLocation.URL);
            configurationResource.setObjectWrapper(new DefaultObjectWrapper());
            configurationResource.setDefaultEncoding("UTF-8");
            configurationResource.setDirectoryForTemplateLoading(templateDirResource);
            Map<String, TemplatePackage> list = new HashMap<String, TemplatePackage>();//要生成的模板集合
            Template entity = configurationResource.getTemplate("javaClass.ftl");//实体类
            Template dao = configurationResource.getTemplate("dao.ftl");//dao
            Template service = configurationResource.getTemplate("service.ftl");//service
            Template controller = configurationResource.getTemplate("controller.ftl");//controller
            Template db = configurationResource.getTemplate("word_template.ftl");//数据库文档
            Template mybatis = configurationResource.getTemplate("mybatis.ftl");//mybatis配置 
            Template mapper = configurationResource.getTemplate("mappermybatis.ftl");//mybatis配置 resultMap 的那个配置文件
            Template listJsp = configurationResource.getTemplate("listJsp.ftl");//jsp模板
            Template addJsp = configurationResource.getTemplate("addJsp.ftl");//jsp模板
            Template configuration = configurationResource.getTemplate("configuration.ftl");//mybatis配置 主要是别名的引入 和配置文件的引入  
            list.put("entity", new TemplatePackage(entity, PackageNameLocation.ENTITY.getCode(),Type.JAVA,JavaType.ENTITY));
            list.put("dao", new TemplatePackage(dao, PackageNameLocation.DAO.getCode(),Type.JAVA,JavaType.DAO));
            list.put("service", new TemplatePackage(service, PackageNameLocation.SERVICE.getCode(),Type.JAVA,JavaType.SERVICE));
            list.put("controller", new TemplatePackage(controller, PackageNameLocation.CONTROLLER.getCode(),Type.JAVA,JavaType.CONTROLLER));
            list.put("mybatis",new TemplatePackage(mybatis, PackageNameLocation.MYBATIS.getCode(),Type.XML,JavaType.XML));
            list.put("mapper",new TemplatePackage(mapper, PackageNameLocation.MAPPER.getCode(),Type.XML,JavaType.XML));
            list.put("list",new TemplatePackage(listJsp, PackageNameLocation.JSP.getCode(),Type.JSP,JavaType.JSP));
            list.put("add",new TemplatePackage(addJsp, PackageNameLocation.JSP.getCode(),Type.JSP,JavaType.JSP));
            DbMetaData mysqlDbMeta = TableInfoFactoty.getDbMetaData(connection, DbType.MYSQL, dbName);
            List<TableInfo> infoList = mysqlDbMeta.getAllTableInfo();
            for (TableInfo tableInfo : infoList) {
            	 Map<String, Object> map = new HashMap<String, Object>();
            	for (Entry<String, TemplatePackage> entry : list.entrySet()) {
            		 if(entry.getValue().getType().getCode().equals(Type.JAVA.getCode())){
            			 allPath=path+ResourceType.JAVA.getCode()+entry.getValue().getPackageName().replace(".","/");
                         File file=new File(allPath);
                         if(!file.exists())
                         {
                             file.mkdirs();
                         }
            		 }else if(entry.getValue().getType().getCode().equals(Type.XML.getCode())){
            			 allPath=path+ResourceType.RESOURCE.getCode()+entry.getValue().getPackageName().replace(".","/");
                         File file=new File(allPath);
                         if(!file.exists())
                         {
                             file.mkdirs();
                         }
            		 }else {
            			 allPath=path+ResourceType.JSP.getCode()+PackageNameLocation.JSPURL.getCode()+"/"+tableInfo.getTableClassName();
                         File file=new File(allPath);
                         if(!file.exists())
                         {
                             file.mkdirs();
                         }
            		 }
            		   map.clear();//先清空map
            		   map.put("tableInfo", tableInfo);
                       map.put("packageName", entry.getValue().getPackageName());
                       map.put("interceptUrl", PackageNameLocation.INTERCEPURL.getCode());//拦截器统一名字
                       map.put("jsp", PackageNameLocation.JSPURL.getCode());
                       map.put("entityPackageName", PackageNameLocation.ENTITY.getCode());
                       map.put("daoPackageName", PackageNameLocation.DAO.getCode());
                       map.put("servicePackageName", PackageNameLocation.SERVICE.getCode());
                       if(entry.getValue().getType().getCode().equals(Type.JAVA.getCode())){
                    	   Writer writer = new OutputStreamWriter(new FileOutputStream(allPath+File.separator + tableInfo.getTableClassName()+entry.getValue().getJavaType().getCode() + ".java"), "UTF-8");
                    	   entry.getValue().getTemplate().process(map, writer);
                    	   writer.close();
                       }else if(entry.getValue().getType().getCode().equals(Type.XML.getCode())){
                    	   Writer writer = new OutputStreamWriter(new FileOutputStream(allPath+File.separator + tableInfo.getTableClassName() + ".xml"), "UTF-8");
                    	   entry.getValue().getTemplate().process(map, writer);
                    	   writer.close();

                       }else{
                    	   Writer writer = new OutputStreamWriter(new FileOutputStream(allPath+File.separator  +entry.getKey()+ ".jsp"), "UTF-8");//list页面
                    	   Writer add = new OutputStreamWriter(new FileOutputStream(allPath+File.separator  +entry.getKey()+ ".jsp"), "UTF-8");//添加页面
                    	   entry.getValue().getTemplate().process(map, writer);
                    	   entry.getValue().getTemplate().process(map, add);
                    	   writer.close();
                    	   add.close();
                       }
                      
            	}
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("infoList", infoList);
            map.put("packageName", PackageNameLocation.ENTITY.getCode());
            Writer wordWrite=new OutputStreamWriter(new FileOutputStream(path+ResourceType.RESOURCE.getCode()+"数据库文档.doc"));
            db.process(map,wordWrite);
            wordWrite.close();
            Writer writer = new OutputStreamWriter(new FileOutputStream(path+ResourceType.RESOURCE.getCode()+"configure/mybatis"+File.separator + "Configuration.xml"), "UTF-8");
            configuration.process(map,writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.free(connection);
        }
	}
}
