import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class UserController extends AbstractController {
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        List<User> userList = new ArrayList<User>();
        User userA = new User();
        User userB = new User();
        userA.setUsername("zhangsan");
        userA.setAge(12);

        userB.setUsername("lisi");
        userB.setAge(12);
        userList.add(userA);
        userList.add(userB);
        return new ModelAndView("userlist", "users", userList);
    }
}
