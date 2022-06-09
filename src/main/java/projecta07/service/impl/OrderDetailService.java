package projecta07.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projecta07.model.OrderDetail;
import projecta07.repository.IOrderDetailRepository;
import projecta07.service.IOrderDetailService;

import java.util.List;

@Service
public class OrderDetailService implements IOrderDetailService {
    @Autowired
    private IOrderDetailRepository orderDetailRepository;

    /* get Order Detail by Order Id*/
    public List<OrderDetail> getOrderDetailsByOrderId(Long id) {
        return this.orderDetailRepository.getOrderDetailsByOrderId(id);
    }

    public OrderDetail save(OrderDetail orderDetail) {
        return this.orderDetailRepository.save(orderDetail);
    }
}