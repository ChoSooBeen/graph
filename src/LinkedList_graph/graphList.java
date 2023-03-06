package LinkedList_graph;

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

    public void DFS(int v) {

    }
}
