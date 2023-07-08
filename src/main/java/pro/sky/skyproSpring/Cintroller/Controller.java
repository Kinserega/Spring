package pro.sky.skyproSpring.Cintroller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pro.sky.skyproSpring.Service.ServicePurchase;

import java.util.Set;

@RestController
@RequestMapping("/store/order")
public class Controller {
    private final ServicePurchase servicePurchase;

    public Controller(ServicePurchase servicePurchase) {
        this.servicePurchase = servicePurchase;
    }

    @GetMapping(path = "/add")
    public void add(@RequestParam(name = "id") Integer... id) {
        if (servicePurchase.getPurchase().contains(id)) {
            throw new ResponseStatusException(HttpStatus.IM_USED, "Такой товар уже имеется");
        }
        servicePurchase.addPurchase(id);
    }

    @GetMapping(path = "/get")
    public Set<Integer> get() {
        if (servicePurchase.getPurchase().isEmpty()) {
            throw new ResponseStatusException((HttpStatus.I_AM_A_TEAPOT), "Корзин пустая");
        }
        return servicePurchase.getPurchase();
    }
}
