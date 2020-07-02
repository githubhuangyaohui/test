package Game;
import java.util.Random;
public class Map {
    final static int xlength=16;
    final static int ylength=16;
    //创建地图中各个细胞
    public static Cell[][] Create(){
        Cell[][] cell=new Cell[xlength][ylength];
        for(int i=0;i<xlength;i++){
            for(int j=0;j<ylength;j++){
            	cell[i][j]=new Cell();
                Random ran=new Random();
                cell[i][j].setStatus(ran.nextInt(2));
            }
        }
        return cell;
    }
    
    //获取每个细胞周围的细胞存活数
    public static void getLivings(Cell[][] cell){
    	for(int i=0;i<xlength;i++) {
    		for(int j=0;j<ylength;j++) {
    			int living=0;
    			if(i>0&&j>0) living+=cell[i-1][j-1].getStatus();
    			if(i>0) living+=cell[i-1][j].getStatus();
    			if(j>0) living+=cell[i][j-1].getStatus();
    			if(i<xlength-1&&j<xlength-1) living+=cell[i+1][j+1].getStatus();
    			if(i<xlength-1) living+=cell[i+1][j].getStatus();
    			if(j<xlength-1) living+=cell[i][j+1].getStatus();
    			if(i<xlength-1&&j>0) living+=cell[i+1][j-1].getStatus();
    			if(i>0&&j<xlength-1) living+=cell[i-1][j+1].getStatus();
    			cell[i][j].setLiving(living);
    		}
    	}
    }
    //更新细胞状态
    public static int Update(Cell[][]cell){
    	int count=0;
        for(int i=0;i<xlength;i++){
            for(int j=0;j<ylength;j++){
            	int status=cell[i][j].getStatus();
    			cell[i][j].UpdateStatus();
    			if(status==cell[i][j].getStatus()) count++;
            }
        }
        return count;
    }
    //测试输出当前各个细胞的状态
    public static void Print(Cell[][]cell){
        for(int i=0;i<xlength;i++){
            for(int j=0;j<ylength;j++){
                System.out.print(cell[i][j].getStatus()+" ");
                System.out.println();
            }
        }
    }
}
