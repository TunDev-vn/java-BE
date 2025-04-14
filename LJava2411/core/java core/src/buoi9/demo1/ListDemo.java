package buoi9.demo1;

/*
T: định nghĩa generic, giúp interface này
có thể triển khai với mọi lại kiểu dữ liệu
 */
public interface ListDemo<T>{

    boolean add(T t);
    boolean remove(T t);
    boolean contains(T t);
    int size();
    T get(int index);
}
