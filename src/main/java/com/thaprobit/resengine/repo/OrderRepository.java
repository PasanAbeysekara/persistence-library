package com.thaprobit.resengine.repo;

import com.thaprobit.resengine.dao.Orders;
import com.thaprobit.resengine.dao.key.OrderID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, OrderID> {

    @Query(value = "SELECT MAX(o.order_id) AS maxOrderId, MAX(oc.order_ch_sub_id) AS maxOrderChoiceSubId FROM orders o INNER JOIN order_choices oc ON o.order_id = oc.order_id",  nativeQuery = true)
    List<Long[]> findMaxOrderIds();


}

