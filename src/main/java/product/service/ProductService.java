package product.service;

import product.model.Product;
import product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service to handle the action on the products.
 */
@Service
public class ProductService {

    /**
     * Repository for the products.
     */
    @Autowired
    ProductRepository productRepository;

    /**
     * Method to get all products.
     * @return a list of products.
     */
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    /**
     * Method to create a product.
     * @param productToCreate the product to create.
     * @return a string with what happened during the creation.
     */
    public String createProduct(Product productToCreate){
        if(productRepository.findById(productToCreate.getId()).isPresent()){
            return "A product with the id " + productToCreate.getId() + " already exist.";
        }
        productRepository.save(productToCreate);
        return "Creation of a product with the id " + productToCreate.getId() + " done.";
    }

    /**
     * Method to get a product from it's id.
     * @param productId the id of the product.
     * @return a product given from the id.
     */
    public Product getProduct(int productId){
        Optional<Product> optionalProduct = productRepository.findById(productId);
        return optionalProduct.orElse(null);
    }

    /**
     * Method to update a product from the body of the request and it's id to identify the product to update.
     * @param productId the id of the product.
     * @param productToUpdate the product to update.
     * @return a string with what happened during the modification.
     */
    public String updateProduct(int productId, Product productToUpdate){
        if(productRepository.findById(productId).isEmpty()){
            return "No product with id " + productId + " exist.";
        }
        productRepository.save(productToUpdate);
        return "Modification of a product with the id " + productId + " done.";
    }

    /**
     * Method to delete a product from it's id given in the path.
     * @param productId the id of the product.
     * @return a string with what happened during the modification.
     */
    public String deleteProduct(int productId){
        if(productRepository.findById(productId).isEmpty()){
            return "No product with id " + productId + " exist.";
        }
        productRepository.deleteById(productId);
        return "Deletion of a product with the id " + productId + " done.";
    }
}
