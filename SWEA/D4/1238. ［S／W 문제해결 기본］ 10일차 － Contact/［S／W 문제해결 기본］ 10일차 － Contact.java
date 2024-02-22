import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static class Call{
		int who;
		int cnt;
		Call(int who, int cnt){
			this.who = who;
			this.cnt = cnt;
		}
	}
	
	public static class Node{
		ArrayList<Integer> list;
		Node(){
			this.list = new ArrayList<>();
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc = 1;tc<=10;tc++) {
			StringTokenizer stz = new StringTokenizer(br.readLine()," ");
			int leng = Integer.parseInt(stz.nextToken());
			int snum = Integer.parseInt(stz.nextToken());
			Node[] nodes = new Node[101];
			boolean[] bcheck = new boolean[101];
			
			for(int i=0;i<101;i++) {
				nodes[i]= new Node();
			}
			
			stz = new StringTokenizer(br.readLine());
			for(int i=0;i<leng;i+=2) {
				int from = Integer.parseInt(stz.nextToken());
				int to = Integer.parseInt(stz.nextToken());
				
				nodes[from].list.add(to);
			}
			
			Queue<Call> que = new ArrayDeque<>();
			que.offer(new Call(snum, 0));
			bcheck[snum] = true;
			int answercnt = 0;
			int answernum = 0;
			
			while(!que.isEmpty()) {
				Call call = que.poll();
				if(call.cnt>answercnt) {
					answercnt = call.cnt;
					answernum = call.who;
					if(answernum<call.who) {
						answernum = call.who;
					}
				}
				else if(call.cnt==answercnt) {
					if(answernum<call.who) {
						answernum = call.who;
					}
				}
				for(int i=0;i<nodes[call.who].list.size();i++) {
					if(bcheck[nodes[call.who].list.get(i)])
						continue;
					bcheck[nodes[call.who].list.get(i)] = true;
					que.offer(new Call(nodes[call.who].list.get(i), call.cnt+1));
				}
			}
			sb.append("#").append(tc).append(" ");
			sb.append(answernum).append("\n");
		}
		System.out.print(sb);
	}

}
