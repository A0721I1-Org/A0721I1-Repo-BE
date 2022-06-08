package projecta07.service;

import projecta07.model.OrderDetail;

import java.util.List;
import java.util.Optional;

public interface IOrderDetailService {
    Iterable<OrderDetail> findAll();
    Optional<OrderDetail> findById(Long id);
    OrderDetail save(OrderDetail orderDetail);
    void delete(Long id);
    List<OrderDetail> findTest();
}
