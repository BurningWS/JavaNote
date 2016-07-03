package visitor;
public class Mozi {
    
	public void ride(Horse h){
        System.out.println("骑马");
    }
    
    public void ride(BlackHorse bh){
        System.out.println("骑黑马");
    }
    
    public static void main(String[] args) {
        Horse bh = new BlackHorse();
        Mozi mozi = new Mozi();
        mozi.ride(bh);
    }

}