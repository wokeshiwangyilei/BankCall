package project;

public class Change {
	public static String eX(Object a) {
		if (a.equals("普通业务")) {
			return "普通";
		} else if (a.equals("vip业务")) {
			return "vip";
		} else if(a.equals("对公业务")){
			return "对公";
		}
		return null;

	}

}
