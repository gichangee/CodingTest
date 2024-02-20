import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static class Map{
        int y;
        int x;
        int[] lengarr;   // 치킨집들의 거리!
        public Map(){
            this.y = 0;
            this.x = 0;
        }

        public Map(int y,int x){
            this.y = y;
            this.x = x;
            lengarr = new int[rN*rN];
        }
    }

    /**
     * 치킨 거리 = 집과 가장 가까운 치킨집사이의 거리!
     * 도시의 치킨 거리 - 모든 집의 치킨 거리의 합!
     * 도시의 치킨집 중에서 가장 수익을 많이 낼 수 있는 치킨집의 개수는 최대 M개
     * 나머지 폐업!
     * 도시의 치킨거리가 가장 작게되는 값은?
     * @param args
     */

    public static int[] choice;
    public static int rN=0,rM=0;
    public static int min_CityChicke=2550;
    public static ArrayList<Map> Chickenlist = new ArrayList<>();
    public static ArrayList<Map> Homelist = new ArrayList<>();
    public static boolean[] bmap;
    public static int[] imap;

    /**
     * 치킨거리 경우의 수
     * @param depth 현재선택한 치킨집!
     * @param i 탐색시작할 범위!
     */
    public static void chicken(int depth, int i){

        if(depth >= rM){
            int total = 0;
            for(int j=0;j<Homelist.size();j++){
                //선택된 치킨집 중에서 가장 작은 값 선택
                int mind = 9999;
                for(int k=0;k<depth;k++){
                    int getD = Homelist.get(j).lengarr[imap[k]];
                    if(mind>getD)
                        mind=getD;
                }
                total += mind;
            }
            if(total<min_CityChicke)
                min_CityChicke = total;
            return;
        }

        for(;i<Chickenlist.size();i++){
            if(bmap[i]){
                continue;
            }
            bmap[i] = true;
            imap[depth] = i;
            chicken(depth+1, i+1);
            bmap[i] = false;
        }

    }


    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer stz = new StringTokenizer(str);
        rN = Integer.parseInt(stz.nextToken());
        rM = Integer.parseInt(stz.nextToken());

        for(int i=0;i<rN;i++){
            str = br.readLine();
            stz = new StringTokenizer(str);
            for(int j=0;j<rN;j++){
                int nd = Integer.parseInt(stz.nextToken());
                if(nd == 1){
                    Map mmap = new Map(i,j);
                    Homelist.add(mmap);
                }
                else if(nd == 2){
                    Map mmap = new Map(i,j);
                    Chickenlist.add(mmap);
                }
            }
        }
        bmap = new boolean[Chickenlist.size()];
        imap = new int[Chickenlist.size()];

        //각 집별로 치킨집의 거리 계산해놓기!
        for(int i=0;i<Homelist.size();i++){
            for(int j=0;j<Chickenlist.size();j++){
                Homelist.get(i).lengarr[j] =
                        Math.abs(Homelist.get(i).y - Chickenlist.get(j).y) +
                        Math.abs(Homelist.get(i).x - Chickenlist.get(j).x);
            }
        }

        //집리스트, 치킨리스트 짯으면 해당 길이에 맞는 모든 경우의수 체크할것!
        chicken(0,0);
        System.out.print(min_CityChicke+"\n");
    }
}
