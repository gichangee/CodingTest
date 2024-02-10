import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Node[] t;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        t = new Node[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());


            char value = st.nextToken().charAt(0);
            char leftNode = st.nextToken().charAt(0);
            char rightNode = st.nextToken().charAt(0);

            // 현재 노드가 존재하지 않으면 생성
            if (t[value - 'A'] == null) {
                t[value - 'A'] = new Node(value);
            }

            // 왼쪽 자식 노드가 존재하면 생성 후 연결
            if (leftNode != '.') {
                t[leftNode - 'A'] = new Node(leftNode);
                t[value - 'A'].leftNode = t[leftNode - 'A'];
            }

            // 오른쪽 자식 노드가 존재하면 생성 후 연결
            if (rightNode != '.') {
                t[rightNode - 'A'] = new Node(rightNode);
                t[value - 'A'].rightNode = t[rightNode - 'A'];
            }
        }


        preorder(t[0]);
        System.out.println();
        inorder(t[0]);
        System.out.println();
        postorder(t[0]);

    }

    private static void postorder(Node n) {

        if (n == null) {
            return;
        }
        postorder(n.leftNode);
        postorder(n.rightNode);
        System.out.print(n.value);
    }

    private static void inorder(Node n) {
        if (n == null) {
            return;
        }
        inorder(n.leftNode);
        System.out.print(n.value);
        inorder(n.rightNode);
    }

    private static void preorder(Node n) {
        if (n == null) {
            return;
        }
        System.out.print(n.value);
        preorder(n.leftNode);
        preorder(n.rightNode);
    }
}

class Node {
    char value;
    Node leftNode;
    Node rightNode;

    Node(char value) {
        this.value = value;
    }
}