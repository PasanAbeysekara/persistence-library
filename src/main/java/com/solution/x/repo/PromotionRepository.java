package com.solution.x.repo;

import com.solution.x.dao.Promotion;
import com.solution.x.dao.key.PromoID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Tharinda Wickramaarachchi
 * @since 6/2/2020 1:34 PM
 */
public interface PromotionRepository extends JpaRepository<Promotion, PromoID>
{
	//SELECT coalesce( max( promo_id ) + 1 , 0) AS next_promo_id FROM hngout.promotions where prop_id = 1;

	@Query(value = "SELECT coalesce( max( promo_id ) + 1 , 0) AS next_promo_id FROM {h-schema}promotions where prop_id =:propId", nativeQuery = true)
	Short nextPromoId( @Param("propId") Long propId );

	@Query(value = "SELECT * FROM {h-schema}promotions p where p.prop_id =:propId and p.live =:status", nativeQuery = true)
	List<Promotion> findLivePromotions( @Param("propId") Long propId, @Param("status") Boolean status );

	@Query(value = "SELECT * FROM {h-schema}promotions p where p.prop_id =:propId", nativeQuery = true)
	List<Promotion> findAllPromotionsByPropId( @Param("propId") Long propId );
}
