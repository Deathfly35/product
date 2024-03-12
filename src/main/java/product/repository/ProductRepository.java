package product.repository;

import product.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for the products to handle database actions.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
