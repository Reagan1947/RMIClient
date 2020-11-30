import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ModelImpl extends UnicastRemoteObject implements Model{

    public ModelImpl() throws RemoteException {
        super();
    }

    @Override
    public void initData() {

    }

    @Override
    public boolean addCar(Car car) throws RemoteException {
        return false;
    }
}
