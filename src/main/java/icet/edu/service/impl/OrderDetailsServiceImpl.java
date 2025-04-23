package icet.edu.service.impl;

import icet.edu.dto.OrderDetail;
import icet.edu.entity.OrderDetailEntity;
import icet.edu.repository.OrderDetailRepository;
import icet.edu.service.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderDetailsServiceImpl implements OrderDetailService {


  final   private OrderDetailRepository orderDetailRepository;
  final   private ModelMapper orderDetailMapper;

    @Override
    public void createOrderDetail(OrderDetail orderDetail) {
      System.out.println("order detail service layer"+orderDetail);

        OrderDetailEntity orderDetailEntity = orderDetailMapper.map(orderDetail, OrderDetailEntity.class);
        orderDetailRepository.save(orderDetailEntity);

    }
}
