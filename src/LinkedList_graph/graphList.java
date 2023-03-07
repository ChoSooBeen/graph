package LinkedList_graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class graphList {
    private gNode head[]; //정점의 리스트
    private int v; //현재 정점의 개수(=정점 중 가장 큰 수)
    public graphList(int n) {
        //정점은 1부터 시작한다.
        head = new gNode[n+1];
        v = n;
    }
    public void insertEdge(int v1, int v2) {
        if(v1 > v || v1 < 1 || v2 > v || v2 < 1){
            System.out.println("없는 정점입니다.");
        }
        else { //v1 -> v2
            gNode g_node = new gNode();
            g_node.vertex = v2;
            g_node.link = head[v1];
            head[v1] = g_node;
        }
    }
    public void printGraph() {
        gNode g_node = new gNode();
        for(int i = 1; i <= v; i++) {
            System.out.printf("\n정점 %d의 인접 리스트 ", i);
            g_node = head[i];
            while(g_node != null) {
                System.out.printf("-> %d", g_node.vertex);
                g_node = g_node.link;
            }
        }
    }

    public void DFS(int v, int n) { // v = 시작 정점, n = 정점의 수
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[n+1];

        // 탐색 시작 정점 v
        stack.push(v);
        visited[v] = true;
        System.out.print("DFS 탐색 순서: " + v);

        while (!stack.isEmpty()){
            gNode w = head[v]; //현재 탐색하고 있는 정점

            /**
             * w == null 이라는 것 = head[v] 리스트는 전부 탐색을 완료했다는 것
             * 즉, while 문이 종료되었다는 것은 현재 스택의 가장 위에 있는 값은 사용 완료했다는 의미이다.
             */
            while(w != null) {
                if(!visited[w.vertex]) {
                    stack.push(w.vertex);
                    visited[w.vertex] = true;
                    System.out.print(" -> " + w.vertex);
                    v = w.vertex;
                    w = head[v];
                }
                else {
                    w = w.link;
                }
            }
            //사용완료한 값(=가장 위의 값)은 제거하고
            stack.pop();
            //스택이 비어있지 않다면 현재 스택의 가장 위의 값을 v로 저장한다.
            if(!stack.isEmpty()) {
                v = stack.peek();
            }
        }
    }
    public void BFS(int v, int n){ //시작 정점 v, 정점의 개수 n
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[n+1]; // 방문 여부를 검사할 배열

        //탐색 시작 정점
        queue.offer(v); //enQueue()
        visited[v] = true;
        System.out.print("BFS 탐색 순서: " + v);

        while(!queue.isEmpty()) {
            v = queue.poll(); //deQueue()
            for(gNode w = head[v]; w != null; w = w.link){
                if(!visited[w.vertex]){
                    visited[w.vertex] = true;
                    queue.offer(w.vertex);
                    System.out.print(" -> " + w.vertex);
                }
            }
        }
    }
}
