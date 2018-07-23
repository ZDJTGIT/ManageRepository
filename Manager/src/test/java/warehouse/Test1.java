package warehouse;

import com.zd.manager.core.util.ShiroUtils;

/**
 * @author Kstar:
 * @version 2018年6月30日 上午10:25:16
 * 
 */
public class Test1 {

	public static void main(String[] args) {
//		String a = "123.456.789";
//		String[] split = a.split("\\.");
//		System.out.println(split.length);
//		System.out.println(a.length());
//		System.out.println(a.substring(0, a.length()+1));
		String encryptPassword = ShiroUtils.encryptPassword("123456", "admin");
		System.out.println(encryptPassword);
	}

}
