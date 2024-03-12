package product.controller;

import product.model.Product;
import product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for the gestion of the products.
 */
@RestController
public class ProductController {

    /**
     * The service for the action on the products.
     */
    @Autowired
    ProductService productService;

    /**
     * Method to search all products.
     * @return a list of products.
     */
    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    /**
     * Method to create a product.
     * @param productToCreate the product to create.
     * @return a string with what happened during the creation.
     */
    @PostMapping("/products")
    public String createProduct(@RequestBody Product productToCreate){
        return productService.createProduct(productToCreate);
    }

    /**
     * Method to get a product from it's id.
     * @param productId the id of the product.
     * @return a product given from the id.
     */
    @GetMapping("/products/{productId}")
    public Product getProduct(@PathVariable int productId){
        return productService.getProduct(productId);
    }

    /**
     * Method to update a product from the body of the request and it's id to identify the product to update.
     * @param productId the id of the product.
     * @param productToUpdate the product to update.
     * @return a string with what happened during the modification.
     */
    @PatchMapping("/products/{productId}")
    public String updateProduct(@PathVariable int productId, @RequestBody Product productToUpdate){
        if(productId != productToUpdate.getId()){
            return "The product id as a path variable and the product to update are different.";
        }
        return productService.updateProduct(productId, productToUpdate);
    }

    /**
     * Method to delete a product from it's id given in the path.
     * @param productId the id of the product.
     * @return a string with what happened during the modification.
     */
    @DeleteMapping("/products/{productId}")
    public String deleteProduct(@PathVariable int productId){
        return productService.deleteProduct(productId);
    }
}
