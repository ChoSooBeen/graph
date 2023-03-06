package LinkedList_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class graph_link {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine()); //정점의 수
        int M = Integer.parseInt(bf.readLine()); //간선의 수

        graphList g = new graphList(N);
        StringTokenizer st;
        int tmp[][] = new int[M*2][2];
        for(int i = 0; i < M*2; i += 2){
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            //후에 정렬을 위해 임시 저장
            //무방향 그래프 이므로 양쪽 방향 저장
            tmp[i][0] = x;
            tmp[i][1] = y;
            tmp[i+1][0] = y;
            tmp[i+1][1] = x;
        }
        //인접 리스트를 오름차순으로 표현하기 위해
        //입력시 v2(=tmp[][1])를 내림차순으로 정렬한다.
        Arrays.sort(tmp, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o2[1] - o1[1]; //내림차순 정렬
                }
                else {
                    return o1[0] - o2[0];
                }
            }
        });
        for(int i = 0; i < M*2; i++) {
            g.insertEdge(tmp[i][0],tmp[i][1]);
        }
        g.printGraph();
        System.out.println("\n");

        g.DFS(1, N);
    }
}
