package buoi2;

import java.util.Objects;

public class Person {
    public static String TEN_TRUONG_CAP_HAI;
    public String ten;

    // quy định lại cách xử lý của hàm equals với person
    @Override
    public boolean equals(Object obj) {
        // Quy định hai đối tượng có cùng
        // tên => đó là giống nhau
//        if (obj instanceof Person){
//            return this.ten.equals(((Person) obj).ten);
//        }
        return super.equals(obj);
    }

    /**
     mặc định theo java thì sẽ hash địa chỉ ô
     nhớ thành 1 con số int, nếu hai object được gọi
     hàm hashCode trả ra cùng 1 con số int
     => nó nằm cùng trong ô nhớ
     equals, hashCode được sử dụng khi thêm 1 phần
     tử vào Set, HashSet, Array... Collection
     */
    @Override
    public int hashCode() {
        return Objects.hash(ten);
    }
}
