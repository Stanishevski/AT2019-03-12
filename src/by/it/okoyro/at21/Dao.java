package by.it.okoyro.at21;

public class Dao {
	private static Dao dao; //синглтон для Dao
	public UserDao user;

	public static Dao getDao(){
		if (dao==null){
			synchronized (Dao.class){
				if (dao==null){
					dao = new Dao();
					dao.user = new UserDao();
				}
			}

		}
		return dao;
	}

}
