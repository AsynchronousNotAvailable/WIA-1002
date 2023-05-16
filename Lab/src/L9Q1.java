
public class L9Q1 {


}

class WeightedGraph<T extends Comparable<T>, N extends Comparable<N>>{
    Vertex<T, N> head;
    int size;

    private class Vertex<T extends Comparable<T>,  N extends Comparable<N>>{
        T vertexInfo;
        int inDeg;
        int outDeg;
        Vertex<T, N> nextVertex;
        Edge<T, N>firstEdge;

        public Vertex(){
            this(null, null);
        }

        public Vertex(T vInfo, Vertex<T, N>next){
            vertexInfo = vInfo;
            inDeg = 0;
            outDeg = 0;
            nextVertex = next;
            firstEdge = null;
        }


    }

    private class Edge<T extends Comparable<T>, N extends Comparable<N>>
    {
        N weight;
        Edge <T, N> nextEdge;
        Vertex<T, N>toVertex;

        public Edge(){
            this(null, null, null);
        }

        public Edge(Vertex<T, N> destination, N w, Edge<T, N> next){
            toVertex = destination;
            weight = w;
            nextEdge = next;
        }
    }

    public WeightedGraph(){
        head = null;
        size = 0;
    }

    public void clear(){
        head = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean hasVertex(T target){
        if(head == null){
            return false;
        }
        Vertex <T, N> temp = head;
        while (temp != null) {
            if(temp.vertexInfo.compareTo(target) == 0){
                return true;
            }
            temp = temp.nextVertex;
        }
        return false;
    }

    public boolean addVertex(T item){
        if(hasVertex(item)){
            return false;
        }
        Vertex<T, N>newV = new Vertex<>(item, null);
        if(head == null){
            head = newV;
        }
        else{
            Vertex<T, N> current = head;
            while(current.nextVertex != null){
                current = current.nextVertex;
            }
            current.nextVertex = newV;
        }
        size++;
        return true;
    }

    public boolean addEdge(T source, T destination, N w){
        if(!hasVertex(source) || !hasVertex(destination)){
            return false;
        }
        for(Vertex<T, N> sourceVertex = head; sourceVertex != null; sourceVertex = sourceVertex.nextVertex){
            if(sourceVertex.vertexInfo.compareTo(source) == 0){
                for(Vertex<T, N> dest = head; dest!=null; dest = dest.nextVertex){
                    if(dest.vertexInfo.compareTo(destination) == 0){
                        sourceVertex.firstEdge = new Edge(dest, w, sourceVertex.firstEdge);
                        sourceVertex.outDeg++;
                        dest.inDeg++;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean addUndirectedEdge(T source, T destination, N w) {
        if (!hasVertex(source) || !hasVertex(destination)) return false;

        for (Vertex<T, N> sourceVertex = head; sourceVertex != null; sourceVertex = sourceVertex.nextVertex)
            if (sourceVertex.vertexInfo.compareTo(source) == 0)
                for (Vertex<T, N> destinationVertex = head; destinationVertex != null; destinationVertex = destinationVertex.nextVertex)
                    if (destinationVertex.vertexInfo.compareTo(destination) == 0) {
                        sourceVertex.firstEdge = new Edge<>(destinationVertex, w, sourceVertex.firstEdge);
                        destinationVertex.firstEdge = new Edge<>(sourceVertex, w, destinationVertex.firstEdge);
                        sourceVertex.inDeg++;
                        sourceVertex.outDeg++;
                        destinationVertex.inDeg++;
                        destinationVertex.outDeg++;
                        return true;
                    }
        return false;
    }

    public boolean hasEdge(T source, T destination){
        if(!hasVertex(source) || !hasVertex(destination)){
            return false;
        }
        for(Vertex<T, N> current = head; current != null; current = current.nextVertex){
            if(current.vertexInfo.compareTo(source) == 0){
                for(Edge<T, N> currentEdge = current.firstEdge; currentEdge!=null; currentEdge = currentEdge.nextEdge){
                    if(currentEdge.toVertex.vertexInfo.compareTo(destination) == 0){
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
    public boolean removeEdge(T source, T destination){
        if(!hasEdge(source, destination)) return false;

        for(Vertex<T, N> sourceVertex = head; sourceVertex!= null; sourceVertex = sourceVertex.nextVertex){
            if(sourceVertex.vertexInfo.compareTo(source) == 0){
                for(Edge<T, N> currentEdge = sourceVertex.firstEdge; currentEdge.nextEdge!= null; currentEdge = currentEdge.nextEdge){
                    if(currentEdge.toVertex.vertexInfo.compareTo(destination) == 0){
                        currentEdge.nextEdge = currentEdge.nextEdge.nextEdge;
                        return true;
                    }
                }
            }
        }
        return false;
    }

}

