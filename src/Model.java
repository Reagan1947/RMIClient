import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Model extends Remote{
    public void initData();

    public boolean addCar(Car car) throws RemoteException;

    public boolean addReceipt(Receipt receipt);
}
