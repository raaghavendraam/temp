package node;

import java.util.Scanner;

public class linkedlist {
    public static void display(student temp){
        System.out.println();
        System.out.println("------------------------------");
        System.out.println("NAME:"+temp.name);
        System.out.println("ROLL NO:"+temp.roll);
        System.out.println("BRANCH:"+temp.branch);
        System.out.println("CGPA:"+temp.cgpa);
        System.out.println("------------------------------");
        System.out.println();
    }
    public static student findMin(student root) {
        while (root.left != null)
            root = root.left;
        return root;
    }
    public static student deleteBST(student root, int key) {
        if (root == null)
            return null;
    
        if (key < root.roll) {
            root.left = deleteBST(root.left, key);
        }
        else if (key > root.roll) {
            root.right = deleteBST(root.right, key);
        }
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            student successor = findMin(root.right);
            root.roll = successor.roll;
            root.name = successor.name;
            root.branch = successor.branch;
            root.cgpa = successor.cgpa;
    
            root.right = deleteBST(root.right, successor.roll);
        }
        return root;
    }        
    public static void inorder(student root){
        if(root==null) return;
        inorder(root.left);
        display(root);
        inorder(root.right);
    }
    public static void search(student root, int key) {
        if (root == null) {
            System.out.println("Record not found");
            return;
        }
        if (root.roll == key) {
            display(root);
            return;
        }
        if (key < root.roll)
            search(root.left, key);
        else
            search(root.right, key);
    }
    public static student insertion(student root,student s){
        if(root==null) return s;
        if(root.roll>s.roll) root.left = insertion(root.left, s);
        if(root.roll<s.roll) root.right = insertion(root.right, s);
        return root;
    }
    public static student delete(student head,int key){
        if(head == null) {
            return null;
        }
        if (head.roll == key)
            return head.next;
        student pre = null;
        student cur = head;
        while (cur != null && cur.roll != key) {
            pre = cur;
            cur = cur.next;
        }
        if (cur == null) {
            System.out.println("Record not found in linked list");
            return head;
        }
        pre.next=cur.next;
        cur.next = null;
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        student head = null;
        student root = null;
        boolean test = true;
        
        while(test)
        {   
            System.out.println("enter the choice");
            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
            case 1:{
                System.out.println("Insertion");
                System.out.println("enter the details");
                student s = new student();
                System.out.println("enter the name of the student");
                s.name = sc.nextLine();
                System.out.println("enter the roll number of the student");
                s.roll = sc.nextInt(); sc.nextLine();
                System.out.println("enter the branch of the student");
                s.branch = sc.nextLine();
                System.out.println("enter the CGPA of the student");
                s.cgpa = sc.nextDouble();
                s.next = null;
                s.left=null;
                s.right=null;
                root = insertion(root,s);
                if(head == null) head = s;
                else{
                    student temp =  head;
                    while(temp.next!=null) temp = temp.next;
                    temp.next = s;
                }
            }break;
        case 2:{
                System.out.println("Deletion in order of admission");
                if(head==null) {
                    System.out.println("record is empty");
                    break;
                }
                student temp = head;
                student pre = null;
                if(head.next==null){
                    System.out.println("deleted record is :");
                    root = deleteBST(root,head.roll);
                    display(head);
                    head = null;
                    break;
                } 
                while (temp.next!=null) {
                    pre= temp;
                    temp= temp.next;
                }
                pre.next = null;
                System.out.println("deleted record is :");
                display(temp);
                root = deleteBST(root,temp.roll);
                break;
            }
            case 3:{
                if(head==null){
                    System.out.println("list is empty");
                    break;
                }
                System.out.println("Displaying details of student in the order of admission");
                student temp = head;
                while (temp!=null) {
                    display(temp);
                    temp=temp.next;
                }
                break;
            }
            case 4:{
                System.out.println("Displaying details in the acsending order of ROLL NO");
                inorder(root);
                break;
            } 
            case 5:{
                System.out.println("Display details of perticular ROLL NO");
                System.out.println("enter the value of key");
                int key  = sc.nextInt();
                search(root,key);
                break;
            }
            case 6:{
                System.out.println("Delete on basis of ROLL NO");
                System.out.println("Enter the key");
                int key = sc.nextInt();
                root = deleteBST(root, key);
                head = delete(head,key);
                break;
            }
            case 7:
                test = false;
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
    
     }
    }
}
