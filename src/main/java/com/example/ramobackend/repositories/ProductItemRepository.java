package com.example.ramobackend.repositories;

import com.example.ramobackend.model.ProductItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductItemRepository extends CrudRepository<ProductItem, Long> {
    ProductItem findAllByProductTypeName(String productName);
    ProductItem findProductItemByProductItemNumber(Integer productItemNumber);
    boolean existsByProductItemNumber(Integer productItemNumber);

    @Query("SELECT e FROM ProductItem e WHERE " +
            "(:productId IS NULL OR e.productId = :productId) AND " +
            "(:brand IS NULL OR e.brand IN :brand) AND " +
            "(:color IS NULL OR e.color IN :color) AND " +
            "(:type IS NULL OR e.type IN :type) AND " +
            "(:serie IS NULL OR e.serie IN :serie) AND " +
            "(:hight IS NULL OR e.hight IN :hight) AND " +
            "(:width IS NULL OR e.width IN :width) AND " +
            "(:depth IS NULL OR e.depth IN :depth) ")
    List<ProductItem> findAllWithFilters(@Param("productId") Long productId, @Param("brand") List<String> brand,
                                         @Param("color") List<String> color, @Param("type") List<String> type,
                                         @Param("serie") List<String> serie, @Param("hight") List<Integer> hight,
                                         @Param("width") List<Integer> width, @Param("depth") List<Integer> depth);

}
