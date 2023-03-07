import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class graph_matrix {
    static void DFS(int[][] graph, int v) {
        //스택을 이용안 DFS
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[graph.length]; // 방문 여부를 검사할 배열

        //처음 검사할 노드 = v
        stack.push(v);
        visited[v] = true;
        System.out.print("DFS 탐색 순서 : " + v);

        //더 탐색할 인접정정이 없으면 false
        //즉, 현재 정점에서 모든 인접 정점을 방문했거나 인접 정점이 존재하지 않으면 false
        boolean flag = false;

        while(!stack.isEmpty()) {
            /**
             * peek() 연산은 스택의 top 부분에 있는 값을 삭제하지 않고 반해주는 연산
             * w = 현재 탐색 중인 정점
             */
            int w = stack.peek();
            flag = false;

            for(int i = 1; i < graph.length; i++) {
                //w의 인접 정점이 존재하고 그 정점 i를 방문하지 않았으면
                if(graph[w][i] == 1 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                    System.out.print(" -> " + i);
                    flag = true;
                    /**
                     * break 사용이유
                     * 1. for문 탈출
                     * 2. flag = ture 이므로 밑의 코드 실행 안함
                     * 3. 즉, while문을 반복하도록 만든다
                     *      -> 스택에 i를 push 해놓았으므로  다음 w = i가 된다.
                     */
                    break;
                }
            }
            //현재 노드에서 더이상 탐색할 노드가 없다면
            if(!flag) {
                stack.pop();
            }
        }
    }

    static void BFS(int[][] graph, int v) {
        //큐를 이용한 BFS
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[graph.length]; // 방문 여부를 검사할 배열

        //처음 탐색할 정점 v
        queue.offer(v);
        visited[v] = true;
        System.out.print("BFS 탐색 순서 : " + v);

        while(!queue.isEmpty()){
            int w = queue.poll();
            for(int i = 1; i < graph.length; i++) {
                if(graph[w][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    System.out.print(" -> " + i);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine()); //정점의 수
        int M = Integer.parseInt(bf.readLine()); //간선의 수

        int[][] graph = new int[N+1][N+1]; //그래프 인접 행렬로 구현
        StringTokenizer st;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            //무방향 그래프
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        DFS(graph, 1);
        System.out.println();

        BFS(graph, 1);
    }
}
