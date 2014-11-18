package xsl.java.create.util;
/**
 * @author	lxw
 * 2013-9-15上午11:51:43
 * 处理名字
 * eg:
 * user_name -> UserName
 */
public class PorcessName {
	public static String getJavaName(String name, boolean startUpper) {
		name = name.toLowerCase();
		int pos = name.indexOf("_");
		name = name.replaceAll("_", "");
		char[] chars = name.toCharArray();
		if (startUpper)
			chars[0] = (char) (chars[0] - 32);
		if (pos != -1)
			chars[pos] = (char) (chars[pos] - 32);
		return String.valueOf(chars);
	}

	public static String replaceUnderlineAndfirstToUpper(String srcStr) {
		String newString = "";
		String org="_";
		int first = 0;
		if(srcStr.indexOf(org)==1)
		{
			srcStr=srcStr.substring(2);
		}
		while (srcStr.indexOf(org) != -1) {
			first = srcStr.indexOf(org);
			if (first != srcStr.length()) {
				newString = newString + srcStr.substring(0, first);
				srcStr = srcStr.substring(first + org.length(), srcStr.length());
				srcStr = firstCharacterToUpper(srcStr);
			}
		}
		newString = newString + srcStr;
		return newString;
	}
	public static String firstCharacterToUpper(String srcStr) {
		return srcStr.substring(0, 1).toUpperCase() + srcStr.substring(1);
	}
	
	public static String getJavaClassName(String srcStr){
		return firstCharacterToUpper(replaceUnderlineAndfirstToUpper(srcStr.toLowerCase()));
	}
    public static String getJavaType(String JdbcType){
       /* String[] arrystr = JdbcType.split("\\.");
        int pos = arrystr.length - 1;
        if("Timestamp".equals(arrystr[pos]))
        {
            return "Date";
        }
        if("BigDecimal".equals(arrystr[pos]))
        {
            return "Double";
        }
        return arrystr[pos];*/
    	return "String";
    }
	
	public static void main(String[] args) {
	}
	
}
