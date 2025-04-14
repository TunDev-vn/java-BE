package buoi13;

import java.lang.reflect.Field;

public class UserModel {

    private Integer id;
    private String username;
    private String password;
    private String fullName;
    private Boolean deleted;
    private Integer roleId;


    /*
    Sử dụng reflection
        + duyệt toàn bộ filed của class
        + set value cho toàn bộ field, dù cac field đang private
     */
    public static void main(String[] args) throws IllegalAccessException {
        UserModel userModel = new UserModel();
        System.out.println("value before: " + userModel.toString());
        // lay doi tuong class
        Class<?> clazz = userModel.getClass();
        // lấy ra danh sách tất cả các field
        Field[] allField = clazz.getDeclaredFields();
        for (Field field : allField) {
            // set = true để có tể chinh sủa được value cho dù đang private, và khong có getter, setter
            field.setAccessible(true);
            if (field.getName().equals("id")) {
                field.set(userModel,1);
            }
            if (field.getName().equals("username")) {
                field.set(userModel,"admin");
            }
            if (field.getName().equals("password")) {
                field.set(userModel,"123456");
            }
            if (field.getName().equals("fullName")) {
                field.set(userModel,"Kiennd");
            }
        }
        System.out.println("value after: " + userModel.toString());
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", deleted=" + deleted +
                ", roleId=" + roleId +
                '}';
    }
}
