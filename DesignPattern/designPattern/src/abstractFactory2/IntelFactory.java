package abstractFactory2;

import abstractFactory1.Cpu;
import abstractFactory1.IntelCpu;
import abstractFactory1.IntelMainboard;
import abstractFactory1.Mainboard;

public class IntelFactory implements AbstractFactory {

    @Override
    public Cpu createCpu() {
        // TODO Auto-generated method stub
        return new IntelCpu(755);
    }

    @Override
    public Mainboard createMainboard() {
        // TODO Auto-generated method stub
        return new IntelMainboard(755);
    }

}