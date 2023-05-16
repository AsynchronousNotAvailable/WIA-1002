public class T9Q3{
    public static void main(String[] args) {
        Graph <Character, Integer> g = new Graph<>();
        char [] vertices = {'A', 'B', 'C' , 'D', 'E', 'F', 'G', 'H', 'I'};
        char [][] edges = { {'C', 'D'}, {'D'}, {'A', 'E', 'F'}, {'A', 'B', 'E'}, {'C', 'D', 'G'}, {'C', 'H'}, {'E', 'H'}, {'F', 'G', 'I'}, {'H'}};
        for(int i = 0; i < vertices.length; i++){
            g.addVertex(vertices[i]);

        }

        for(int j = 0; j < edges.length; j++){
            for(int k = 0; k < edges[j].length; k++){
                g.addEdge(vertices[j], edges[j][k], 1);
            }
        }

        g.printEdge();

    }

}

class Vertex <T extends Comparable<T>, N extends Comparable<N>>{
    T vertexInfo;
    int inDeg;
    int outDeg;
    Vertex<T, N> nextVertex;
    Edge<T, N> firstEdge;

    public Vertex(){
        vertexInfo = null;
        inDeg = outDeg = 0;
        nextVertex = null;
        firstEdge = null;
    }

    public Vertex(T vInfo, Vertex<T, N>next){
        vertexInfo = vInfo;
        inDeg = outDeg = 0;
        nextVertex = next;
        firstEdge = null;
    }

}

class Edge <T extends Comparable<T>, N extends Comparable<N>>{
    N weight;
    Vertex<T, N> toVertex;
    Edge<T, N> nextEdge;

    public Edge(){
        weight = null;
        toVertex = null;
        nextEdge = null;
    }

    public Edge(Vertex<T, N>destination, N w, Edge<T, N> next){
        toVertex = destination;
        weight = w;
        nextEdge = next;
    }
}
class Graph<T extends Comparable<T>, N extends Comparable<N>>{
    Vertex<T, N> head;
    int size;

    public Graph(){
        head = null;
        size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public boolean hasVertex(T target){
        if(head == null){
            return false;
        }
        Vertex<T, N> temp = head;
        while(temp != null){
            if(temp.vertexInfo.compareTo(target) == 0){
                return true;
            }
            temp = temp.nextVertex;
        }
        return false;
    }

    public boolean addVertex(T v){
        if (hasVertex(v)){
           return false;
        }
        Vertex<T, N> newVertex = new Vertex<>(v, null);
        if(head == null){
            head = newVertex;
            this.size++;
            return true;
        }
        Vertex <T, N> temp = head;
        while(temp.nextVertex != null){
            temp = temp.nextVertex;
        }
        temp.nextVertex = newVertex; //here need previous is because the temp would be null by the time the loop break, then cannot refer d
        this.size++;
        return true;
    }

    public boolean hasEdge(T source, T destination){
        if(!hasVertex(source) || !hasVertex(destination)){
            return false;
        }
        if (head == null){
            return false;
        }
        Vertex<T, N> src = head;
        while(src != null){
            if (src.vertexInfo.compareTo(source) == 0) {
                Edge <T, N> currentEdge = src.firstEdge;
                while(currentEdge != null){
                    if(currentEdge.toVertex.vertexInfo.compareTo(destination) == 0){
                        return true;
                    }
                    currentEdge = currentEdge.nextEdge;
                }
            }
            src = src.nextVertex;
        }
        return false;
    }

    public boolean addEdge(T source, T destination, N w){
        if(head == null){
            return false;
        }
        if(!hasVertex(source) || !hasVertex(destination)){
            return false;
        }
        Vertex<T, N> src = head;
        while(src != null){
            if(src.vertexInfo.compareTo(source) == 0){
//                System.out.println("vertices: " +src.vertexInfo);
                Vertex <T, N> dest = head;
                while(dest != null){
                    if(dest.vertexInfo.compareTo(destination) == 0){
                        Edge<T, N> currentEdge = src.firstEdge;
                        Edge<T, N> newEdge = new Edge<>(dest, w, currentEdge);
                        src.firstEdge = newEdge;
                        src.outDeg++;
                        dest.inDeg++;
                        return true;
                    }
                    dest = dest.nextVertex;
                }
            }
            src = src.nextVertex;
        }
        return false;
    }

    public void printEdge(){
        Vertex<T, N> temp = head;
        while(temp != null){
            System.out.print("# "+ temp.vertexInfo + ": ");
            Edge<T, N> currentEdge = temp.firstEdge;
            while(currentEdge != null){
                System.out.print("[" + currentEdge.toVertex.vertexInfo + "] ");

                currentEdge = currentEdge.nextEdge;
            }
            System.out.println();
            temp = temp.nextVertex;
        }
    }

    public void showVertex(){
        Vertex<T, N> temp = head;
        while (temp != null) {
            System.out.println(temp.vertexInfo);
            temp = temp.nextVertex;
        }
    }

}


