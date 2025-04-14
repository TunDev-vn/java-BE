package buoi10.btvn;

import java.util.*;
import java.util.stream.Collectors;

public class StudentManager {

    private List<Student> students;

    public StudentManager() {
        // khoi tao danh sach students
        this.students = new ArrayList<Student>();
    }

    /*
    1.	Thêm sinh viên: Người dùng nhập thông tin sinh viên (ID, tên, điểm)
    và hệ thống kiểm tra nếu sinh viên đã tồn tại trong hệ thống (kiểm tra theo ID) để tránh trùng lặp.
    Nếu sinh viên đã tồn tại, hệ thống sẽ ném ra một ngoại lệ.
     */
    public void add() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao thong tin sinh vien muon them: ");
        System.out.println("Nhap vao id: ");
        String id = sc.nextLine();
        // kiem tra su ton tai
        Set<String> setId = this.students.stream().map(Student::getId).collect(Collectors.toSet());
        if (setId.contains(id)){
            throw new CustomException("id is exist");
        }
        Student student = new Student();
        student.setId(id);
        student.enterInfo();
        this.students.add(student);
        System.out.println("Them hoc sinh thanh cong");
    }
    /*
    2.	Xóa sinh viên: Xóa sinh viên khỏi danh sách dựa trên mã số sinh viên.
    Nếu mã số không tồn tại trong danh sách, hệ thống sẽ ném ra một ngoại lệ.
     */
    public void remove() {
        System.out.println("Nhap vao id xoa");
        String id = new Scanner(System.in).nextLine();
        // Tim sinh vien
        Student studentRemove = this.students.stream()// Bien list student thanh 1 stream
                .filter(student -> student != null && id.equalsIgnoreCase(student.getId()))// tim student voi id
                .findFirst() // lấy ra student đầu tiên nếu tồn tại qua bước filter
                .orElseThrow(() -> new CustomException("Student is not exist")); // nếu không tồn tại => bắn ra exception
        students.remove(studentRemove);
        System.out.println("Xoa sinh vien thanh cong");
    }
    /*
    3.	Hiển thị danh sách sinh viên: Hiển thị toàn bộ danh sách sinh viên hiện có. Sử dụng ArrayList để lưu trữ danh sách sinh viên.
     */
    public void showAll(){
        this.students.forEach(Student::showInfo); // hien thi danh sách sinh viên , Student::showInfo: method referent
    }
    /*
    4.	Tìm kiếm sinh viên theo tên: Cho phép tìm kiếm sinh viên theo tên. Nếu không tìm thấy sinh viên nào, hệ thống sẽ ném ra một ngoại lệ.
     */
    public void findByName(){
        System.out.println("Nhap vao ten sinh vien: ");
        String name = (new Scanner(System.in)).nextLine();
        List<Student> studentsTarget = this.students.stream() // Bien list student thanh 1 stream
                .filter(student -> student != null && name.equalsIgnoreCase(student.getName())) // tim student khac null và tên trùng với tên nhập vào
                .collect(Collectors.toList()); // tập hợp thành 1 danh sách và trả về
        if (studentsTarget.isEmpty()){
            throw new CustomException("Student is empty");
        }
        studentsTarget.forEach(Student::showInfo);
    }

    /*
    5.	Sắp xếp danh sách sinh viên theo điểm thi: Sắp xếp danh sách sinh viên theo điểm thi từ thấp đến cao.
    Nếu danh sách trống, hệ thống sẽ ném ra một ngoại lệ.
     */
    public void sortByPoint(){
        if (this.students.isEmpty()){
            throw new CustomException("Student is empty");
        }
        List<Student> studentsCopy = new ArrayList<>(this.students);
        studentsCopy.stream()
                .sorted((s1,s2) -> (int) (s1.getPoint() - s2.getPoint()))// sort by point
                .forEach(Student::showInfo); // show data
    }

    /*
    6.	Kiểm tra sinh viên có tồn tại không: Kiểm tra xem sinh viên có tồn tại trong hệ thống hay không dựa trên mã số sinh viên.
     */
    public void checkExist(){
        System.out.println("Nhap vao id kiem tra");
        String id = new Scanner(System.in).nextLine();
        // Tim sinh vien
        Student studentTarget = this.students.stream()// Bien list student thanh 1 stream
                .filter(student -> student != null && id.equalsIgnoreCase(student.getId()))// tim student voi id
                .findFirst() // lấy ra student đầu tiên nếu tồn tại qua bước filter
                .orElseThrow(() -> new CustomException("Student is not exist")); // nếu không tồn tại => bắn ra exception
        studentTarget.showInfo();
    }
}
