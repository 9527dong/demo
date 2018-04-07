package parse;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;
import pojo.User;

/**
 * Created with IntelliJ IDEA.
 * User: 简德群
 * Date: 2017/11/22
 * Time: 10:22
 * To change this template use File | Settings | File Templates.
 */
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    /**
     * Element 对应的元素User
     * @param element
     * @return
     */
    protected Class getBeanClass(Element element){
        return User.class;
    }

    /**
     * 从element元素中提取对应元素的值
     * @param element
     * @param builder
     */
    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String username = element.getAttribute("userName");
        String email = element.getAttribute("email");
        if(StringUtils.hasText(username)){
            builder.addPropertyValue("userName",username);
        }
        if(StringUtils.hasText(email)){
            builder.addPropertyValue("email",email);
        }
    }

}