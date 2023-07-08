package pro.sky.skyproSpring.Service;

import java.util.Set;

public interface ServicePurchase {
    public void addPurchase(Integer...id);

    public Set<Integer> getPurchase();

    public void deStroy();
}
