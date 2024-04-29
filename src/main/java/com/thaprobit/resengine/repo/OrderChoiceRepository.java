package com.thaprobit.resengine.repo;

import com.thaprobit.resengine.dao.OrderChoices;
import com.thaprobit.resengine.dao.key.OrderChoiceID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderChoiceRepository extends JpaRepository<OrderChoices, OrderChoiceID> {

}