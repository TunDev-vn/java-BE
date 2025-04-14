package vn.com.t3h.antino.util;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

public class MapClientToSeverUtil {

    public static <T> T toModel(Class<T> tClass, HttpServletRequest request) {
        try {
            //tao 1 doi tuong moi voi kieu T de map gia tri cac thuoc tinh
            T object = tClass.newInstance();
            BeanUtils.populate(object, request.getParameterMap());

            return object;
        } catch (InstantiationException e) {
            return null;
        } catch (IllegalAccessException e) {
            return null;
        } catch (InvocationTargetException e) {
            return null;
        }
    }
}
