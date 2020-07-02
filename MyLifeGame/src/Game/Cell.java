package Game;
import java.util.Random;
public class Cell {
    private int status;//细胞存活状态，0为死，1为生
    private int livings;//细胞周围的活细胞个数
    Random ran=new Random();
    Cell(){
        this.status=0;
        this.livings=0;
    }
    Cell(int status,int livings){
        this.status=status;
        this.livings=livings;
    }
    public int getStatus() {
        return status;//获取状态
    }
    public void setStatus(int status) {
      this.status=status;//设置状态
    }
    public int getLiving() {
        return this.livings;
    }
    public void setLiving(int livings) {
        this.livings=livings;//设置当前周围活细胞数目
    }
    public void UpdateStatus(){
           if(this.livings==3){
               this.status=1;
           }
           else if(this.livings==2){
           }
           else{
               this.status=0;
           }
    }
}
