package in.eshwar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.eshwar.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

}
