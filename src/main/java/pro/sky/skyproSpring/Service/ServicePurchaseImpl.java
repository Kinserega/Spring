package pro.sky.skyproSpring.Service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
@SessionScope
public class ServicePurchaseImpl implements ServicePurchase {
    private Set<Integer> purchases = new HashSet<>();

    @Override
    public void addPurchase(Integer... id) {
        purchases.addAll(Arrays.asList(id));
    }

    @Override
    public Set<Integer> getPurchase() {
        return purchases;
    }

    @PreDestroy
    public void deStroy() {
        System.out.println("Instance dead!");
    }
}
