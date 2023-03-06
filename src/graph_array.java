import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class graph_array {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine()); //정점의 수
        int M = Integer.parseInt(bf.readLine()); //간선의 수

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) { //정점의 수 만큼 리스트 생성해준다. - 0번은 사용 안함
            graph.add(new ArrayList<>());
        }
        StringTokenizer st;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
        }

        for(int i = 1; i <= N; i++){
            graph.get(i).sort(Comparator.naturalOrder()); //오름차순 정렬
            System.out.println("정점"+i+" : "+graph.get(i).toString());
        }
    }
}
