import java.util.Arrays;

public class Graph {
    
    public int[] vertices;
    
    public Graph(int n) {
        this.vertices = new int[n];
        for (int i = 0; i < n; i++) {
            vertices[i] = i;
        }
    }

    public boolean createComponent(int i, int j) {
        if ((i < vertices.length || j < vertices.length)) {
            int save = vertices[i];
            vertices[i] = j;
            for (int k = 0; k < vertices.length; k++) {
                if (vertices[k] == save) {
                    return createComponent(k, j);
                }
            }
            if (vertices[j] != j) {
                save = vertices[j];
                for (int k = 0; k < vertices.length; k++) {
                    if (vertices[k] == save) {
                        return createComponent(k, j);
                    }
                }
            }
        }
        return false;
    }

    public String edgeNeed(int i, int j) {
        if (vertices[i] != vertices[j]) {
            createComponent(i, j);
            return "(" + i + ", " + j + ")";
        }
        return null;
    }

    @Override
    public String toString() {
        return Arrays.toString(vertices);
    }
}
