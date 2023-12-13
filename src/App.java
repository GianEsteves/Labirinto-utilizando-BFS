
public class App {
    public static void main(String[] args) {
        int[][] labirinto = {
                { 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1 }
        };

        Ponto inicio = new Ponto(0, 0);
        Ponto fim = new Ponto(4, 4);

        SolucaoLabirinto.BFS(labirinto, inicio, fim);
    }
}
