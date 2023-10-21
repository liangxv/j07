import com.woniuxy.dao.UserDao;
import com.woniuxy.dao.impl.UserDaoImpl;
import com.woniuxy.view.CommonView;
import com.woniuxy.view.ContactPersonView;
import com.woniuxy.view.UserView;
import com.woniuxy.view.WelcomeView;

import java.util.Scanner;

public class CrmApplication {
    private static final Scanner scanner = new Scanner(System.in);
    private static final UserDao userDao = new UserDaoImpl();

    public static void main(String[] args) {
        WelcomeView.operate();
        while (true) {
            //显示菜单
            CommonView.menu();
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    //调用员工管理模块
                    UserView.operate();
                    break;
                case 2:
                    //调用联系人管理模块
                    ContactPersonView.operate();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("输入有误！");
//            }

            }
        }
    }
}
