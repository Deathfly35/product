package product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * Model for the products.
 */
@Entity
@Getter
@Setter
public class Product {

    /**
     * Id of the product.
     */
    @Id
    public int id;

    /**
     * Code of the product.
     */
    public String code;

    /**
     * Name of the product.
     */
    public String name;

    /**
     * Description of the product.
     */
    public String description;

    /**
     * Price of the product.
     */
    public float price;

    /**
     * Quantity of the product.
     */
    public float quantity;

    /**
     * Status of the inventory of the product
     */
    public String inventoryStatus;

    /**
     * Category of the product.
     */
    public String category;

    /**
     * Image of the product.
     */
    public String image;

    /**
     * Rating of the product.
     */
    public String rating;
}
