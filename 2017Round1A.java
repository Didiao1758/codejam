# codejam

import java.util.*;
import java.io.*;


public class CodeJam {

    public static void helper(char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        if(n == 0) return;
        for(int i = 0; i < n; ++ i){
            int j = 0;
            for(; j < m; ++ j){
                if(grid[i][j] != '?')break;
            }
            int cur = j;
            if(cur == m) continue;
            for(j = 0; j < m; ++ j){
                if(grid[i][j] == '?'){
                    grid[i][j] = grid[i][cur];
                }else if(grid[i][j] != grid[i][cur]){
                    cur = j;
                }
            }
        }
        for(int j = 0; j < m; ++ j){
            int i = 0;
            for(; i < n; ++ i){
                if(grid[i][j] != '?') break;
            }
            int cur = i;
            if(cur == n) continue;
            for(i = 0; i < n; ++ i){
                if(grid[i][j] == '?'){
                    grid[i][j] = grid[cur][j];
                }else if(grid[i][j] != grid[cur][j]){
                    cur = i;
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        System.out.println("process begin");
        String inputPath = "./case/A-large-practice.in";
        String outPath = "./output/A-large-practice.out";
//        Scanner in = new Scanner(new BufferedReader(new FileReader(inputPath)));
        Scanner in = new Scanner(new BufferedReader(new FileReader(inputPath)));
        String line = in.nextLine();
        int n = Integer.valueOf(line);
        BufferedWriter fw = new BufferedWriter(new FileWriter(outPath));
//        FileWriter fw = new FileWriter(outPath);
        for(int i = 0; i < n; ++ i){ // n test cases
            fw.write(String.format("Case #%d:\n", i+1));
            line = in.nextLine();
            String[] rowCols = line.split(" ");
            int row = Integer.valueOf(rowCols[0]);
            int col = Integer.valueOf(rowCols[1]);
            char[][] grid = new char[row][col];
            for(int j = 0; j < row; ++ j){
                String s = in.nextLine();
                for(int k = 0; k < col; ++ k){
                    grid[j][k] = s.charAt(k);
                }
            }
            helper(grid);
            for(int j = 0; j < row; ++ j){
                fw.write(grid[j]);
                fw.write("\n");
            }

        }
        fw.flush();
        fw.close();
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("process end, use %d  s", endTime-startTime));
    }
}
