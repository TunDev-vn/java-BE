package buoi9.demo1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        // thêm các phần tử vào stack
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");

        // Hien thi casc phan tu
        for (String s : stack) {
            System.out.println(s);
        }
        System.out.println("size: " + stack.size());
        System.out.println("Lay phan tu o dinh: ");
        System.out.println(stack.pop());
        System.out.println("size: " + stack.size());
        System.out.println("Lay phan tu o dinh, khong xoa");
        System.out.println(stack.peek());
        System.out.println("size: " + stack.size());

        Queue<String> queue = new LinkedList<>();
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");
        queue.offer("D");
        System.out.println("Hien thi queue: ");
        for (String s : queue) {
            System.out.println(s);
        }
        System.out.println("size: " + queue.size());
        System.out.println("Lấy phan tu dau tien: ");
        System.out.println(queue.poll());
        System.out.println("size: " + queue.size());
        System.out.println("aay ra phan tu ma khong xoa: ");
        System.out.println(queue.peek());
        System.out.println("size: " + queue.size());

    }
}
