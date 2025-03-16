import java.io.*;
import java.util.*;

public class Main {

    static class State {
        int screen, clipboard, time;
        State(int screen, int clipboard, int time) {
            this.screen = screen;
            this.clipboard = clipboard;
            this.time = time;
        }
    }

    public static int bfs(int S) {
        boolean[][] visited = new boolean[1001][1001];
        Queue<State> queue = new LinkedList<>();
        
        queue.add(new State(1, 0, 0)); // 초기 상태 (화면 1개, 클립보드 0개, 시간 0초)
        visited[1][0] = true;

        while (!queue.isEmpty()) {
            State cur = queue.poll();

            if (cur.screen == S) return cur.time; // 목표 개수 도달 시 반환

            // 1. 복사 연산 (화면 -> 클립보드)
            if (!visited[cur.screen][cur.screen]) {
                queue.add(new State(cur.screen, cur.screen, cur.time + 1));
                visited[cur.screen][cur.screen] = true;
            }

            // 2. 붙여넣기 연산 (클립보드 -> 화면)
            if (cur.clipboard > 0 && cur.screen + cur.clipboard <= 1000 && !visited[cur.screen + cur.clipboard][cur.clipboard]) {
                queue.add(new State(cur.screen + cur.clipboard, cur.clipboard, cur.time + 1));
                visited[cur.screen + cur.clipboard][cur.clipboard] = true;
            }

            // 3. 삭제 연산 (화면에서 1개 삭제)
            if (cur.screen > 0 && !visited[cur.screen - 1][cur.clipboard]) {
                queue.add(new State(cur.screen - 1, cur.clipboard, cur.time + 1));
                visited[cur.screen - 1][cur.clipboard] = true;
            }
        }
        return -1; // 도달할 수 없는 경우 (문제 조건상 발생하지 않음)
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        System.out.println(bfs(S));
    }
}